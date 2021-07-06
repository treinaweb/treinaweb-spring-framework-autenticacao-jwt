package br.com.treinaweb.javajobs.dto;

import java.util.Set;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.treinaweb.javajobs.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDTO {

    @NotEmpty
    @Size(min = 3, max = 80)
    private String title;

    private String description;

    @NotEmpty
    @Size(min = 3, max = 80)
    private String company;

    @NotEmpty
    @Size(min = 3, max = 255)
    @Email
    private String email;

    @NotEmpty
    private Set<String> techs;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

}
