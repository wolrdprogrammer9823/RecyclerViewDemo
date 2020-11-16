package com.wolfsea.recyclerviewdemo.util;

import android.content.Context;

/**
 * @author liuliheng
 * @desc  屏幕相关的工具
 * @time 2020/11/12  22:58
 **/
public class ScreenUtil {

    /**
     *@desc dp转化为像素
     *@author:liuliheng
     *@time: 2020/11/12 23:01
    **/
    public static int dp2px(Context context, float dpValue) {
         //px = dip * (dpi / 160)
         //dip = px / (dpi / 160)
        //density(dip)密度无关像素   == 1px 160dpi
        //px 像素
        //dpi 像素密度
        float density = context.getResources().getDisplayMetrics().density;
        return (int)(density * (dpValue / 160) + 0.5f);
    }

    /**
     *@desc 像素转密度
     *@author:liuliheng
     *@time: 2020/11/12 23:48
    **/
    public static int px2dp(Context context, float pxValue) {

        float density = context.getResources().getDisplayMetrics().density;
        return (int) ((pxValue * 160) / density + 0.5f);
    }

}
