package io.github.joaopugliesi.paymentschedule.service;


import io.github.joaopugliesi.paymentschedule.dto.ScheduleDto;
import io.github.joaopugliesi.paymentschedule.entity.Schedule;
import io.github.joaopugliesi.paymentschedule.entity.StatusPayment;
import io.github.joaopugliesi.paymentschedule.entity.User;
import io.github.joaopugliesi.paymentschedule.repository.ScheduleRepository;
import io.github.joaopugliesi.paymentschedule.service.exception.BadRequestException;
import io.github.joaopugliesi.paymentschedule.service.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository repository;

    @Override
    public ScheduleDto save(ScheduleDto dto) {
        Schedule entity = new Schedule();
        BeanUtils.copyProperties(dto, entity);
        entity.setCreateDate(LocalDateTime.now());
        entity.setStatus(StatusPayment.PENDING);
        repository.save(entity);
        return dto;
    }

    @Override
    public Page<ScheduleDto> findAll(Pageable pageable) {
        Page<Schedule> list = repository.findAll(pageable);
        return list.map(x-> new ScheduleDto(x));
    }

    @Override
    public Optional<ScheduleDto> findById(Long id) {
        Optional<Schedule> scheduleOptional = repository.findById(id);
        Schedule entity = scheduleOptional.orElseThrow(()-> new NotFoundException("Adendamento não encontrado!"));
        return Optional.of(new ScheduleDto(entity));
    }

    @Override
    public ScheduleDto update(Long id, ScheduleDto dto) {
        Schedule entity = repository.findById(id).orElseThrow(()-> new NotFoundException("Adendamento não encontrado!"));
        if(entity.getStatus() == StatusPayment.PAID) {
            this.validationStatus(entity);
        }
        entity.setStatus(dto.getStatus());
        entity.setUpdateDate(LocalDateTime.now());
        repository.save(entity);
        return new ScheduleDto(entity);
    }

    @Override
    public void delete(Long id) {

    }

    private void validationStatus(Schedule entity) {
        Optional<Schedule> scheduleOptional = repository.findByStatus(entity.getStatus());
        if(StatusPayment.PAID == scheduleOptional.get().getStatus()) {
            throw new BadRequestException("Agendamento não pode ser alterado, agendamento CONCLUÍDO!");
        }
    }
}
