package com.ztxue.core.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author:sunping
 * @description:FeignException
 * @date:2021/1/19
 */
@Setter
@Getter
public class FeignException extends RuntimeException {

    /**
     * 返回码
     */
    private final int code;
    /**
     * 返回提示消息
     */
    private final String message;

    public FeignException(String message) {
        super(message);
        this.code = 500;
        this.message = message;
    }

    public FeignException(int code, String message) {
        super(message);
        this.message = message;
        this.code = code;
    }


}
