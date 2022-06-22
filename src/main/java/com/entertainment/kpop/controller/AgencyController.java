package com.entertainment.kpop.controller;

import com.entertainment.kpop.domain.Agency;
import com.entertainment.kpop.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agencies") // 주로 명사, 복수로 생성
public class AgencyController {

    @Autowired
    AgencyService agencyService;

    @GetMapping
    public List<Agency> getAgencies(){
        return agencyService.getAgencies();
    }

    @GetMapping("/{id}")
    public Agency getAgency(@PathVariable("id") int id) {
        return agencyService.getAgency(id);
    }

    @PostMapping
    public Agency insertAgency(@RequestBody Agency agency) {
        return agencyService.save(agency);
    }

    @PutMapping("/{id}") // 수정
    public Agency updateAgency(@PathVariable("id") int id, @RequestBody Agency req) {
        Agency agency = agencyService.getAgency(id);
        agency.setAgency(req.getName(), req.getCeo(), req.getAddress(), req.getImg());

        return agencyService.save(agency);
    }

    @DeleteMapping("/{id}") // 삭제
    public void deleteAgency(@PathVariable("id") int id) {
        agencyService.delete(id);
    }
}
