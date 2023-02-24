package com.ot.backend.controller;

import com.ot.backend.component.HttpResultHelper;
import com.ot.backend.constants.ResourcePath;
import com.ot.backend.controller.params.TranslateParam;
import com.ot.backend.domain.TranslateDomain;
import com.ot.backend.enums.ErrorType;
import com.ot.backend.po.Translate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/translate/{id}")
    public ResponseEntity<Translate> findById(@PathVariable("id") Long id) {
        Translate translate = translateDomain.findById(id);
        if (translate != null) {
            return new ResponseEntity<>(translate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/query")
    public ResponseEntity<List<Translate>> findByQuery(@RequestParam String query) {
        List<Translate> translate = translateDomain.findByQuery(query);
        if (translate != null) {
            return new ResponseEntity<>(translate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/translate")
    @ApiOperation(value = "Translate", httpMethod = "POST", response = Translate.class)
    public ResponseEntity<Translate> translate(@RequestBody TranslateParam param) {
        try {
            return new ResponseEntity<>(this.translateDomain.create(param), HttpStatus.OK);
        } catch (Exception e) {
            // Return unknown error and log the exception.
            return httpResultHelper.errorResp(e, ErrorType.UNKNOWN, e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/translate/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        Translate translate = translateDomain.findById(id);
        if (translate != null) {
            translateDomain.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/translate/{id}/query")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Translate translate) {
        Translate currentTranslate = translateDomain.update(id, translate);
        return new ResponseEntity<>(currentTranslate, HttpStatus.OK);
    }

    @PutMapping("/translate/{id}/answer")
    public ResponseEntity updateAnswer(@PathVariable("id") Long id, @RequestBody Translate translate) {
        Translate currentTranslate = translateDomain.updateAnswer(id, translate);
        return new ResponseEntity<>(currentTranslate, HttpStatus.OK);
    }
}
