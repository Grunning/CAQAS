package com.CAQAS.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CAQAS.model.UserResultModel;
import com.CAQAS.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);
    
    User selectByUserName(String userName);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<UserResultModel> selectAllUsers(@Param("page")Integer page, @Param("pageNum")Integer pageNum);
    
    List<User> selectUserByDepId(Integer userDepId);
}