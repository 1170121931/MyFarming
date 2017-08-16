package service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import pojo.UserInfo;
@Repository
public interface IUserInfoService {
	boolean deleteByPrimaryKey(int userid);

	boolean insert(UserInfo record);

	boolean insertSelective(UserInfo record);

	UserInfo selectByPrimaryKey(int userid);

	boolean updateByPrimaryKeySelective(UserInfo record);

	boolean updateByPrimaryKey(UserInfo record);

	boolean call_proc_addUser();

	Map<Integer, UserInfo> call_proc_getUser();

	List<UserInfo> selectUserList();
}
