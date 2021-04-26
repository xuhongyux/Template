package com.xiayu.springboot_demo.compare;

import java.util.Comparator;
import java.util.Date;
import java.util.Map;

/**
 * 根据时间排序
 */
public class DateComparator implements Comparator<Map.Entry<String, Date>>{


	public DateComparator() {
		super();

	}

	@Override
	public int compare(Map.Entry<String, Date> e1, Map.Entry<String, Date> e2) { //	升序

		Date d1 = e1.getValue();
		Date d2 = e2.getValue();

		if (d1.before(d2)) {
			return -1;
		}
		else if (d1.after(d2)) {
			return 1;
		}
		else {
			return 0;
		}
		
	}

}