package com.crc.farming.dao;

import com.crc.farming.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    boolean insertUser(User user) ;

    User logincheck(String name, String password);

    List<User> queryAll(Integer articleid);

    boolean updateUserById(String name,String tel,String email,String address,Integer id);

    User findUserById(Integer id);

    boolean updateUserPassWordById(String password, Integer id);
}
