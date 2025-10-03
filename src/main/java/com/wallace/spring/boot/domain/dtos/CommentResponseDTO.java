package com.wallace.spring.boot.domain.dtos;

import java.time.LocalDate;

public record CommentResponseDTO(String text, LocalDate date, AuthorResponseDTO authorResponseDTO ) {

}
