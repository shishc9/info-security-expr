package icu.shishc.common;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @author: ShiShc
 * @desc:
 */
@Data
public class ResultJson {
    private Object data;
    private String msg;
    private int code;

    public ResultJson(HttpStatus httpStatus, String msg, Object o) {
        this.code = httpStatus.value();
        this.msg = msg;
        this.data = o;
    }
}
