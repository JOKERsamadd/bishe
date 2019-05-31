package cn.net.zhipeng.system.service;

import cn.net.zhipeng.common.service.IService;
import cn.net.zhipeng.system.domain.UserConnection;

import java.util.List;

public interface UserConnectionService extends IService<UserConnection> {

    boolean isExist(String userId, String providerId);

    List<UserConnection> findByProviderUserId(String providerUserId);

    void delete(UserConnection userConnection);
}
