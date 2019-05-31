package cn.net.zhipeng.security.code.sms;


import cn.net.zhipeng.security.code.ValidateCode;
import cn.net.zhipeng.security.code.ValidateCodeGenerator;
import cn.net.zhipeng.security.properties.FebsSecurityProperties;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("smsCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private FebsSecurityProperties securityProperties;

    @Override
    public ValidateCode createCode() {
        String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
        return new ValidateCode(code, securityProperties.getCode().getSms().getExpireIn());
    }
}
