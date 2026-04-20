package br.com.adryannfelix.gestaovagas.modules.candidate.controllers;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Data
public class CandidateEntity {

    private UUID id;

    @NotBlank(message = "O campo [name] nao pode ser vazio")
    private String name;

    @Pattern(regexp = "^\\S+$", message = "O campo [username] não deve conter espaços")
    private String username;

    @Email(message = "O campo [email] deve conter um e-mail valido")
    private String email;

    @Length(min = 6, max = 100, message = "O comprimento deve ser entre 10 e 100")
    private String password;
    private String description;
    private String curriculum;
}
