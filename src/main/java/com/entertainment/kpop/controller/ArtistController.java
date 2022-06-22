package com.entertainment.kpop.controller;

import com.entertainment.kpop.domain.Agency;
import com.entertainment.kpop.domain.Artist;
import com.entertainment.kpop.dto.ArtistDTO;
import com.entertainment.kpop.service.AgencyService;
import com.entertainment.kpop.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artists") // 주로 명사, 복수로 생성
public class ArtistController {

    @Autowired
    ArtistService artistService;

    @Autowired
    AgencyService agencyService;

    @GetMapping
    public List<Artist> getArtists(){
        return artistService.getArtists();
    }

    @GetMapping("/{id}")
    public Artist getArtist(@PathVariable("id") int id) {
        return artistService.getArtist(id);
    }

    @PostMapping
    public Artist insertArtist(@RequestBody ArtistDTO dto) {
        Agency agency = agencyService.getAgency(dto.getAgencyId());
        Artist artist = new Artist(0, dto.getName(), dto.getDebutDate(), dto.getImg(), agency);
        return artistService.save(artist);
    }

    @PutMapping("/{id}") // 수정
    public Artist updateArtist(@PathVariable("id") int id, @RequestBody ArtistDTO dto) {
        Artist artist = artistService.getArtist(id);
        Agency agency = agencyService.getAgency(dto.getAgencyId());

        artist.setArtist(dto.getName(), dto.getDebutDate(), dto.getImg(), agency);

        return artistService.save(artist);
    }

    @DeleteMapping("/{id}") // 삭제
    public void deleteArtist(@PathVariable("id") int id) {
        artistService.delete(id);
    }
}
