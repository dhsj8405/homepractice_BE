package com.douzone.jwt.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.jwt.vo.UserVo;

@RestController
public class LoginController {
	@PostMapping("/login")
	  public UserVo getUserInfo(@RequestBody UserVo userVo){
		System.out.println(userVo.getId());
		
//		UserVo a = userService.getUserInfo(userVo);
//		System.out.println(a.getName());
	  	return null;
	  }
}
