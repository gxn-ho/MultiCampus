package com.boot.mvc.model.biz;

import java.util.List;

import com.boot.mvc.model.dto.BoardMemberDto;

public interface BoardMemberBiz {
	
	public int insert(BoardMemberDto dto);
	public List<BoardMemberDto> select();
	public int delete(String user_id);
	
	public List<BoardMemberDto> selectOne(int no);
}
