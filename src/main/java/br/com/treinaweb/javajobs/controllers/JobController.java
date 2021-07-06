package br.com.treinaweb.javajobs.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinaweb.javajobs.dto.JobDTO;
import br.com.treinaweb.javajobs.models.Job;
import br.com.treinaweb.javajobs.services.JobService;

@RestController
@RequestMapping("/api/v1/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
    public List<Job> findAll() {
        return jobService.findAll();
    }

    @GetMapping("/{id}")
    public Job findById(@PathVariable Long id) {
        return jobService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Job create(@RequestBody @Valid JobDTO jobDTO) {
        return jobService.create(jobDTO);
    }

    @PutMapping("/{id}")
    public Job update(@RequestBody @Valid JobDTO jobDTO, @PathVariable Long id) {
        return jobService.update(jobDTO, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        jobService.deleteById(id);
    }

}
