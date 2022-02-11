package com.ztxue.core.exception;

import com.ztxue.core.result.ResultEnum;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Configuration;

/**
 * @author:sunping
 * @description:
 * @date:2021/12/16
 */
@Configuration
public class ExceptionErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.body() != null) {
            return new HttpRuntimeException(response.status() + "", response.reason());
        } else {
            return new HttpRuntimeException(ResultEnum.FAIL500.getCode(), ResultEnum.FAIL500.getDesc());
        }
    }
}
