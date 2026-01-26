package service_booking_api.core.domain.model.services;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Services {

    private UUID id;
    private String name;
    private String description;
    private int durationMinutes;
    private boolean active;
    private LocalDateTime createdAt;

}

