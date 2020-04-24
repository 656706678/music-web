package com.example.demo.dao;

import com.example.demo.domain.UserSong;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSongMapper {
    int insert(UserSong record);

    int insertSelective(UserSong record);
}
