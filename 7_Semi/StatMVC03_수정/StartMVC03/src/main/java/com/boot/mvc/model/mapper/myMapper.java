package com.boot.mvc.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.boot.mvc.model.dto.MyDto;

@Mapper
public interface myMapper {
	@Insert("INSERT INTO BOARD(USER_ID,TITLE, DESCRIPTION, CATEGORY, PEOPLE_NUM) VALUES(#{user_id},#{dto.title},#{dto.description},#{dto.category},#{dto.people_num})")
	int insert(@Param("dto") MyDto dto, @Param("user_id") String user_id);

	@Update("UPDATE BOARD SET description=#{description} WHERE no=#{no};")
	int update(String description, int no);
	
	@Select("SELECT * FROM BOARD")
	List<MyDto> select();
	
	@Select("SELECT * FROM BOARD WHERE title = #{title}")
	MyDto selectOne(String title);
	
	@Select("SELECT * FROM BOARD WHERE NO=#{room_id}")
	MyDto selectOne(int room_id);
	
//	@Update("UPDATE BOARD SET current_people=#{current} WHERE room_id=#{room_id};")
//	int update(int current, int room_id);
}
