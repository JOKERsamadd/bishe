package cn.net.zhipeng.quartz.service;

import cn.net.zhipeng.common.service.IService;
import cn.net.zhipeng.quartz.domain.JobLog;

import java.util.List;

public interface JobLogService extends IService<JobLog> {

	List<JobLog> findAllJobLogs(JobLog jobLog);

	void saveJobLog(JobLog log);

	void deleteBatch(String jobLogIds);
}
