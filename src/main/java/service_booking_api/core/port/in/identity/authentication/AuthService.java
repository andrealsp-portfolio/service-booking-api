package service_booking_api.core.port.in.identity.authentication;

import service_booking_api.core.domain.model.auth.AuthToken;
import service_booking_api.core.domain.model.users.request.UserSigninRequest;
import service_booking_api.shared.exceptions.ApplicationException;

public interface AuthService {

    AuthToken authenticate(UserSigninRequest request) throws ApplicationException;

    Boolean validateJwtToken(String token) throws ApplicationException;

}
