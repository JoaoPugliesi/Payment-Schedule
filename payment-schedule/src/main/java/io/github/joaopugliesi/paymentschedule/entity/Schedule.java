package io.github.joaopugliesi.paymentschedule.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_schedule")
public class Schedule extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "tb_payValue")
    private BigDecimal payValue;
    @Enumerated(EnumType.STRING)
    @Column(name = "tb_status")
    private StatusPayment status;
    @ManyToMany
    @JoinTable(
            name = "tb_schedule_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "schedule_id"))
    List<Schedule> scheduleList;
}
