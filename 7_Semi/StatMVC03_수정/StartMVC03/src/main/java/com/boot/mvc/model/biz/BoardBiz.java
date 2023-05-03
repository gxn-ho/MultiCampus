package com.boot.mvc.model.biz;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.boot.mvc.model.dto.BoardDto;

public interface BoardBiz {
	public List<BoardDto> selectList();
	public BoardDto selectOne(int qna_no);
	public void write(BoardDto dto, MultipartFile file) throws Exception;
	public int update(BoardDto dto);
	public int delete(int qna_no);
	public void updateViewCount(int qna_no);

}
