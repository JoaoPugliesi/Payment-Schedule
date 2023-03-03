package io.github.joaopugliesi.paymentschedule.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String name;
    @Column(name = "user_cpf", length = 11, nullable = false)
    @CPF
    private String cpf;
    @Column(name = "user_phone", nullable = false)
    private String phone;
    @Column(name = "user_email", length = 40, nullable = false)
    @Email
    private String email;
}
