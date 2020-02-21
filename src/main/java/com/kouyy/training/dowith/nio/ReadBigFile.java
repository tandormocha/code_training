package com.kouyy.training.dowith.nio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用NIO读取超大文件5G
 * @author kouyy
 *
 * 时间\t编号\t网站
 */
public class ReadBigFile {
    public static void main(String[] args) throws Exception {
        FileInputStream fis=new FileInputStream(new File("access.log"));
        FileChannel channel = fis.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true){
            buffer.clear();
            int len = channel.read(buffer);
            if (len==-1){
                break;
            }
            buffer.flip();
            //开始统计
        }

    }
}
