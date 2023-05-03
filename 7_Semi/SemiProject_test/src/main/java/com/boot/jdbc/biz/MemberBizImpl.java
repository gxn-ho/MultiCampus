package com.boot.jdbc.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.boot.jdbc.dto.MemberDto;
import com.boot.jdbc.mapper.MemberMapper;

@Service
public class MemberBizImpl implements MemberBiz{

	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public MemberDto login(MemberDto dto) {
		
		return memberMapper.login(dto);
	}
	

}
