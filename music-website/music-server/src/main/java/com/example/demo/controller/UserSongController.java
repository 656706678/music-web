package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.UserSong;
import com.example.demo.service.impl.UserSongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@Controller
public class UserSongController {
    @Autowired
    private UserSongServiceImpl userSongService;

    //    添加歌曲
    @ResponseBody
    @RequestMapping(value = "/api/addUserSong", method = RequestMethod.POST)
    public Object addUserSong(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();
        String user_id = req.getParameter("userId");
        String song_name = req.getParameter("songName");
        System.out.println("=================================执行到次数");
        try {
            UserSong userSong = new UserSong();
            userSong.setUserId(user_id);
            userSong.setPlayTime(new Date());
            userSong.setSongName(song_name);
            boolean res = userSongService.ifAdd(userSong);
            if (res){
                jsonObject.put("code", 1);
                jsonObject.put("msg", "保存成功");
                return jsonObject;
            }else {
                jsonObject.put("code", 0);
                jsonObject.put("msg", "保存失败");
                return jsonObject;
            }
        }catch (Exception e){
            jsonObject.put("code", 0);
            jsonObject.put("msg", "上传失败" + e.getMessage());
            return jsonObject;
        }finally {
            return jsonObject;
        }
    }
}
