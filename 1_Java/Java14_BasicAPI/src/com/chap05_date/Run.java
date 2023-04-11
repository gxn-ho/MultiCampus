package com.chap05_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Run {

	public static void main(String[] args) {
		//Date originTime  = new Date(1000L);
		//String originTime = new Date(0L).toGMTString()
		
		//System.out.println(originTime);
		
		Date day = new Date(123,3-1,3);
		System.out.println(day);
		
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		System.out.println(sdf.format(today));
		System.out.println(today.getDate());

		System.out.println("----캘린더----");
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar);
	
		calendar.set(2022, 9-1, 9);
		
		System.out.println(calendar.get(1)+"년 "+
				(calendar.get(Calendar.MONTH)+1)+"월 "+
				calendar.get(Calendar.DATE)+"일 "+
				calendar.get(Calendar.HOUR)+":"+
				calendar.get(Calendar.MINUTE)+":"+
				calendar.get(Calendar.SECOND)
				);
		
		sdf = new SimpleDateFormat("yyyy년mm월dd일 hh:mm:ss");
		System.out.println(sdf.format(calendar.getTime()));
		
		
		System.out.println("====그레고리안====");
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(gc.getTime());
		
		System.out.println(gc.get(Calendar.YEAR));
		System.out.println(gc.get(GregorianCalendar.MONTH)+1);
		
		gc.set(2019, 12-1, 25);
		System.out.println(gc.getTime());
		
	}

	

	
}