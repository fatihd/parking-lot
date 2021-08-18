package com.tarnet.web;

import com.tarnet.deneme.UsersRepository;
import com.tarnet.domain.ZzzUsers;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {
    private final UsersRepository usersRepository;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<UsersDto>> listele(){

        List<ZzzUsers> list = usersRepository.list();

        List<UsersDto> cikti = new ArrayList<>();

        for (ZzzUsers u: list){
            UsersDto dto = new UsersDto();

            dto.id = u.getId();
            dto.ad = u.getAd();

            cikti.add(dto);

        }

        return new ResponseEntity<>(cikti,HttpStatus.OK);
    }


}
