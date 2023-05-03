package com.boot.jdbc.mapper;



import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;





import com.boot.jdbc.dto.MemberDto;

@Mapper
public interface MemberMapper {

	
	
	@Select(" select * from member where user_id = #{memberid} and password = #{memberpw} ")
	MemberDto login(MemberDto dto);
	
}
