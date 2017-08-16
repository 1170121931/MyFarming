package service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pojo.UserInfo;
import service.IUserInfoService;
import dao.*;
@Service
public class UserInfoService implements IUserInfoService {
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Override
	public boolean deleteByPrimaryKey(int userid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(UserInfo record) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertSelective(UserInfo record) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserInfo selectByPrimaryKey(int userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateByPrimaryKeySelective(UserInfo record) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateByPrimaryKey(UserInfo record) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean call_proc_addUser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<Integer, UserInfo> call_proc_getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfo> selectUserList() {
		// TODO Auto-generated method stub
		return userInfoMapper.selectUserList();
	}

}
