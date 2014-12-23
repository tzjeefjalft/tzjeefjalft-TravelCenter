package com.tz.travel.util.Exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 2014/12/22.
 */
public class ServiceErrorException extends WebApplicationException{
    private static final long serialVersionUID = 1L;
    private Logger LOGGER = LoggerFactory.getLogger(getClass());
    private List<ServiceError> errors = new ArrayList<ServiceError>();
    private boolean errorLogged = false;

    public ServiceErrorException(){
    }

    public List<ServiceError> getErrors(){
        return errors;
    }

    public void setErrors(List<ServiceError> errors){
        this.errors = errors;
    }

    @Override
    public String getMessage(){
        return this.errors.toString();
    }

    @Override
    public Response getResponse(){
        Errors errors = new Errors(this.errors);
        int code = errors.getErrors().get(0).getCode();
        if(!this.errorLogged){
            this.logError();
            this.errorLogged = true;
        }
        return Response.status(code).entity(errors).type(MediaType.APPLICATION_JSON).build();
    }

    private void logError(){
        for(ServiceError e : this.errors){
            LOGGER.error(" -> HTTP Status Code: {} - Body: {}", e.getCode(), e.getMessage());
        }
    }
}
