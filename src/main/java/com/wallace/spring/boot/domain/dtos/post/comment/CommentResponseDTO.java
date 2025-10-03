package com.wallace.spring.boot.domain.dtos.post.comment;

import java.time.LocalDate;

import com.wallace.spring.boot.domain.dtos.post.AuthorResponseDTO;

public record CommentResponseDTO(String text, LocalDate date, AuthorResponseDTO authorResponseDTO ) {

}
