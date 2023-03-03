package io.github.joaopugliesi.paymentschedule.service;

import io.github.joaopugliesi.paymentschedule.dto.UserDto;
import io.github.joaopugliesi.paymentschedule.entity.User;
import io.github.joaopugliesi.paymentschedule.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    @Override
    public UserDto save(UserDto dto) {
        User entity = new User();
        BeanUtils.copyProperties(dto, entity);
        entity.setDate(LocalDateTime.now());
        repository.save(entity);
        return dto;
    }

    @Override
    public Page<UserDto> findAll(Pageable pageable) {
        Page<User> list = repository.findAll(pageable);
        return list.map(x -> new UserDto(x));
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        Optional<User> userOptional = repository.findById(id);
        User entity = userOptional.get();
        return Optional.of(new UserDto(entity));
    }

    @Override
    public UserDto update(Long id, UserDto dto) {
        User entity = repository.findById(id).orElseThrow();
        if(dto.getCpf() != null) {
            entity.setCpf(dto.getCpf());
        }
        repository.save(entity);
        return new UserDto(entity);
    }

    @Override
    public void delete(Long id) {

    }
}
