package cn.net.zhipeng.system.dao;

import cn.net.zhipeng.common.config.MyMapper;
import cn.net.zhipeng.system.domain.Role;
import cn.net.zhipeng.system.domain.RoleWithMenu;

import java.util.List;

public interface RoleMapper extends MyMapper<Role> {
	
	List<Role> findUserRole(String userName);
	
	List<RoleWithMenu> findById(Long roleId);
}