package cn.net.zhipeng.system.service;

import cn.net.zhipeng.common.service.IService;
import cn.net.zhipeng.system.domain.UserRole;

public interface UserRoleService extends IService<UserRole> {

	void deleteUserRolesByRoleId(String roleIds);

	void deleteUserRolesByUserId(String userIds);
}
