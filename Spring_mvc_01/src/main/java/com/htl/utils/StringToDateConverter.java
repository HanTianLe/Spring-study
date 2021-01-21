package com.htl.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {
    /**
     * @param s 传入进来的字符串
     * @return
     */
    public Date convert(String s) {
        if (s == null){
            throw new RuntimeException("请您传入数据");
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            //字符串转换日期
            return dateFormat.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException("数据类型转换出现错误");
        }

    }
}
