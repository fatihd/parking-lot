package com.tarnet.web;

import com.tarnet.deneme.UserRepository;
import com.tarnet.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<UserDto>> listele(){

        List<User> list = userRepository.list();

        List<UserDto> cikti = new ArrayList<>();

        for (User u: list){
            UserDto dto = new UserDto();

            dto.id = u.getId();
            dto.ad = u.getAd();

            cikti.add(dto);

        }

        return new ResponseEntity<>(cikti,HttpStatus.OK);
    }


}
