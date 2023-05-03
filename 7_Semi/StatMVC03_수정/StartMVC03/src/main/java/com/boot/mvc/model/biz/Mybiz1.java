package com.boot.mvc.model.biz;

import java.util.List;

import com.boot.mvc.model.dto.MyDto;

public interface Mybiz1 {
	public int insert(MyDto dto, String user_id);
	public int update(String description, int no);
	public List<MyDto> select();
	public MyDto selectOne(String title);
	public MyDto selectOne(int roon_id);
	//public int update(int current, int room_id);
	
}

//관리 페이지 들어가서 스터디룸 회원 정보도 수정할 수 있어야 함
//스터디룸 질문 테이블에서도 올려야함.