package com.ot.backend.component;

import com.ot.backend.enums.ErrorType;
import com.ot.backend.vo.ErrorVO;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class HttpResultHelper {

    /**
     * Return success result.
     *
     * @param object some vo.
     * @return success response entity.
     */
    @SuppressWarnings("unchecked")
    public ResponseEntity successResp(Object object, HttpStatus httpStatus) {
        return new ResponseEntity(object, httpStatus);
    }

    /**
     * Return error information.
     *
     * @param errorType error type
     * @return response entity with information.
     */
    public ResponseEntity infoResp(ErrorType errorType, HttpStatus httpStatus) {
        return infoResp(errorType, errorType.description(), httpStatus);
    }

    /**
     * Return error information.
     *
     * @param errorType error type
     * @param msg       error message
     * @return response entity with information.
     */
    @SuppressWarnings("unchecked")
    public ResponseEntity infoResp(ErrorType errorType, String msg, HttpStatus httpStatus) {
        return new ResponseEntity(new ErrorVO(errorType.name(), msg), httpStatus);
    }

    /**
     * Return error information.
     *
     * @param logger Log
     * @param msg    error message
     * @return response entity with information.
     */
    @SuppressWarnings("unchecked")
    public ResponseEntity infoResp(Logger logger, ErrorType errorType, String msg,
                                   HttpStatus httpStatus) {
        return new ResponseEntity(new ErrorVO(errorType.name(), msg), httpStatus);
    }

    /**
     * Return error information, and log it to error.
     *
     * @param errorType error type
     * @param e         e
     * @return response entity with error message.
     */
    public ResponseEntity errorResp(Throwable e, ErrorType errorType,
                                    HttpStatus httpStatus) {
        return errorResp(e, errorType, errorType.description(), httpStatus);
    }

    @SuppressWarnings("unchecked")
    public ResponseEntity errorResp(Throwable e, ErrorType errorType, String msg,
                                    HttpStatus httpStatus) {
        return new ResponseEntity(new ErrorVO(errorType.name(), msg), httpStatus);
    }
}
