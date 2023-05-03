package com.boot.mvc.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.mvc.model.dto.BoardMemberDto;
import com.boot.mvc.model.mapper.MemberMapper;


@Service
public class BoardMemberBizImpl implements BoardMemberBiz{
	
	@Autowired
	private MemberMapper mapper;

	@Override
	public int insert(BoardMemberDto dto) {
		return mapper.insert(dto);
	}

	@Override
	public List<BoardMemberDto> select() {
		return mapper.select();
	}

	@Override
	public int delete(String user_id) {
		return mapper.delete(user_id);
	}

	@Override
	public List<BoardMemberDto> selectOne(int no) {
		return mapper.selectOne(no);
	}
	
}
