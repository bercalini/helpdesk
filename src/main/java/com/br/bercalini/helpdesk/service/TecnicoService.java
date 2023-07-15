package com.br.bercalini.helpdesk.service;

import com.br.bercalini.helpdesk.dto.TecnicoDTO;
import com.br.bercalini.helpdesk.enums.Perfil;
import com.br.bercalini.helpdesk.model.Pessoa;
import com.br.bercalini.helpdesk.model.Tecnico;
import com.br.bercalini.helpdesk.repository.PessoaRepository;
import com.br.bercalini.helpdesk.repository.TecnicoRepository;
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
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public TecnicoDTO findById(Long id) {
        Tecnico tecnico = tecnicoRepository.findById(id).orElseThrow(() -> new ObjetoNaoEncontrado("Objeto não encontrado! ID : " + id));
        return new TecnicoDTO(tecnico);
    }

    public List<Tecnico> findAll() {
        return tecnicoRepository.findAll();
    }

    @Transactional
    public Tecnico created(TecnicoDTO tecnicoDTO) {
        validaSeExisteCPFCadastrado(tecnicoDTO);
        Tecnico tecnico = new Tecnico(tecnicoDTO);
        tecnico.addPerfil(Perfil.CLIENTE);
        tecnico.setSenha(bCryptPasswordEncoder.encode(tecnicoDTO.getSenha()));
        return tecnicoRepository.save(tecnico);
    }

    @Transactional
    public Tecnico update(Long id, TecnicoDTO tecnicoDTO) {
        Tecnico tecnico = tecnicoRepository.findById(id).orElseThrow(() -> new ObjetoNaoEncontrado("Objeto não encontrado! ID : " + id));
       // validaSeExisteCPFCadastrado(tecnicoDTO);
        BeanUtils.copyProperties(tecnicoDTO, tecnico, "id", "chamados", "data");
        return tecnico;
    }

    @Transactional
    public void delete(Long id) {
        Tecnico tecnico = tecnicoRepository.findById(id).orElseThrow(() -> new ObjetoNaoEncontrado("Objeto não encontrado! ID : " + id));
        if(tecnico.getChamados().size() > 0) {
            throw new JdbcSQLIntegrityConstraintViolationException("Tecnico possui ordem de serviço no sistema!");
        }else {
            tecnicoRepository.delete(tecnico);
        }
    }

    private void validaSeExisteCPFCadastrado(TecnicoDTO tecnicoDTO) {
        Optional<Pessoa> pessoa = pessoaRepository.findByCpf(tecnicoDTO.getCpf());
        if(pessoa.isPresent() && pessoa.get().getCpf() != tecnicoDTO.getCpf()) {
            throw new JdbcSQLIntegrityConstraintViolationException("CPF já cadastrado no sistema");
        }
        pessoa = pessoaRepository.findByEmail(tecnicoDTO.getEmail());
        if(pessoa.isPresent() && pessoa.get().getEmail() != tecnicoDTO.getEmail()) {
            throw new JdbcSQLIntegrityConstraintViolationException("Email já cadastrado no sistema");
        }
    }


}
