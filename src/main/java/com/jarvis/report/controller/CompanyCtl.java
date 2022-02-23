package com.jarvis.report.controller;

import com.jarvis.report.domain.Company;
import com.jarvis.report.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Jarvis(Tang Hui)
 * @version 1.0
 * @date 2022/2/23 21:39
 * 公司控制层
 */
@Controller
@RequestMapping("/CompanyModule")
public class CompanyCtl {
    // 业务层注入
    @Resource(name = "companyService")
    private CompanyService companyService;

    @PostMapping("/save")
    @ResponseBody
    public void save(Company company) {
        companyService.save(company);
    }

    @GetMapping("/delete")
    @ResponseBody
    public void delete(@RequestParam String uuid) {
        companyService.delete(uuid);
    }

    @PostMapping("/multiQuery")
    @ResponseBody
    public Map<String, Object> multiQuery(@RequestBody(required = false) Map<String, Object> reqMap) {
        String a1 = reqMap.get("a1").toString();
        String a2 = reqMap.get("a2").toString();
        String a3 = reqMap.get("a3").toString();
        String a4 = reqMap.get("a4").toString();
        return reqMap;
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Company> findAll() {
        return companyService.findAll();
    }

    //    访问页面
    @RequestMapping("/test.html")
    public String showPublicHtml() {
        return "redirect:/test.html";
    }

    @RequestMapping("/templateTest.html")
    public String showTemplateHtml() {
//        return "/CompanyHtml/templateTest.html";
        return "testPage.html";
    }

    // REST风格
    @GetMapping("/company/{name}")
    @ResponseBody
    public List<Company> query1(@PathVariable String name) {
        System.out.println(name);
        return companyService.findByNativeSQL(name);
    }

    @PutMapping("/company/{addr}/{name}")
    @ResponseBody
    public String query2(@PathVariable String addr, @PathVariable String name) {
        System.out.println(addr);
        System.out.println(name);
        return "addr:" + addr + ",name:" + name;
    }
}
