package service_booking_api.core.port.in.identity.authentication;

import service_booking_api.core.domain.model.users.response.UserDetails;
import service_booking_api.shared.exceptions.ApplicationException;

public interface JwtTokenProvider {

    String generateToken(UserDetails userDetails) throws ApplicationException;

}
