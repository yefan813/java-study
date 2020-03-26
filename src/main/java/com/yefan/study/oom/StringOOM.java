package com.yefan.study.oom;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StringOOM {
    public static void main(String[] args) {
        List<Object> list  = new ArrayList();
        for (int i = 1 ; i < 1000; i++) {
            list.add(new byte[1024*1024]);
        }
    }
}
