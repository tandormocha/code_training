package com.kouyy.training.dowith.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用NIO复制文件
 * @author kouyy
 */
public class CopyFileDemo {
    public static void main(String[] args) throws Exception {
       /* FileInputStream fis=new FileInputStream(new File("source.txt"));
        FileOutputStream fos=new FileOutputStream(new File("dest.txt"));
        //获得读文件的通道
        FileChannel readChannel = fis.getChannel();
        //获得写文件的通道
        FileChannel writeChannel = fos.getChannel();
        //定义一个缓冲
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //不断读写
        while (true){
            //保证每次读开始缓冲为0
            buffer.clear();
            int len = readChannel.read(buffer);
            if(len==-1){
                //while循环结束
                break;
            }
            //buffer.flip()一定要有，指将读Buffer的指针指向buffer第一位
            buffer.flip();
            writeChannel.write(buffer);
        }
        //关闭管道
        readChannel.close();
        writeChannel.close();*/
        FileInputStream fis=new FileInputStream(new File("source.txt"));
        FileOutputStream fos=new FileOutputStream(new File("dest.txt"));
        FileChannel readChannel = fis.getChannel();
        FileChannel writeChannel = fos.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true){
            buffer.clear();
            int len = readChannel.read(buffer);
            if(len==-1){
                break;
            }
            buffer.flip();
            writeChannel.write(buffer);
        }
        readChannel.close();
        writeChannel.close();
    }
}
