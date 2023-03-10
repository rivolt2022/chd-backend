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

    @ApiModelProperty(value = "번역된 영어")
    private String translation;

    @ApiModelProperty(value = "영어 답변")
    private String answer;

    @ApiModelProperty(value = "한글로 번역된 답변")
    private String answerTranslation;
}
