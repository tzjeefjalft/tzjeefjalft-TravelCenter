package com.tz.travel.util.Exceptions;

/**
 * Created by cheng on 2014/12/22.
 */
public class ServiceErrorExceptionBuilder {
    private ServiceErrorException  exception = new ServiceErrorException();

    public ServiceErrorExceptionBuilder(){
    }

    public ServiceErrorExceptionBuilder notFound(String msg){
        exception.getErrors().add(new ServiceError(404, msg+"Not Found"));
        return this;
    }

    public ServiceErrorExceptionBuilder inputError(String msg){
        exception.getErrors().add(new ServiceError(400, "Input Error: "+msg));
        return this;
    }

    public ServiceErrorExceptionBuilder validationError(String field, String msg){
        exception.getErrors().add(new ServiceError(400, "Error Validation Input: '"+field+"': "+msg));
        return this;
    }

    public ServiceErrorExceptionBuilder internalError(String msg){
        exception.getErrors().add(new ServiceError(500, "Internal Error: "+msg));
        return  this;
    }

    public ServiceErrorExceptionBuilder internalError(Exception e){
        if(e.getCause() != null){
            exception.getErrors().add(new ServiceError(800, e.getMessage(), e.getCause().getMessage()));
        }else{
            exception.getErrors().add(new ServiceError(500, e.getMessage()));
        }
        return this;
    }

    public ServiceErrorExceptionBuilder noMetaDataError(){
        return noMetaDataError(null);
    }

    public ServiceErrorExceptionBuilder noMetaDataError(String param){
        String msg = "No MetaData found for the requested parameter";
        if(param != null){
            msg += "[" + param + "]";
        }
        exception.getErrors().add(new ServiceError(404, msg));
        return this;
    }

    public ServiceErrorExceptionBuilder alreadyExist(String msg){
        exception.getErrors().add(new ServiceError(400, "Item" + msg + "Already exist in your target content"));
        return this;
    }

    public ServiceErrorExceptionBuilder notExistOrNotAccessibleByYouError(String msg) {
        exception.getErrors().add(new ServiceError(404,
                "Requested item (" + msg + ") does not exist, is not of the right type, or is not accessible by you"));
        return this;
    }

    public ServiceErrorExceptionBuilder notExistOrNotAccessibleByYouError(){
        exception.getErrors().add(new ServiceError(404,
                "Requested item does not exist, is not of the right type, or is not accessible by you"));
        return this;
    }

    public ServiceErrorExceptionBuilder timeoutError(String msg){
        exception.getErrors().add(new ServiceError(408, msg));
        return this;
    }

    public ServiceErrorExceptionBuilder PaymentRequired(String msg){
        exception.getErrors().add(new ServiceError(402,msg));
        return this;
    }

    public ServiceErrorExceptionBuilder Forbidden(){
        exception.getErrors().add(new ServiceError(403, "no permission"));
        return this;
    }

    public ServiceErrorExceptionBuilder Locked(String msg){
        exception.getErrors().add(new ServiceError(423, msg + " is locked"));
        return this;
    }

    public ServiceErrorException build(){
        return exception;
    }

    public ServiceErrorExceptionBuilder methodNotAllowed(){
        exception.getErrors().add(new ServiceError(405, "Method Not Allowed"));
        return this;
    }
}
