package com.boot.jdbc.biz;

import java.util.List;


import com.boot.jdbc.dto.CriteriaTen;
import com.boot.jdbc.dto.MainDto;

public interface MyBiz {
	public List<MainDto> selectList(CriteriaTen criteriaten);
	public MainDto selectOne(int no);
	public int update(MainDto dto);
	public int getTotal();
}
