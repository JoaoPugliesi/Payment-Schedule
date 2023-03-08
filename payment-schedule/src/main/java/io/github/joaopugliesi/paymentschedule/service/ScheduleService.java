package io.github.joaopugliesi.paymentschedule.service;

import io.github.joaopugliesi.paymentschedule.dto.ScheduleDto;
import io.github.joaopugliesi.paymentschedule.entity.StatusPayment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ScheduleService {
    ScheduleDto save(ScheduleDto dto);
    Page<ScheduleDto> findAll(Pageable pageable);
    Optional<ScheduleDto> findById(Long id);
    ScheduleDto update(Long id, ScheduleDto dto);
    void delete(Long id);
}
