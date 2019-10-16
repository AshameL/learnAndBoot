package com.example.learn.web.dto;

import lombok.Data;
//import org.apache.http.HttpStatus;
import java.io.Serializable;

@Data
public class RspDTO<T> implements Serializable {
    private static int DUPLICATE_KEY_CODE = 1001;
    private static int PARAM_FAIL_CODE = 1002;
    private static int VALIDATION_CODE = 1003;

    private T data;
    private Integer code;
    private String msg;

    private static final long serialVersionUID = 1L;

    public RspDTO() {
    }

    public RspDTO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public static RspDTO paramFail(String msg) {
        return new RspDTO(PARAM_FAIL_CODE, msg);
    }

    public static RspDTO success() {
//        return new RspDTO(HttpStatus.SC_OK, "success");
        return new RspDTO(200, "success");
    }



}
