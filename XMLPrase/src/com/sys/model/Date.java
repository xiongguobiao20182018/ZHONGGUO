package com.sys.model;

import java.time.LocalDateTime;
import java.util.Calendar;

public class Date {

	public static void main(String[] args) {
		/*Calendar cal=Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR));
        */
		/*LocalDateTime dt=LocalDateTime.now();
		System.out.println(dt.getHour());*/
		//System.out.println(Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH));
		/*Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		System.out.println(cal.getTime());*/
		LocalDateTime today=LocalDateTime.now();
		LocalDateTime yesdaday=today.minusDays(1);
		System.out.println(yesdaday);
		//单
	}

}
