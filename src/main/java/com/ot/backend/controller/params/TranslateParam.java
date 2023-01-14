package com.ot.backend.controller.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TranslateParam {

    @ApiModelProperty(value = "번역할 한글")
    private String query;
}
