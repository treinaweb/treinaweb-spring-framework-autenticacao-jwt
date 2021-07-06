package br.com.treinaweb.javajobs.exceptions;

import javax.persistence.EntityNotFoundException;

public class JobNotFoundException extends EntityNotFoundException {

    public JobNotFoundException(Long id) {
        super(String.format("Job with id %d not found", id));
    }

}
