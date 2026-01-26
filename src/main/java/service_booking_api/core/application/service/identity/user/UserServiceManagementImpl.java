package service_booking_api.core.application.service.identity.user;

import service_booking_api.core.application.service.identity.user.mapper.UserDetailsMapper;
import service_booking_api.core.application.service.identity.user.mapper.UserEntityMapper;
import service_booking_api.core.domain.entity.users.UserEntity;
import service_booking_api.core.domain.model.users.request.UserSigninRequest;
import service_booking_api.core.domain.model.users.request.UserSignupRequest;
import service_booking_api.core.domain.model.users.response.UserDetails;
import service_booking_api.core.port.in.identity.user.UserServiceManagement;
import service_booking_api.infrastructure.persistence.postgres.repository.user.UserRepository;
import service_booking_api.shared.exceptions.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceManagementImpl implements UserServiceManagement {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceManagementImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public void register(UserSignupRequest request) throws ApplicationException {

        validateUniqueness(request.getUsername(), request.getEmail());

        String passwordHash = passwordEncoder.encode(request.getPassword());

        UserEntity entity =
                UserEntityMapper.mapUserEntityRegistration(request, passwordHash);

        userRepository.save(entity);
    }

    @Override
    public UserDetails retrieveUser(UserSigninRequest request) throws ApplicationException {

        if (isEmail(request.getIdentifier())) {
            return UserDetailsMapper.map(
                    userRepository.findByEmail(request.getIdentifier())
                            .orElseThrow(() -> new ApplicationException(
                                    404, "User not found"
                            ))
            );
        }

        return UserDetailsMapper.map(
                userRepository.findByUsername(request.getIdentifier())
                        .orElseThrow(() -> new ApplicationException(
                                404, "User not found"
                        ))
        );

    }

    private void validateUniqueness(String username, String email) throws ApplicationException {
        if (userRepository.existsByUsername(username)) {
            throw new ApplicationException(400,
                    "Username already in use"
            );
        }

        if (userRepository.existsByEmail(email)) {
            throw new ApplicationException(400,
                    "Email already in use"
            );
        }
    }

    private boolean isEmail(String identifier) {
        return identifier.contains("@");
    }

}
