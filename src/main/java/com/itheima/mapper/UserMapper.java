package com.itheima.mapper;

import com.itheima.pojo.Brand;
import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {


    /**
     * retrieve all
     */
    @Select( "  select * from tb_user ")
    public List<User> selectAll();


    /**
     * search for one item£ºretrieve according to id
     *
     * */
    User select(@Param("username") String username,  @Param("password") String password);

}
