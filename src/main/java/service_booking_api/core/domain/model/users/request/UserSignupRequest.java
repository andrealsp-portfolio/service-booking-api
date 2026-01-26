package service_booking_api.core.domain.model.users.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignupRequest {

    private String username;
    private String email;
    private String password;
    private String name;
    private String role;

}