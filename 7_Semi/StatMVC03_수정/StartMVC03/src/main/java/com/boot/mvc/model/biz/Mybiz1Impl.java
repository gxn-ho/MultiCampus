package com.boot.mvc.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.mvc.model.dto.MyDto;
import com.boot.mvc.model.mapper.myMapper;
@Service
public class Mybiz1Impl implements Mybiz1{
	
	@Autowired
	private myMapper mapper;

	@Override
	public int insert(MyDto dto, String user_id) {
		return mapper.insert(dto, user_id);
	}

	@Override
	public List<MyDto> select() {
		return mapper.select();
	}

	@Override
	public int update(String description, int no) {
		// TODO Auto-generated method stub
		return mapper.update(description, no);
	}

	@Override
	public MyDto selectOne(String title) {
		return mapper.selectOne(title);
	}

	@Override
	public MyDto selectOne(int room_id) {
		return mapper.selectOne(room_id);
	}

//	@Override
//	public int update(int current, int room_id) {
//		return mapper.update(current, room_id);
//	}
	
	

}
