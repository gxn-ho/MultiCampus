package com.boot.jdbc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import com.boot.jdbc.dto.CriteriaTen;
import com.boot.jdbc.dto.MainDto;

@Mapper
public interface MyBoardMapper {

	@Select(" select no, user_id, room_id, title, description, category, people_num from (SELECT @rownum:=@rownum + 1 as R, NO, USER_ID, ROOM_ID, TITLE, DESCRIPTION, CATEGORY, PEOPLE_NUM FROM BOARD where (@rownum:=0) = 0 and @rownum < #{pageNum} * #{amount})page where r > (#{pageNum}-1) * #{amount} ")
	List<MainDto> selectList(CriteriaTen criteriaten);
	
	@Select(" SELECT * FROM BOARD WHERE NO=#{NO} ")
	MainDto selectOne(int no);
	
	@Update(" UPDATE MEMBER SET FAVORITES=#{no} WHERE USER_ID=#{USER_ID} ")
	int update(MainDto dto);

	@Select(" select count(no) from board ")
	int getTotal();
	
	
}
