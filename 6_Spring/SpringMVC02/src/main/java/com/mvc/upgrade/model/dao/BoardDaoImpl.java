package com.mvc.upgrade.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<BoardDto> selectList() {
		List<BoardDto> res = new ArrayList<BoardDto>();
		
		try {
			res = sqlSession.selectList(NAMESPACE+"selectList");
		} catch (Exception e) {
			System.out.println("[error] : select list");
			e.printStackTrace();
		}
		
		
		return res;
	}

	@Override
	public BoardDto selectOne(int myno) {
		return null;
	}

	@Override
	public int insert(BoardDto dto) {
		return 0;
	}

	@Override
	public int update(BoardDto dto) {
		return 0;
	}

	@Override
	public int delete(int myno) {
		return 0;
	}
	
}
