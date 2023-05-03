package com.boot.mvc.model.biz;

import java.util.List;


import com.boot.mvc.model.dto.CriteriaTen;
import com.boot.mvc.model.dto.MainDto;

public interface MyBiz {
	public List<MainDto> selectList(CriteriaTen criteriaten);
	public MainDto selectOne(int no);
	public int update(MainDto dto);
	public int getTotal();
}
