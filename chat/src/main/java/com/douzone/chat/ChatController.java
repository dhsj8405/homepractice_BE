package com.douzone.chat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.chat.dto.ChatMessageDto;
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
    public Long inviteChat(@RequestBody List<UserVo> list){
    	
//    	System.out.println(list);
//    	for(UserVo userVo : list){
//    		System.out.println(userVo.getId());
//    	}
    	
    	Long chatRoomNo = chatService.addChatRoom(list);
    	
    	//초대하면서 바로 채팅방 켜줘야하기때문에 생성된 채팅방 번호 리턴해줌
    	return chatRoomNo;
    }
    
    @GetMapping("/chat/msgList")
  public Map<String, Object> getMessageList(){
  	System.out.println("z");
  	// 가라로 채팅룸번호 1번넣을것임
  	List<ChatMessageDto> list = chatService.getMessageList(1);
	Map<String, Object> map = new HashMap<>();
	map.put("list", list);

  	return map;
  }
  
    
}