package br.com.adryannfelix.gestaovagas.modules.company.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity (name = "company")
@Table (name = "company")

public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "O campo [nome] nao pode ser vazio")
    private String nome;

    @Pattern(regexp = "^\\S+$", message = "O campo [username] não deve conter espaços")
    private String username;

    @Email(message = "Campo [email] deve conter um e-mail válido ")
    private String email;

    @Length(min = 6, max = 10)
    private String password;
    private String website;
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
