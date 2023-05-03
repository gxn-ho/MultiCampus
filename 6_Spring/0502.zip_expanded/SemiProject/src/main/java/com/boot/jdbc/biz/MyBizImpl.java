package com.boot.jdbc.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.jdbc.dto.CriteriaTen;
import com.boot.jdbc.dto.MainDto;
import com.boot.jdbc.mapper.MyBoardMapper;

@Service
public class MyBizImpl implements MyBiz{
	
	@Autowired
	private MyBoardMapper myBoardMapper;

	@Override
	public List<MainDto> selectList(CriteriaTen criteriaten) {
		List<MainDto> list = myBoardMapper.selectList(criteriaten);
		return list;
	}

	@Override
	public MainDto selectOne(int no) {
		
		return myBoardMapper.selectOne(no);
	}

	@Override
	public int update(MainDto dto) {
		
		return myBoardMapper.update(dto);
	}

	@Override
	public int getTotal() {
		
		return myBoardMapper.getTotal();
	}

	

	
	
	
	
	
	
}
