package br.com.treinaweb.javajobs.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @NotEmpty
    @Size(min = 3, max = 255)
    private String username;

    @NotEmpty
    @Size(max = 255)
    private String password;

}
