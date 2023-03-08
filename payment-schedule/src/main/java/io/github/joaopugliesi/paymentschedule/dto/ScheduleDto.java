package io.github.joaopugliesi.paymentschedule.dto;

import io.github.joaopugliesi.paymentschedule.entity.Schedule;
import io.github.joaopugliesi.paymentschedule.entity.StatusPayment;
import io.github.joaopugliesi.paymentschedule.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDto {
    private BigDecimal payValue;
    private StatusPayment status;
    private User user;

    public ScheduleDto(Schedule entity) {
        this.payValue = entity.getPayValue();
        this.status = entity.getStatus();
    }
}


