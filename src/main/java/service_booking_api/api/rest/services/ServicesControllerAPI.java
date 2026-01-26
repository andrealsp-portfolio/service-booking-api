package service_booking_api.api.rest.services;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import service_booking_api.core.domain.model.users.request.UserSigninRequest;
import service_booking_api.core.domain.model.users.request.UserSignupRequest;
import service_booking_api.shared.exceptions.ApplicationException;

@RequestMapping("/services")
@Tag(name = "ServicesController", description = "Collection for authentication")
public interface ServicesControllerAPI {

    @Operation(summary = "Services Registration Method", tags = "ServicesController")
    @PostMapping
    ResponseEntity<Void> postServices(@Valid @RequestBody UserSignupRequest request) throws ApplicationException;

    @Operation(summary = "Retrieve Services Method", tags = "ServicesController")
    @GetMapping
    ResponseEntity<Void> getServices(@Valid @RequestBody UserSigninRequest request) throws ApplicationException;

}
