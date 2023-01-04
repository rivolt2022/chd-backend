package com.ot.backend.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorVO implements Serializable {

    private static final long serialVersionUID = -7144407219523712074L;
    private String error;
    private String error_description;

    public ErrorVO(String error) {
        this.error = error;
    }
}
