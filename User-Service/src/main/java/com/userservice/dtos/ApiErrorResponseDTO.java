package com.userservice.dtos;

import lombok.*;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ApiErrorResponseDTO {
    private LocalDateTime timestamp;
    private HttpStatus status;
    private String message;
}
