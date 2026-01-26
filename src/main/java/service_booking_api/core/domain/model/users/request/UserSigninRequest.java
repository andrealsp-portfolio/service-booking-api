package service_booking_api.core.domain.model.users.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserSigninRequest {

    @NotBlank
    public String identifier;

    @NotBlank
    public String password;

}
