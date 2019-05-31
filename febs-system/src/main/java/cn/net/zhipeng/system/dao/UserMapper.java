package cn.net.zhipeng.system.dao;

import cn.net.zhipeng.common.config.MyMapper;
import cn.net.zhipeng.system.domain.MyUser;
import cn.net.zhipeng.system.domain.UserWithRole;

import java.util.List;

public interface UserMapper extends MyMapper<MyUser> {
    
    List<MyUser> findUserWithDept(MyUser user);

    List<UserWithRole> findUserWithRole(Long userId);

    MyUser findUserProfile(MyUser user);
}