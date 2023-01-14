package com.ot.backend.controller;

import com.ot.backend.component.HttpResultHelper;
import com.ot.backend.constants.ResourcePath;
import com.ot.backend.controller.params.MemberParam;
import com.ot.backend.controller.params.TranslateParam;
import com.ot.backend.domain.MemberDomain;
import com.ot.backend.domain.TranslateDomain;
import com.ot.backend.enums.ErrorType;
import com.ot.backend.po.Member;
import com.ot.backend.po.Translate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api("Translate")
@RestController
@RequestMapping(
        ResourcePath.API + ResourcePath.V1 + ResourcePath.TRANSLATES)
public class TranslateController {

    private final HttpResultHelper httpResultHelper;
    private final TranslateDomain translateDomain;

    @Autowired
    public TranslateController(HttpResultHelper httpResultHelper, TranslateDomain translateDomain) {
        this.httpResultHelper = httpResultHelper;
        this.translateDomain = translateDomain;
    }

    @RequestMapping(value = "/translate", method = RequestMethod.POST)
    @ApiOperation(value = "Translate", httpMethod = "POST", response = Translate.class)
    public ResponseEntity translate(@RequestBody TranslateParam param) {
        try {
            // return null;
            return new ResponseEntity<>(this.translateDomain.create(param), HttpStatus.OK);
        } catch (Exception e) {
            // Return unknown error and log the exception.
            return httpResultHelper.errorResp(e, ErrorType.UNKNOWN, e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
