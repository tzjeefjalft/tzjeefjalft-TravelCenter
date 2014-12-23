package com.tz.travel.util.Exceptions;

/**
 * Created by cheng on 2014/12/22.
 */
public class ServiceError {
    private int code;
    private String message;
    private String cause;

    public ServiceError(){
    }

    public ServiceError(int code, String message){
        this.code = code;
        this.message = message;
    }

    public ServiceError(int code, String message, String cause){
        this(code, message);
        this.cause = cause;
    }

    public int getCode(){
        return code;
    }

    public void setCode(int code){
        this.code = code;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    @Override
    public String toString(){
        StringBuilder text = new StringBuilder();
        text.append("Error{");
        text.append("code=").append(code);
        text.append(", message=").append(message);
        if(cause != null){
            text.append(", cause=").append(cause);
        }
        text.append("}");
        return text.toString();
    }
}
