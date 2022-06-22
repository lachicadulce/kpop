package com.entertainment.kpop.repository;

import com.entertainment.kpop.domain.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRespository extends JpaRepository<Artist, Integer> {
}
