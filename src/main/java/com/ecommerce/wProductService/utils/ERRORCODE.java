package com.ecommerce.wProductService.utils;

import java.util.HashMap;
import java.util.Map;

public enum ERRORCODE {

    SUCCESS("P000", "Success"),
    FAIL("P001", "Fail"),
    NORECORD("P002", "No record"),
    USERNOTFOUND("P003","User not found"),
    PASSWORDNOTMATHCED("P004","Password not matched"),
    USERNAMEORPASSWORDNOTCORRECT("P005", "UserName or Password not correct"),
    USERNAMEISEXIST("P006", "UserName is exist"),
    ACCOUNTISLOCKED("P007", "Account is locked"),
    BADREQUEST("P008", "Param request not valid"),
    TOKENNOTVALID("P009", "Token not valid");

    static Map<String, String> mapCodeMsg;

    static {
        mapCodeMsg = new HashMap<>();
        for(ERRORCODE err : values()) {
            mapCodeMsg.put(err.getErrorCode(),err.getMessage());
        }
    }

    public static String getMsgByCode(String code) {
        return mapCodeMsg.get(code);
    }

    private String errorCode;
    private String message;

    ERRORCODE(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
