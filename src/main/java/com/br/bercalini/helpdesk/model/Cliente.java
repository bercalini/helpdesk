package com.br.bercalini.helpdesk.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa{
    private List<Chamado> chamados = new ArrayList<>();
}
