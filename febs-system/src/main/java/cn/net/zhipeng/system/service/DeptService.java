package cn.net.zhipeng.system.service;

import cn.net.zhipeng.common.domain.Tree;
import cn.net.zhipeng.common.service.IService;
import cn.net.zhipeng.system.domain.Dept;

import java.util.List;

public interface DeptService extends IService<Dept> {

	Tree<Dept> getDeptTree();

	List<Dept> findAllDepts(Dept dept);

	Dept findByName(String deptName);

	Dept findById(Long deptId);
	
	void addDept(Dept dept);
	
	void updateDept(Dept dept);

	void deleteDepts(String deptIds);
}
