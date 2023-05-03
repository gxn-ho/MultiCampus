package com.boot.mvc.model.biz;

import java.util.List;

import com.boot.mvc.model.dto.AskDto;

public interface Askbiz {
	
	public int insert(AskDto dto, String user_id, int no);
	public AskDto selectOne(int no);
	public List<AskDto> selectList();
	public int update(int no, String reply);

}
