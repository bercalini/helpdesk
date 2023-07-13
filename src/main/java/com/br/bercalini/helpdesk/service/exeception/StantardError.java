package com.br.bercalini.helpdesk.service.exeception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StantardError {
    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
