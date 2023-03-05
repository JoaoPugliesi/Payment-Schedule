package io.github.joaopugliesi.paymentschedule.dto;

import io.github.joaopugliesi.paymentschedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDto {
    private BigDecimal payValue;

    public ScheduleDto(Schedule entity) {

        this.payValue = entity.getPayValue();
    }
}
