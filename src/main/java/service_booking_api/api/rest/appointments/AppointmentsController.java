package service_booking_api.api.rest.appointments;


import org.springframework.http.ResponseEntity;
import service_booking_api.core.domain.model.users.request.UserSigninRequest;
import service_booking_api.core.domain.model.users.request.UserSignupRequest;
import service_booking_api.shared.exceptions.ApplicationException;

public class AppointmentsController implements AppointmentsControllerAPI{
    @Override
    public ResponseEntity<Void> postAppointments(UserSignupRequest request) throws ApplicationException {
        return null;
    }

    @Override
    public ResponseEntity<Void> getAppointments(UserSigninRequest request) throws ApplicationException {
        return null;
    }

    @Override
    public ResponseEntity<Void> cancelAppointments(String token) throws ApplicationException {
        return null;
    }
}
