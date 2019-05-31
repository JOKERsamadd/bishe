package cn.net.zhipeng.security.social.qq.config;

import cn.net.zhipeng.security.properties.FebsSecurityProperties;
import cn.net.zhipeng.security.properties.QQProperties;
import cn.net.zhipeng.security.social.SocialConnectedView;
import cn.net.zhipeng.security.social.qq.connect.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.social.autoconfigure.SocialAutoConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.web.servlet.View;

@Configuration
@ConditionalOnProperty(prefix = "febs.security.social.qq", name = "app-id")
@Order(2)
public class QQAutoConfig extends SocialAutoConfigurerAdapter {

    @Autowired
    private FebsSecurityProperties securityProperties;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        QQProperties properties = securityProperties.getSocial().getQQ();
        return new QQConnectionFactory(properties.getProviderId(), properties.getAppId(), properties.getAppSecret());
    }

    @Bean({"connect/qqConnect", "connect/qqConnected"})
    public View qqConnectedView() {
        return new SocialConnectedView();
    }
}
