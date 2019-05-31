package cn.net.zhipeng.web.controller.security;

import cn.net.zhipeng.common.domain.FebsConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {

    @RequestMapping(FebsConstant.FEBS_ACCESS_DENY_URL)
    public String accessDeny(){
        return "error/403";
    }
}
