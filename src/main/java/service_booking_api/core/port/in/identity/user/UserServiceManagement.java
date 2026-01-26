package service_booking_api.core.port.in.identity.user;

import service_booking_api.core.domain.model.users.request.UserSigninRequest;
import service_booking_api.core.domain.model.users.request.UserSignupRequest;
import service_booking_api.core.domain.model.users.response.UserDetails;
import service_booking_api.shared.exceptions.ApplicationException;

public interface UserServiceManagement {

    void register(UserSignupRequest request) throws ApplicationException;

    UserDetails retrieveUser(UserSigninRequest request) throws ApplicationException;

}
