package service_booking_api.core.domain.model.appointments;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Getter
@Setter
public class Appointments {

    private UUID id;
    private UUID userId;
    private UUID serviceId;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private String status;
    private LocalDateTime createdAt;

}