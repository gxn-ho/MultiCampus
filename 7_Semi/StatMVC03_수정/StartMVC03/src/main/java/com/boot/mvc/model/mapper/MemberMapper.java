package com.boot.mvc.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.boot.mvc.model.dto.BoardMemberDto;

@Mapper
public interface MemberMapper {
	
	@Insert("INSERT INTO BOARD_MEMBER VALUES(#{no}, #{user_id}, #{user_nm})")
	int insert(BoardMemberDto dto);
	
	@Select("SELECT * FROM BOARD_MEMBER")
	List<BoardMemberDto> select();
	
	//만약 room_id를 pk 지정 안 하면 list로 받아와야함.
	@Select("SELECT * FROM BOARD_MEMBER WHERE NO=#{no}")
	List<BoardMemberDto> selectOne(int no);
	
	@Delete("DELETE FROM BOARD_MEMBER WHERE USER_NM=#{user_id}")
	int delete(String user_id);
	
}
