package com.tarnet.web;

import com.tarnet.domain.User;

import java.util.ArrayList;
import java.util.List;


public class UserDtoFactory {
    public static UserDto createFromUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setAd(user.getAd());
        return userDto;
    }

    static List<UserDto> createFromUserList(List<User> list) {
        List<UserDto> cikti = new ArrayList<>();

        for (User u : list)
            cikti.add(createFromUser(u));
        return cikti;
    }
}
