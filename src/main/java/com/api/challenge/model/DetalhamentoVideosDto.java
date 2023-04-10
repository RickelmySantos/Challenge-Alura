package com.api.challenge.model;

public record DetalhamentoVideosDto(Long id, String titulo, String descricao, String url) {

	public DetalhamentoVideosDto(Videos videos) {
		this(videos.getId(), videos.getTitulo(), videos.getDescricao(), videos.getUrl());
	}
}
