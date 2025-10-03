package com.wallace.spring.boot.domain.dtos.post;

import java.time.LocalDate;

public record PostRequestDTO(String id, String title, LocalDate date, String description, AuthorResponseDTO author){

}
