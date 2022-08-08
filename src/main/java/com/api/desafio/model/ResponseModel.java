package com.api.desafio.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class ResponseModel {
    private String mensagem;
    private String ocorrencias;
    private String tempo;
}
