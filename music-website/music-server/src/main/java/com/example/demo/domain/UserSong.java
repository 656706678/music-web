package com.example.demo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

public class UserSong {
    private Integer id;
    private String userId;
    private Date playTime;
    private String songName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getPlayTime() {
        return playTime;
    }

    public void setPlayTime(Date playTime) {
        this.playTime = playTime;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
