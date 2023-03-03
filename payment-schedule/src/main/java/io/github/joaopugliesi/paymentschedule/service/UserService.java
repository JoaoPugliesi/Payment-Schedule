package io.github.joaopugliesi.paymentschedule.service;

import io.github.joaopugliesi.paymentschedule.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {

    UserDto save(UserDto dto);
    Page<UserDto>findAll(Pageable pageable);
    Optional<UserDto> findById(Long id);
    void delete(Long id);


}
