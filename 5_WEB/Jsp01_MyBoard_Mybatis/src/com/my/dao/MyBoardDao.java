package com.my.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.my.dto.MyBoardDto;

public class MyBoardDao extends SqlMapConfig {
	private String namespace = "com.my.myboard.";
	
	
	//전체 출력
	public List<MyBoardDto> selectAll(){
		List<MyBoardDto> res = new ArrayList<MyBoardDto>();
		
		SqlSession session = getSqlSessionFactory().openSession(true);
		//openSession(true): autoCommit
		
		res = session.selectList("com.my.myboard.selectAll");
		//"com.my.myboard"라는 namespace로 설정된 mapper 파일에서
		//"selectAll"라는 id를 가진 sql 실행
		
		session.close();
		
		return res;
	}
	
	//추가
	public int insert(MyBoardDto dto) {
		SqlSession session = null;
		int res = 0;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.insert(namespace+"myinsert",dto);
		
		session.close();
		
		return res;
	}
	
	//선택 출력
	public MyBoardDto selectOne(int myno) {
		SqlSession session = null;
		MyBoardDto res = null;
		
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.selectOne(namespace+"selectOne", myno);
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return res;
	}
	
	//수정
	public int update(MyBoardDto dto) {
		return 0;
	}
	
	
	//삭제
	public int delete(int myno) {
		return 0;
	}
	
	//multi delete
	//jsp02_MVC에서 delete()를 mybatis로 변경(batch를 이용한 여러 개 삭제)
	public int multiDelete(String[] seq) {
		int count = 0;
		Map<String,String[]> map = new HashMap<>();
		map.put("seq", seq);
		
		SqlSession session = getSqlSessionFactory().openSession();
		count = session.delete(namespace+"muldel",map);
		
		if(count == seq.length) {
			session.commit();
			
		}
		session.close();
		
		return count;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
