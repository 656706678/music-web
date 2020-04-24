package com.example.demo.service.impl;

import com.example.demo.dao.UserSongMapper;
import com.example.demo.domain.UserSong;
import com.example.demo.service.UserSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserSongServiceImpl implements UserSongService {

    @Autowired
    private UserSongMapper userSongMapper;

    @Override
    public boolean ifAdd(UserSong userSong) {
        return userSongMapper.insertSelective(userSong) > 0?true:false;
    }
}
