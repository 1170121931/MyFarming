package dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import pojo.UserInfo;

public interface UserInfoMapper {
	int deleteByPrimaryKey(int userid);

	int insert(UserInfo record);

	int insertSelective(UserInfo record);

	UserInfo selectByPrimaryKey(int userid);

	int updateByPrimaryKeySelective(UserInfo record);

	int updateByPrimaryKey(UserInfo record);

	int call_proc_addUser();

	Map<Integer, UserInfo> call_proc_getUser();

	List<UserInfo> selectUserList();
}