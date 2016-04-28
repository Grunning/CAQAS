package com.CAQAS.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CAQAS.pojo.Department;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer depId);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer depId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
    
    /**
     * 查询所有部门.
     * @return
     */
    List<Department> selectAllDepartments(@Param("page")Integer page, @Param("pageNum")Integer pageNum);
    
    /**
     * 批量删除.
     * @param depIds
     * @return
     */
    int deleteBatchDep(List<String> list);
    
    /**
     * 通过部门名字查询.
     * @param depName depName部门名字
     * @return 结果
     */ 
    Department selectByDepName(String depName);
}