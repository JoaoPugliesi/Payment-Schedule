package io.github.joaopugliesi.paymentschedule.service;

import io.github.joaopugliesi.paymentschedule.dto.UserDto;
import io.github.joaopugliesi.paymentschedule.entity.User;
import io.github.joaopugliesi.paymentschedule.service.exception.BadRequestException;
import io.github.joaopugliesi.paymentschedule.service.exception.NotFoundException;
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
        this.validationCPF(entity);
        entity.setCreateDate(LocalDateTime.now());
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
        User entity = userOptional.orElseThrow(()-> new NotFoundException("Usuário não encontrado!"));
        return Optional.of(new UserDto(entity));
    }

    @Override
    public UserDto update(Long id, UserDto dto) {
        User entity = repository.findById(id).orElseThrow(()-> new NotFoundException("Usuário não encontrado!"));
        if(dto.getCpf() != null) {
            entity.setCpf(dto.getCpf());
        }
        if(dto.getName() != null) {
            entity.setName(dto.getName());
        }
        entity.setUpdateDate(LocalDateTime.now());
        repository.save(entity);
        return new UserDto(entity);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id).orElseThrow(()-> new NotFoundException("Usuário de " + id + " não encontrado!"));
        repository.deleteById(id);
    }

    private void validationCPF(User entity) {
        Optional<User> userOptional = repository.findByCpf(entity.getCpf());
        if(userOptional.isPresent()) {
            throw new BadRequestException("CPF já cadastrado!");
        }
    }
}
