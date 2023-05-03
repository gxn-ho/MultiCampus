package com.boot.mvc.model.biz;

import com.boot.mvc.model.dto.MemberDto;

public interface MemberBiz {
	public int insert(MemberDto dto);
	public MemberDto select(String userid);
}
