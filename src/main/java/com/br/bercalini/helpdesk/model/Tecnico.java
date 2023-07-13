package com.br.bercalini.helpdesk.model;

import java.util.ArrayList;
import java.util.List;

public class Tecnico extends Pessoa{
    private List<Chamado> chamados = new ArrayList<>();
}
