package com.tz.travel.util.Exceptions;

/**
 * Created by cheng on 2014/12/22.
 */
public class CustomErrorExceptionBuilder {
    private CustomErrorException  exception = new CustomErrorException();

    public CustomErrorExceptionBuilder(){
    }

    public CustomErrorExceptionBuilder notFound(String msg){
        exception.getErrors().add(new CustomError(404, msg+"Not Found"));
        return this;
    }

    public CustomErrorExceptionBuilder inputError(String msg){
        exception.getErrors().add(new CustomError(400, "Input Error: "+msg));
        return this;
    }

    public CustomErrorExceptionBuilder validationError(String field, String msg){
        exception.getErrors().add(new CustomError(400, "Error Validation Input: '"+field+"': "+msg));
        return this;
    }

    public CustomErrorExceptionBuilder internalError(String msg){
        exception.getErrors().add(new CustomError(500, "Internal Error: "+msg));
        return  this;
    }

    public CustomErrorExceptionBuilder internalError(Exception e){
        if(e.getCause() != null){
            exception.getErrors().add(new CustomError(800, e.getMessage(), e.getCause().getMessage()));
        }else{
            exception.getErrors().add(new CustomError(500, e.getMessage()));
        }
        return this;
    }

    public CustomErrorExceptionBuilder noMetaDataError(){
        return noMetaDataError(null);
    }

    public CustomErrorExceptionBuilder noMetaDataError(String param){
        String msg = "No MetaData found for the requested parameter";
        if(param != null){
            msg += "[" + param + "]";
        }
        exception.getErrors().add(new CustomError(404, msg));
        return this;
    }

    public CustomErrorExceptionBuilder alreadyExist(String msg){
        exception.getErrors().add(new CustomError(400, "Item" + msg + "Already exist in your target content"));
        return this;
    }

    public CustomErrorExceptionBuilder notExistOrNotAccessibleByYouError(String msg) {
        exception.getErrors().add(new CustomError(404,
                "Requested item (" + msg + ") does not exist, is not of the right type, or is not accessible by you"));
        return this;
    }

    public CustomErrorExceptionBuilder notExistOrNotAccessibleByYouError(){
        exception.getErrors().add(new CustomError(404,
                "Requested item does not exist, is not of the right type, or is not accessible by you"));
        return this;
    }

    public CustomErrorExceptionBuilder timeoutError(String msg){
        exception.getErrors().add(new CustomError(408, msg));
        return this;
    }

    public CustomErrorException build(){
        return exception;
    }

    public CustomErrorExceptionBuilder methodNotAllowed(){
        exception.getErrors().add(new CustomError(405, "Method Not Allowed"));
        return this;
    }
}
