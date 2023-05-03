package com.boot.mvc.model.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.boot.mvc.model.dto.MemberDto;

@Mapper
public interface mbMapper {
	
	@Select("SELECT * FROM MEMBER WHERE USER_ID = #{userid}")
	MemberDto select(String userid);
	
	@Insert("INSERT INTO MEMBER VALUES(#{user_id}, #{user_nm}, #{password}, #{addr}, #{email}, #{telno}, #{del_yn})")
	int insert(MemberDto dto);
	
	
}
