package cn.net.zhipeng.system.service;

import cn.net.zhipeng.common.service.IService;
import cn.net.zhipeng.system.domain.SysLog;

import java.util.List;

public interface LogService extends IService<SysLog> {
	
	List<SysLog> findAllLogs(SysLog log);
	
	void deleteLogs(String logIds);
}
