package com.tz.travel.util.Exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 2014/12/22.
 */
public class Errors {
    private List<ServiceError> errors;

    public Errors(){
        errors = new ArrayList<ServiceError>();
    }

    public Errors(List<ServiceError> errors2){
        this.errors = errors2;
    }

    public List<ServiceError> getErrors(){
        return errors;
    }

    public void setErrors(List<ServiceError> errors){
        this.errors = errors;
    }
}
