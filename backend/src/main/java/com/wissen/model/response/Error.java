package com.wissen.model.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Error {

    private String errorMessage;
    private String field;
}
