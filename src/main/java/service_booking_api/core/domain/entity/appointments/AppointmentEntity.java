package service_booking_api.core.domain.entity.appointments;

import jakarta.persistence.*;
import lombok.*;
import service_booking_api.core.domain.entity.services.ServiceEntity;
import service_booking_api.core.domain.entity.users.UserEntity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity(name = "Appointment")
@Table(
        name = "appointments",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {
                        "service_id",
                        "appointment_date",
                        "appointment_time"
                })
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private ServiceEntity service;

    private LocalDate appointmentDate;

    private LocalTime appointmentTime;

    @Enumerated(EnumType.STRING)
    private String status;

}
