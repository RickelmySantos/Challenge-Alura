package com.api.challenge.model;

import jakarta.validation.constraints.NotBlank;

public record VideosDto(Long id, @NotBlank String titulo,  String descricao, @NotBlank String url) {
	

	
}
