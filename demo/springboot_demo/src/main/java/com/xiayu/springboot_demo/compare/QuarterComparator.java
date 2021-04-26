package com.xiayu.springboot_demo.compare;

import java.util.Comparator;

/**
 * 根据时间排序
 */


public class QuarterComparator implements Comparator<String>{


	public QuarterComparator() {
		super();

	}

	@Override
	public int compare(String q1, String q2) { //	升序

		String[] sq1 = q1.split("-");
		int yearFirstInt = Integer.parseInt(sq1[0]);
		int quarterFirstInt = Integer.parseInt(sq1[1].replace("Q", ""));

		String[] sq2 = q2.split("-");
		int yearSecondInt = Integer.parseInt(sq2[0]);
		int quarterSecondInt = Integer.parseInt(sq2[1].replace("Q", ""));

		if (yearFirstInt == yearSecondInt) {	// 同年

			if (quarterFirstInt < quarterSecondInt) {
				return -1;
			} else if (quarterFirstInt == quarterSecondInt) {
				return 0;
			} else {
				return 1;
			}
		}

		if (yearFirstInt < yearSecondInt) {
			return -1;
		} else {
			return 1;
		}
		
	}

}