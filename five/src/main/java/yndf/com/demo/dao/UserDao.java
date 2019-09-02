package yndf.com.demo.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.*;
import yndf.com.demo.pojo.Users;

import java.util.List;
@Mapper  //自动生成xml时需要
@Component
//@Repository
//增删改返回值类型只能是数字而不能返回java类或其他，查可以
public interface UserDao {
    @Select("select * from user")
    List<Users> findAll();

    @Select("select * from user where usercode = #{usercode}")
    Users find(@Param("usercode") int usercode);

    @Insert("insert into user(usercode,username,department,hiredate) values(#{usercode},#{username},#{department},#{hiredate})")
    int insert(Users user);

    @Update("update user set usercode=#{usercode},username=#{username},department=#{department},hiredate=#{hiredate} where usercode=#{usercode}")
    int update(Users user);

    @Delete("delete from user where usercode=#{usercode}")
    int delete(int usercode);
}
