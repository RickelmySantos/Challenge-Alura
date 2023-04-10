package com.api.challenge.model;

public record DetalhamentoVideosDto( String titulo, String descricao, String url) {

	public DetalhamentoVideosDto(Videos videos) {
		this(videos.getTitulo(), videos.getDescricao(), videos.getUrl());
	}
}
