package com.douzone.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.jwt.vo.UserVo;

@RestController
public class LoginController {
	
//	@PostMapping("/login/auth")
//	  public UserVo getUserInfo(@RequestBody UserVo userVo){
//		System.out.println(userVo.getId());
//		
////		UserVo a = userService.getUserInfo(userVo);
////		System.out.println(a.getName());
//	  	return null;
//	  }

	@GetMapping("/login/auth")
	  public UserVo getUserInfo(){
		System.out.println("액시오스테스트");
		
//		UserVo a = userService.getUserInfo(userVo);
//		System.out.println(a.getName());
	  	return null;
	  }
	
}
