package service_booking_api.api.rest.appointments;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service_booking_api.core.domain.model.users.request.UserSigninRequest;
import service_booking_api.core.domain.model.users.request.UserSignupRequest;
import service_booking_api.shared.exceptions.ApplicationException;

@RequestMapping("/appointments")
@Tag(name = "AppointmentsController", description = "Collection for authentication")
public interface AppointmentsControllerAPI {

    @Operation(summary = "Appointments Registration Method", tags = "AppointmentsController")
    @PostMapping
    ResponseEntity<Void> postAppointments(@Valid @RequestBody UserSignupRequest request) throws ApplicationException;

    @Operation(summary = "Retrieve Appointments Method", tags = "AppointmentsController")
    @GetMapping
    ResponseEntity<Void> getAppointments(@Valid @RequestBody UserSigninRequest request) throws ApplicationException;

    @Operation(summary = "Cancel Appointments Method", tags = "AppointmentsController")
    @PatchMapping("/{id}/cancel")
    ResponseEntity<Void> cancelAppointments(@RequestHeader(value = "Authorization") String token) throws ApplicationException;

}
