package com.tz.travel.util.Exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 2014/12/22.
 */
public class Errors {
    private List<CustomError> errors;

    public Errors(){
        errors = new ArrayList<CustomError>();
    }

    public Errors(List<CustomError> errors2){
        this.errors = errors2;
    }

    public List<CustomError> getErrors(){
        return errors;
    }

    public void setErrors(List<CustomError> errors){
        this.errors = errors;
    }
}
