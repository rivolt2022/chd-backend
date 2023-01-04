package com.ot.backend.controller.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberParam {

    private static final long serialVersionUID = -9153801716112918626L;

    @ApiModelProperty(value = "사용자 이름(샘플)")
    private String name; // user's name

}
