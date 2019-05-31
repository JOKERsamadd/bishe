package cn.net.zhipeng.system.service;

import cn.net.zhipeng.common.service.IService;
import cn.net.zhipeng.system.domain.RoleMenu;

public interface RoleMenuServie extends IService<RoleMenu> {

	void deleteRoleMenusByRoleId(String roleIds);

	void deleteRoleMenusByMenuId(String menuIds);
}
