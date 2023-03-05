package io.github.joaopugliesi.paymentschedule.controller;

import io.github.joaopugliesi.paymentschedule.dto.ScheduleDto;
import io.github.joaopugliesi.paymentschedule.service.ScheduleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ScheduleDto save(@RequestBody ScheduleDto dto) {
        return service.save(dto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<ScheduleDto> listAll(@PageableDefault(page = 0,
            size = 10,
            sort = "id") Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<ScheduleDto> findById(@PathVariable Long id) {
        Optional<ScheduleDto> dto = service.findById(id);
        return dto;
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ScheduleDto update(@PathVariable Long id, @RequestBody ScheduleDto dto) {
        dto = service.update(id, dto);
        return dto;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ScheduleDto delete(@PathVariable Long id) {
        service.delete(id);
        return null;
    }
}
