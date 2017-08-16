package dao;

import pojo.DEPT;

public interface DEPTMapper {
    int deleteByPrimaryKey(Integer deptno);

    int insert(DEPT record);

    int insertSelective(DEPT record);

    DEPT selectByPrimaryKey(Integer deptno);

    int updateByPrimaryKeySelective(DEPT record);

    int updateByPrimaryKey(DEPT record);
}