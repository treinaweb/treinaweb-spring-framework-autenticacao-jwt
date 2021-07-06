package br.com.treinaweb.javajobs.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.javajobs.models.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

    Optional<Job> findByTitle(String title);

}
