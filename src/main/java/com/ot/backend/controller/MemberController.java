package com.ot.backend.controller;

import com.ot.backend.component.HttpResultHelper;
import com.ot.backend.constants.ResourcePath;
import com.ot.backend.controller.params.MemberParam;
import com.ot.backend.domain.MemberDomain;
import com.ot.backend.po.Member;
import com.ot.backend.enums.ErrorType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api("Member")
@RestController
@RequestMapping(
        ResourcePath.API + ResourcePath.V1 + ResourcePath.MEMBERS)
public class MemberController {

    private final HttpResultHelper httpResultHelper;
    private final MemberDomain memberDomain;

    @Autowired
    public MemberController(HttpResultHelper httpResultHelper, MemberDomain memberDomain) {
        this.httpResultHelper = httpResultHelper;
        this.memberDomain = memberDomain;
    }

    @GetMapping("/detail")
    public ResponseEntity<Member> detail(@RequestParam(name="id", required = true) Long id) {
        try {
            Member member = memberDomain.findById(id);
            if(member != null) {
                return new ResponseEntity<>(member, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return httpResultHelper.errorResp(e, ErrorType.UNKNOWN, e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @ApiOperation(value = "Modify", httpMethod = "POST", response = Member.class)
    public ResponseEntity detail(@RequestBody MemberParam param) {
        try {
            return new ResponseEntity<>(this.memberDomain.create(param), HttpStatus.OK);
        } catch (Exception e) {
            // Return unknown error and log the exception.
            return httpResultHelper.errorResp(e, ErrorType.UNKNOWN, e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
