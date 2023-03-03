package io.github.joaopugliesi.paymentschedule.dto;

import io.github.joaopugliesi.paymentschedule.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String name;
    @CPF
    private String cpf;
    private String phone;
    @Email
    private String email;

    public UserDto(User user) {
        this.name = user.getName();
        this.cpf = user.getCpf();
        this.phone = user.getPhone();
        this.email = user.getEmail();
    }
}
