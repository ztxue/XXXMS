package com.ztxue.core.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author:sunping
 * @description:返回异常处理
 * @date:2020/5/20
 */
@Setter
@Getter
public class ResultRuntimeException extends RuntimeException {
    /**
     * 返回码
     */
    private final String code;
    /**
     * 返回提示消息
     */
    private final String message;

    public ResultRuntimeException(String message) {
        super(message);
        this.code = "200";
        this.message = message;
    }
    public ResultRuntimeException(String code, String message) {
        super(message);
        this.message = message;
        this.code = code;
    }
}
