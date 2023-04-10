package com.api.challenge.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.api.challenge.model.DetalhamentoVideosDto;
import com.api.challenge.model.Videos;
import com.api.challenge.model.VideosDto;
import com.api.challenge.repositories.VideosRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/videos")
public class VideosController {
	
	@Autowired
	private VideosRepository repository;	
	
	@PostMapping
	@Transactional
	public ResponseEntity cadastrarVideos(@RequestBody @Valid VideosDto dados, UriComponentsBuilder uriBuilder) {
		var videos = new Videos(dados);
		repository.save(videos);
		var uri = uriBuilder.path("/videos/{id}").buildAndExpand(videos.getId()).toUri();
		return ResponseEntity.created(uri).body(new DetalhamentoVideosDto(videos));
		
	}
		
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Videos>> listarVideos(@PathVariable Long id){
	Optional<Videos> obj = repository.findById(id);
	return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/videos")
	public ResponseEntity<Page<DetalhamentoVideosDto>>findAll(@PageableDefault Pageable paginacao){
		var page = repository.findAll(paginacao).map(DetalhamentoVideosDto :: new);
		return ResponseEntity.ok(page);
		}
	}
