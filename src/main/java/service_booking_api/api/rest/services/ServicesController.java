package service_booking_api.api.rest.services;

import org.springframework.http.ResponseEntity;
import service_booking_api.core.domain.model.users.request.UserSigninRequest;
import service_booking_api.core.domain.model.users.request.UserSignupRequest;
import service_booking_api.shared.exceptions.ApplicationException;

public class ServicesController implements ServicesControllerAPI {
    @Override
    public ResponseEntity<Void> postServices(UserSignupRequest request) throws ApplicationException {
        return null;
    }

    @Override
    public ResponseEntity<Void> getServices(UserSigninRequest request) throws ApplicationException {
        return null;
    }
}
