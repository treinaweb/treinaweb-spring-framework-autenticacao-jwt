package br.com.treinaweb.javajobs.exceptions;

import javax.persistence.EntityExistsException;

public class JobAlreadyExistsException extends EntityExistsException {

    public JobAlreadyExistsException(String title) {
        super(String.format("Job with title %s already exists", title));
    }

}
