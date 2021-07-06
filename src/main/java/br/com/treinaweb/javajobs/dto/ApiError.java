package br.com.treinaweb.javajobs.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {

    private int status;

    private LocalDateTime timestamp;

    private String message;

    private String path;

    private List<String> errors;

}
