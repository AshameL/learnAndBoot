package com.example.learn.web.service;


import com.example.learn.web.dto.UserDTO;
import com.example.learn.web.vo.UserVO;
import org.springframework.stereotype.Service;


@Service
public class UserService  {


    public int save(UserVO userVO) {
        System.out.println("userVO 保存用户成功:" + userVO);
        return 1;
    }
    public int save(UserDTO userDTO) {
        System.out.println("userVO 保存用户成功:" + userDTO);
        return 1;
    }

}
