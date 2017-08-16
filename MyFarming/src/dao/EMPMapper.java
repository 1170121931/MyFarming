package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pojo.EMP;
import pojo.EmpDept;
import pojo.UserInfo;

public interface EMPMapper {
	int deleteByPrimaryKey(Integer empno);

	int insert(EMP record);

	int insertSelective(EMP record);

	EMP selectByPrimaryKey(Integer empno);

	int updateByPrimaryKeySelective(EMP record);

	int updateByPrimaryKey(EMP record);

	List<EmpDept> selectEmpDepts();

	List<EmpDept> selectEmpDeptsByDeptno(Integer deptno);
	
	List<UserInfo> showMsgInfo();
}