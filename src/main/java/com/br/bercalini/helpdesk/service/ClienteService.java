package com.br.bercalini.helpdesk.service;

import com.br.bercalini.helpdesk.dto.ClienteDTO;
import com.br.bercalini.helpdesk.enums.Perfil;
import com.br.bercalini.helpdesk.model.Cliente;
import com.br.bercalini.helpdesk.model.Pessoa;
import com.br.bercalini.helpdesk.repository.ClienteRepository;
import com.br.bercalini.helpdesk.repository.PessoaRepository;
import com.br.bercalini.helpdesk.service.exeception.JdbcSQLIntegrityConstraintViolationException;
import com.br.bercalini.helpdesk.service.exeception.ObjetoNaoEncontrado;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public ClienteDTO findById(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ObjetoNaoEncontrado("Objeto não encontrado! ID : " + id));
        return new ClienteDTO(cliente);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Transactional
    public Cliente created(ClienteDTO clienteDTO) {
        validaSeExisteCPFCadastrado(clienteDTO);
        Cliente cliente = new Cliente(clienteDTO);
        cliente.addPerfil(Perfil.CLIENTE);
        cliente.setSenha(bCryptPasswordEncoder.encode(clienteDTO.getSenha()));
        return clienteRepository.save(cliente);
    }

    @Transactional
    public Cliente update(Long id, ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ObjetoNaoEncontrado("Objeto não encontrado! ID : " + id));
       // validaSeExisteCPFCadastrado(ClienteDTO);
        BeanUtils.copyProperties(clienteDTO, cliente, "id", "chamados", "data");
        return cliente;
    }

    @Transactional
    public void delete(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ObjetoNaoEncontrado("Objeto não encontrado! ID : " + id));
        if(cliente.getChamados().size() > 0) {
            throw new JdbcSQLIntegrityConstraintViolationException("Cliente possui ordem de serviço no sistema!");
        }else {
            clienteRepository.delete(cliente);
        }
    }

    private void validaSeExisteCPFCadastrado(ClienteDTO clienteDTO) {
        Optional<Pessoa> pessoa = pessoaRepository.findByCpf(clienteDTO.getCpf());
        if(pessoa.isPresent() && pessoa.get().getCpf() != clienteDTO.getCpf()) {
            throw new JdbcSQLIntegrityConstraintViolationException("CPF já cadastrado no sistema");
        }
        pessoa = pessoaRepository.findByEmail(clienteDTO.getEmail());
        if(pessoa.isPresent() && pessoa.get().getEmail() != clienteDTO.getEmail()) {
            throw new JdbcSQLIntegrityConstraintViolationException("Email já cadastrado no sistema");
        }
    }


}
