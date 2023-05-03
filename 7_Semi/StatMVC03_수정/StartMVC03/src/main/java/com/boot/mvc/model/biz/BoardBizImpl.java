package com.boot.mvc.model.biz;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.boot.mvc.model.dto.BoardDto;
import com.boot.mvc.model.mapper.BoardMapper;

@Service
public class BoardBizImpl implements BoardBiz{

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardDto> selectList() {
		return boardMapper.selectList();
	}

	@Override
	public BoardDto selectOne(int qna_no) {
		return boardMapper.selectOne(qna_no);
	}

	@Override
	public void write(BoardDto dto, MultipartFile file) throws Exception {
        String projectPath = "E:/files/";
        UUID uuid = UUID.randomUUID();

        if(file != null && !file.isEmpty()) {
            String filename = uuid + "_" + file.getOriginalFilename();
            File saveFile = new File(projectPath, filename);
            file.transferTo(saveFile);
            dto.setFilename(filename);
            dto.setFilepath("/download/" + filename);
        }

        boardMapper.write(dto);
    }

	@Override
	public int update(BoardDto dto) {
		return boardMapper.update(dto);
	}

	@Override
	public int delete(int qna_no) {
		return boardMapper.delete(qna_no);
	}
	
	@Override
	public void updateViewCount(int qna_no) {
	boardMapper.updateViewCount(qna_no);
	}

}
