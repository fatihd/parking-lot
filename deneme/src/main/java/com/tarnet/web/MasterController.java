package com.tarnet.web;

import com.tarnet.deneme.MasterRepository;
import com.tarnet.domain.ZzzMaster;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/master")
@RequiredArgsConstructor
public class MasterController {
    private final MasterRepository masterRepository;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<MasterDto>> listele() {

        List<ZzzMaster> list = masterRepository.list();

        List<MasterDto> sonuc = new ArrayList<>();

        for (ZzzMaster m: list) {
            MasterDto dto = new MasterDto();
            dto.id = m.getId();
            dto.ad = m.getAd();

            sonuc.add(dto);
        }

        return new ResponseEntity<>(sonuc, HttpStatus.OK);
    }
}
