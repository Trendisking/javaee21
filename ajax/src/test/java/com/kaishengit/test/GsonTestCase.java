package com.kaishengit.test;

import com.google.gson.Gson;
import com.kaishengit.entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 20330 on 2016/6/23.
 */
public class GsonTestCase {
    @Test
    public void testToJson(){
        User user=new User(1,"merry","UK",99.5F);
        //对象转换成json中的对象{}
        Gson gson=new Gson();
        String json=gson.toJson(user);
        System.out.println(json);

    }
    @Test
    public void testMapToJson(){
        Map<String,Object> map=new HashMap<>();
        map.put("id",16);
        map.put("message","今晚给我打电话");
        String json=new Gson().toJson(map);
        System.out.println(json);
    }
    @Test
    public void testArrayToJson(){
        String[] names={"张三","赵四","王五"};
        String json=new Gson().toJson(names);
        System.out.println(json);

    }
    @Test
    public void testObjectArrayToJson(){
        User[] users=new User[3];
        users[0]=new User(1,"jack","USK",49.5F);
        users[1]=new User(2,"尼古拉斯.凯奇","UK",80.5F);
        users[2]=new User(3,"尼古拉斯.赵四 ","US",99.5F);
        String json=new Gson().toJson(users);
        System.out.println(json);
    }

    @Test
    public void testListToJson(){
        List<User> userList=new ArrayList<>();
        userList.add(new User(1,"jack","USK",49.5F));
        userList.add(new User(2,"尼古拉斯.凯奇","UK",80.5F));
        userList.add(new User(3,"尼古拉斯.赵四 ","US",99.5F));
        String json=new Gson().toJson(userList);
        System.out.println(json);
    }
    @Test
    public void testOtherToJson(){
        List<User> userList=new ArrayList<>();
        userList.add(new User(1,"jack","USK",49.5F));
        userList.add(new User(2,"尼古拉斯.凯奇","UK",80.5F));
        userList.add(new User(3,"尼古拉斯.赵四 ","US",99.5F));

        Map<String,Object> map=new HashMap<>();
        map.put("result","fault");
        map.put("data",userList);
        String json=new Gson().toJson(map);
        System.out.println(json);
    }
}
