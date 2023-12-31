package com.br.bercalini.helpdesk.service.exeception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StantardError {
    protected Long timestamp;
    protected Integer status;
    protected String error;
    protected String message;
    protected String path;
}
