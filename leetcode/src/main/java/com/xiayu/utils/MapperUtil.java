package com.xiayu.utils;

import java.util.Date;

/**
 * @author xuhongyu
 * @create 2021-04-12 15:51
 */
public class MapperUtil {
    public static float getInterval(Date begin, Date end) {
        return (float) (end.getTime() - begin.getTime()) / 1000;
    }

}
