package com.boot.mvc.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.boot.mvc.model.dto.AskDto;

@Mapper
public interface AskMapper {
	@Insert("INSERT INTO BOARD_ASK(ROOM_NO, USER_ID, CONTENT, REPLY) VALUES(#{no}, #{user_id},#{dto.content}, null)")
	int insert(AskDto dto, String user_id, int no);
	
	@Update("UPDATE BOARD_ASK SET reply = #{reply} WHERE no = #{no};")
	int update(int no, String reply);
	
	@Select("SELECT * FROM BOARD_ASK")
	List<AskDto> select();
}
