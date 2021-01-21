package com.htl.anno;

import org.springframework.stereotype.Component;

@Component("target")
public class Target implements TargetInterface {

    public void save() {
//        int x = 1/0;
        System.out.println("save running....");
//        int i = 1/0;
        //异常的位置不同，会导致输出语句是否被执行。
    }

}
