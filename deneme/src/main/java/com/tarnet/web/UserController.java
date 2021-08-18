package com.tarnet.web;

import com.tarnet.deneme.UserRepository;
import com.tarnet.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<UserDto>> listele(){

        List<User> list = userRepository.list();

        List<UserDto> cikti = UserDtoFactory.createFromUserList(list);

        return ResponseEntity.ok(cikti);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<UserDto> get(@PathVariable("id") String id) {

        User user = userRepository.get(id);

        UserDto userDto = UserDtoFactory.createFromUser(user);

        return ResponseEntity.ok(userDto);
    }

}
