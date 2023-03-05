package io.github.joaopugliesi.paymentschedule.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class User extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "user_name", nullable = false)
    private String name;
    @CPF
    @Column(name = "user_cpf", length = 11, nullable = false)
    private String cpf;
    @Column(name = "user_phone", nullable = false)
    private String phone;
    @Email
    @Column(name = "user_email", length = 40, nullable = false)
    private String email;
}
