package es.kiwi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 自定义异常类
 */
@Getter
@Setter
@AllArgsConstructor
public class SysException extends Exception{

    //存储提示信息的
    private String message;
}
