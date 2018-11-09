package com.walle.shiroDemo.mapper;

import com.walle.shiroDemo.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    //    @Select("select * from user where name = #{name}")
    public User findByName(String name);
}
