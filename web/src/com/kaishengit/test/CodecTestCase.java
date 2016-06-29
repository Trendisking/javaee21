package com.kaishengit.test;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.io.FileInputStream;

/**
 * Created by 20330 on 2016/6/14.
 */
public class CodecTestCase {
    @Test
    public void testMd5(){
        String password="123456";
        String salt="gheirgoegnfdoiaer";

        //password=DigestUtils.md5Hex(password+salt);
        password=DigestUtils.md5Hex(password);
        System.out.println(password);

    }

    public void testSha(){
        String password="456888";
        password=DigestUtils.sha1Hex(password);
        System.out.println(password);
    }

    public void checkFile() throws Exception {
        //84dd33a73a8344c02a477aba7d3bf2e9
        //84dd33a73a8344c02a477aba7d3bf2e9

        FileInputStream inputStream=new FileInputStream("D:/my2log");
        String md5=DigestUtils.md5Hex(inputStream);
        System.out.println(md5);
    }
}
