package cn.net.zhipeng.quartz.dao;

import cn.net.zhipeng.common.config.MyMapper;
import cn.net.zhipeng.quartz.domain.Job;

import java.util.List;

public interface JobMapper extends MyMapper<Job> {

	List<Job> queryList();
}