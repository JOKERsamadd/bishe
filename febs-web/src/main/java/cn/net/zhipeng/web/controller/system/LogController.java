package cn.net.zhipeng.web.controller.system;

import cn.net.zhipeng.common.domain.QueryRequest;
import cn.net.zhipeng.common.domain.ResponseBo;
import cn.net.zhipeng.common.utils.FileUtils;
import cn.net.zhipeng.system.domain.SysLog;
import cn.net.zhipeng.system.service.LogService;
import cn.net.zhipeng.web.controller.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class LogController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LogService logService;

    @RequestMapping("log")
    @PreAuthorize("hasAuthority('log:list')")
    public String index() {
        return "system/log/log";
    }

    @RequestMapping("log/list")
    @PreAuthorize("hasAuthority('log:list')")
    @ResponseBody
    public Map<String, Object> logList(QueryRequest request, SysLog log) {
        return super.selectByPageNumSize(request, () -> this.logService.findAllLogs(log));
    }

    @RequestMapping("log/excel")
    @ResponseBody
    public ResponseBo logExcel(SysLog log) {
        try {
            List<SysLog> list = this.logService.findAllLogs(log);
            return FileUtils.createExcelByPOIKit("系统日志表", list, SysLog.class);
        } catch (Exception e) {
            logger.error("导出系统日志Excel失败", e);
            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
        }
    }

    @RequestMapping("log/csv")
    @ResponseBody
    public ResponseBo logCsv(SysLog log) {
        try {
            List<SysLog> list = this.logService.findAllLogs(log);
            return FileUtils.createCsv("系统日志表", list, SysLog.class);
        } catch (Exception e) {
            logger.error("导出系统日志Csv失败", e);
            return ResponseBo.error("导出Csv失败，请联系网站管理员！");
        }
    }

    @PreAuthorize("hasAuthority('log:delete')")
    @RequestMapping("log/delete")
    @ResponseBody
    public ResponseBo deleteLogss(String ids) {
        try {
            this.logService.deleteLogs(ids);
            return ResponseBo.ok("删除日志成功！");
        } catch (Exception e) {
            logger.error("删除日志失败", e);
            return ResponseBo.error("删除日志失败，请联系网站管理员！");
        }
    }
}
