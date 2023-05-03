package com.boot.mvc.model.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.mvc.model.dto.MemberDto;
import com.boot.mvc.model.mapper.mbMapper;

@Service
public class MemberBizImpl implements MemberBiz{
	
	@Autowired
	private mbMapper mapper;

	@Override
	public int insert(MemberDto dto) {
		return mapper.insert(dto);
	}

	@Override
	public MemberDto select(String userid) {
		return mapper.select(userid);
	}

}
