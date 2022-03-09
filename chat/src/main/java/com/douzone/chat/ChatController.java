package com.douzone.chat;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.chat.service.ChatService;
import com.douzone.chat.service.UserService;
import com.douzone.chat.vo.UserVo;

@RestController
public class ChatController {
	
	@Autowired
	private ChatService chatService;
	
	@Autowired
	private UserService userService;
	
    @GetMapping("/main")
    public Map<String, Object> getHome(){
    	
    	System.out.println(userService.getUser());
    	Map<String, Object> map = userService.getUser();
    	
        return map;
    }
    
    @PostMapping("/chat/invite")
    public void inviteChat(@RequestBody List<UserVo> list){
    	
    	System.out.println(list);
    	for(UserVo userVo : list){
    		System.out.println(userVo.getId());
    	}
    	
    	chatService.addChatRoom(list);
    	
    }
    
}