package io.github.joaopugliesi.paymentschedule.repository;

import io.github.joaopugliesi.paymentschedule.entity.Schedule;
import io.github.joaopugliesi.paymentschedule.entity.StatusPayment;
import io.github.joaopugliesi.paymentschedule.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    public Optional<Schedule> findByStatus(StatusPayment status);
}
