package com.example.learn.web.controller;

import com.example.learn.web.costant.Constant;
import com.example.learn.web.dto.RspDTO;
import com.example.learn.web.dto.UserDTO;
import com.example.learn.web.exception.BizException;
import com.example.learn.web.service.UserService;
import com.example.learn.web.vo.UserVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@RestController
@RestControllerAdvice
public class ValidController {

    @Autowired
    private UserService userService;
    /**
     * 走串行校验
     *
     * @param userVO
     * @return
     */
    public Object saveDepressed(@RequestBody UserVO userVO){
        String mobile  = userVO.getMobile();

        //手动逐个 参数校验~ 写法
        if (StringUtils.isBlank(mobile)) {
            return RspDTO.paramFail("mobile:手机号码不能为空");
        } else if (!Pattern.matches("^[1][3,4,5,6,7,8,9][0-9]{9}$", mobile)) {
            return RspDTO.paramFail("mobile:手机号码格式不对");
        }

        //抛出自定义异常等~写法
        if (StringUtils.isBlank(userVO.getUsername())) {
            throw new BizException(Constant.PARAM_FAIL_CODE, "用户名不能为空");
        }

        // 比如写一个map返回
        if (StringUtils.isBlank(userVO.getSex())) {
            Map<String, Object> result = new HashMap<>(5);
            result.put("code", Constant.PARAM_FAIL_CODE);
            result.put("msg", "性别不能为空");
            return result;
        }

        userService.save(userVO);
        return RspDTO.success();

        // 很差的参数校验
        //javax.validation 使用它来校验
    }

    /**
     * 走参数校验注解
     *
     * @param userDTO
     * @return
     */
    @PostMapping("/save/valid")
    public RspDTO save(@RequestBody @Validated UserDTO userDTO) {
        userService.save(userDTO);
        return RspDTO.success();
    }

}
