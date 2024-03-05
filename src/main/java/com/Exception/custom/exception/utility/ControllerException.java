package com.Exception.custom.exception.utility;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@NoArgsConstructor
@Component
public class ControllerException extends RuntimeException  {

    private String mesg;
    private Integer status;



    public ControllerException(String mesg , int status)
    {
        super(mesg);
        this.mesg = mesg;
        this.status = status;

    }
}
