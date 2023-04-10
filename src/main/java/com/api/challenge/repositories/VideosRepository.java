package com.api.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.challenge.model.Videos;

@Repository
public interface VideosRepository extends JpaRepository<Videos, Long>{



}
