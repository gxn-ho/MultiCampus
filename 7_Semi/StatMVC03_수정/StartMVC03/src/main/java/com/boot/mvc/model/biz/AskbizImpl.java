package com.boot.mvc.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.mvc.model.dto.AskDto;
import com.boot.mvc.model.mapper.AskMapper;

@Service
public class AskbizImpl implements Askbiz{
	
	@Autowired
	private AskMapper askmapper;


	@Override
	public int insert(AskDto dto, String user_id, int no) {
		return askmapper.insert(dto, user_id, no);
	}

	@Override
	public AskDto selectOne(int no) {
		return null;
	}


	@Override
	public List<AskDto> selectList() {
		return askmapper.select();
	}

	@Override
	public int update(int no, String reply) {
		return askmapper.update(no, reply);
	}
	
	
}
