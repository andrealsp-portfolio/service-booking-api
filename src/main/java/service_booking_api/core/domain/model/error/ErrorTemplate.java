package service_booking_api.core.domain.model.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorTemplate {

    private Integer errorCode;
    private String message;
    private LocalDateTime timestamp;
    private String traceId;

}
