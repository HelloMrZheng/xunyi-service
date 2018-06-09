package com.helpu.user.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
	

	public static void main(String[] args) {
		GregorianCalendar gregorianCalendar = new GregorianCalendar(Calendar.YEAR, Calendar.JANUARY, 1);
		GregorianCalendar gregorianCalendar2 = new GregorianCalendar(Calendar.YEAR, Calendar.JANUARY, 1);
		System.out.println(gregorianCalendar.getTime());
		System.out.println(gregorianCalendar2.getTime());
		Date date = gregorianCalendar2.getTime();
		System.out.println(date);
		System.out.println(gregorianCalendar.equals(gregorianCalendar2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(new Date().before(date));
		
	}
	
	
}
