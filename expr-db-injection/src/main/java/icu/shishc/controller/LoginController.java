package icu.shishc.controller;

import icu.shishc.common.ResultJson;
import icu.shishc.entity.User;
import icu.shishc.mapper.LoginMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ShiShc
 * @desc:
 */
@RestController
public class LoginController {
    private final LoginMapper loginMapper;

    public LoginController(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    @GetMapping("/login")
    public ResultJson login(@RequestParam("loginName") String loginName,
                            @RequestParam("password") String password) {
        User user = loginMapper.findByNameAndPwd(loginName, password);
        return new ResultJson(HttpStatus.OK, "success, without injection", user);
    }

    @GetMapping("/login2")
    public ResultJson login2(@RequestParam("loginName") String loginName,
                             @RequestParam("password") String password) {
        User user = loginMapper.findByNameAndPwdWithInjection(loginName, password);
        return new ResultJson(HttpStatus.OK, "success, but with injection", user);
    }

    @GetMapping("/")
    public String hello() {
        return "hello, 9090";
    }
}
