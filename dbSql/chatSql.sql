select * from chat_message;
select * from chat_room;
select * from user;
select * from join_chat_room;

insert into user values(null, '우동현', 'aaaa', 'aaaa');
insert into user values(null, '김민규', 'bbbb', 'bbbb');
insert into user values(null, '노성진', 'cccc', 'cccc');
insert into user values(null, '진종래', 'dddd', 'dddd');

insert into chat_room values (null, "");
insert into join_chat_room values (null, 1, 1);
insert into join_chat_room values (null, 2, 1);

insert into chat_message values( null, "우동현:gd",1,1,now());
insert into chat_message values( null, "김민규:ㅇㅋ",1,2,now());

-- 채팅방별 메시지 조회 
select no,message,chat_room_no,send_user_no,reg_date 
    from chat_message
    where chat_room_no= 1
    ;


select no,id,name,password from user;
select no,name,id,password from user
;

insert into chat_room values (null,"");
