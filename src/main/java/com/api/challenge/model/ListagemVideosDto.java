package com.api.challenge.model;

public record ListagemVideosDto(Long id,  String titulo, String descricao, String url) {

	public ListagemVideosDto(Videos videos) {
		this(videos.getId(), videos.getTitulo(), videos.getDescricao(), videos.getUrl());
	}
}
