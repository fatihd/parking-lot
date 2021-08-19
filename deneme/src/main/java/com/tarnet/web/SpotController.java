package com.tarnet.web;

import com.tarnet.deneme.dao.SpotRepository;
import com.tarnet.deneme.domain.Spot;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/spot")
@RequiredArgsConstructor
public class SpotController {
    private final SpotRepository spotRepository;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<SpotDto>> listele(){

        List<Spot> list = spotRepository.list();

        List<SpotDto> sonuc = SpotDtoFactory.createFromSpotList(list);

        return ResponseEntity.ok(sonuc);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<SpotDto> get(@PathVariable("id") String id) {

        Spot spot = spotRepository.get(Long.valueOf(id));

        SpotDto spotDto = SpotDtoFactory.createFromSpot(spot);

        return ResponseEntity.ok(spotDto);
    }

}
