package io.github.joaopugliesi.paymentschedule.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AbstractEntity {
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDateTime createDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDateTime updateDate;
}
