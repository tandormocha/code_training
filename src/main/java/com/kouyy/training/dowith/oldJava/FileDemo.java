package com.kouyy.training.dowith.oldJava;

import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        /*File file=new File("E:\\a.dic");
        List<String> list = FileUtils.readLines(file);

        Set<String> set=new HashSet<>(list);

        File tagFile=new File("E:\\tag.dic");
        FileUtils.writeLines(tagFile,set);*/

        String str="1,2，3,";
        String[] s = str.split("[\\,，\\\\]");
        for (String s1 : s) {
            System.out.println(s.length);
        }
    }
}
