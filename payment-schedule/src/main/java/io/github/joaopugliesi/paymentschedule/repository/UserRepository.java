package io.github.joaopugliesi.paymentschedule.repository;

import io.github.joaopugliesi.paymentschedule.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
