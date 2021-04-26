package com.xiayu.springboot_demo.compare;

import java.util.Comparator;

/**
 * 用于比较Long
 */

public class LongCountComparator  implements Comparator<Long>{

	public LongCountComparator() {
		super();

	}

	@Override
	public int compare(Long e1, Long e2) { //Long的从小到大排列
		if (e1 > e2) {
			return 1;
		}
		else if (e1 < e2) {
			return -1;
		}
		else {
			return 0;
		}
	}
		
}

