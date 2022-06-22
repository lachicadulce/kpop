package com.entertainment.kpop.service;

import com.entertainment.kpop.domain.Artist;
import com.entertainment.kpop.repository.ArtistRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ArtistService {

    @Autowired
    ArtistRespository artistRespository;

    // 전체 조회
    public List<Artist> getArtists() {
        return artistRespository.findAll();
    }
    // 특정 아이디로 조회
    public Artist getArtist(int id) {
        return artistRespository.findById(id).orElseThrow(NoSuchElementException::new);// null이면 error던져주기.
    }
    // Upsert
    public Artist save(Artist artist) {
        return artistRespository.save(artist);
    }
    // 삭제
    public void delete(int id) {
        artistRespository.deleteById(id);
    }
}
