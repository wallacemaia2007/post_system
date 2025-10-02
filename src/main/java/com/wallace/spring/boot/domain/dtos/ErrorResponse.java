package com.wallace.spring.boot.domain.dtos;

import java.time.LocalDateTime;

public record ErrorResponse(LocalDateTime timestamp, String message, String details) {
}