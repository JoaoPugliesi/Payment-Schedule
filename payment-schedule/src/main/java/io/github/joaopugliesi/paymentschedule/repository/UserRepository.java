package io.github.joaopugliesi.paymentschedule.repository;

import io.github.joaopugliesi.paymentschedule.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByCpf(String cpf);
}
