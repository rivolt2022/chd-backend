package com.ot.backend.config;

public enum ErrorInfo {
    NOT_FOUND                                      (10001, "해당 정보를 찾을 수 없습니다."),
    DUPLICATE                                      (10002, "해당 정보가 이미 있습니다."),
    ERROR                                          (10003, "정의되지 않은 에러 발생"),
    ;





    private final int code;
    private String message;

    ErrorInfo(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void replaceMessage(String... paramArr){
        String msg = message;
        for(int i = 0 ; i < paramArr.length; i++){
            msg = msg.replace("{"+i+"}", paramArr[i]);
        }
        this.message = msg;
    }

    public int getCode() {
        return code;
    }
    @Override
    public String toString() {
        return code + ": " + message;
    }
}
