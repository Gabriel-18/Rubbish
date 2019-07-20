package com.example.database.service;

import com.example.database.dao.userDao;

import com.example.database.model.User;
import com.example.database.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private userDao userDao;

    public Map<String, Object> register(String username, String password) {
        HashMap<String, Object> map = new HashMap<>();
        if (StringUtils.isEmpty(username)) {
            map.put("msg", "用户名不能为空");
            return map;
        }

        if (StringUtils.isEmpty(password)) {
            map.put("msg", "密码不能为空");
            return map;
        }

        User user = userDao.selectByName(username);

        if (user != null) {
            map.put("msg", "用户名已经被注册");
            return map;
        }

        user = new User();
        user.setName(username);
        user.setSalt(UUID.randomUUID().toString().substring(0,5));
        // 给密码加盐
        user.setPassword(Util.MD5(password+user.getSalt()));
        userDao.addUser(user);

        return map;

    }


}
