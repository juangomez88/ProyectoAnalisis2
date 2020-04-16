package com.udea.example.rtf.dto;

import com.udea.example.rtf.constants.ValidatorConstants;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UsuarioDto {

    private Long id;

    @NotNull
    @Size(min = ValidatorConstants.MIN_SIZE_EMAIL, max = ValidatorConstants.MAX_SIZE_EMAIL, message = ValidatorConstants.BAD_SIZE_EMAIL_MESSSAGE)
    @Pattern(regexp = ValidatorConstants.REGEX_EMAIL, message = ValidatorConstants.BAD_FORMAT_EMAIL_MESSSAGE)
    private String email;

    @NotNull
    @Size(min = ValidatorConstants.MIN_SIZE_PASSWORD, max = ValidatorConstants.MAX_SIZE_PASSWORD, message = ValidatorConstants.BAD_SIZE_PASSWORD_MESSAGE)
    private String password;
    @Size(min = ValidatorConstants.MIN_SIZE_NAME, max = ValidatorConstants.MAX_SIZE_NAME, message = ValidatorConstants.BAD_SIZE_NAME_MESSSAGE)
    private String name;

    public UsuarioDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
