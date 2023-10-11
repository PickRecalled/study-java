package com.pickrecalled;

import java.io.File;
import java.io.FileNotFoundException;

public class FileRename {

    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "/Users/shuang/Downloads/小学奥数 奥林匹克数学竞赛/";
        File fi = new File(filePath);
        File[] files = fi.listFiles();
        for (File file : files) {
            String name = file.getName();
            name = name.replaceFirst("小学奥数 奥林匹克数学竞赛 - ", "");
            file.renameTo(new File((filePath + name)));
        }
        System.out.println("------- 执行完成 -------");
    }
}
