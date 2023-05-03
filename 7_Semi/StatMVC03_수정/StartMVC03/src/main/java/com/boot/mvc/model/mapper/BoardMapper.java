package com.boot.mvc.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.boot.mvc.model.dto.BoardDto;

@Mapper
public interface BoardMapper {

	@Select("SELECT * FROM QNA_BOARD ORDER BY QNA_NO DESC")
	List<BoardDto> selectList();
	
	@Insert("INSERT INTO QNA_BOARD VALUES(NULL, #{user_id}, #{qna_title}, #{qna_content}, #{qna_view},NOW(), #{filename}, #{filepath})")
	int write(BoardDto dto);
	
	@Select(" SELECT * FROM QNA_BOARD WHERE QNA_NO=#{qna_no}")
	BoardDto selectOne(int qna_no);
	
	@Update(" UPDATE QNA_BOARD SET QNA_TITLE=#{qna_title}, QNA_CONTENT=#{qna_content} WHERE QNA_NO=#{qna_no}")
	int update(BoardDto dto);
	
	@Delete(" DELETE FROM QNA_BOARD WHERE QNA_NO=#{qna_no} ")
	int delete(int qna_no);
	
	@Select("SELECT COUNT(*) AS TOTAL_COUNT FROM QNA_BOARD")
	int findAllCnt();

	@Select("SELECT * FROM QNA_BOARD ORDER BY QNA_NO DESC LIMIT #{startIndex}, #{pageSize}")
	List<BoardDto> findListPaging(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

	@Update("UPDATE QNA_BOARD SET QNA_VIEW = QNA_VIEW + 1 WHERE QNA_NO = #{qna_no}")
	int updateViewCount(int qna_no);


	
	
	
	
}
