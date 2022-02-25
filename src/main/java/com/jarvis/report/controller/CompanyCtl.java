package com.jarvis.report.controller;

import com.alibaba.fastjson.JSONObject;
import com.jarvis.report.domain.Company;
import com.jarvis.report.service.CompanyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    //    简单分页查询 不推荐  弊端是参数过多时，看起来不优雅，实际情况较复杂
    @RequestMapping("/findAllSimplePage")
    @ResponseBody
    public Page<Company> findAllSimplePage(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "2") int size) {
        List<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC, "comname"));
        orders.add(new Sort.Order(Sort.Direction.ASC, "comaddress"));
        return companyService.findAllSimplePage(PageRequest.of(page, size, Sort.by(orders)));
    }

    //    简单分页查询2  多个参数都能接收
    @RequestMapping("/findAllSimplePageMap")
    @ResponseBody
    public String findAllSimplePageMap(@RequestBody(required = false) Map<String, Object> reqMap) {
        int page = 0;
        int size = 3;
        if (reqMap != null) {
            page = (reqMap.get("page").toString() != null) ?
                    Integer.parseInt(reqMap.get("page").toString()) : page;
            size = (reqMap.get("size").toString() != null) ?
                    Integer.parseInt(reqMap.get("size").toString()) : size;
        }
        // 排序
        List<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC, "comname"));
        orders.add(new Sort.Order(Sort.Direction.ASC, "comaddress"));

        Page<Company> pageInfo = companyService.findAllSimplePage(
                PageRequest.of(page, size, Sort.by(orders)));
        List<Company> companies = pageInfo.getContent();
        // fastjson配置
        JSONObject result = new JSONObject();
        // rows total属性是为前端列表插件服务
        result.put("rows", companies);
        result.put("total", pageInfo.getTotalElements());
        return result.toJSONString();
    }

    // 服务公司列表
    @RequestMapping("listCompany")
    public String listCompany() {
        return "/company/ListCompany.html";
    }


    //    访问页面
    @RequestMapping("/test")
    public String showPublicHtml() {
        return "redirect:/test.html";
    }

    @RequestMapping("/templateTest")
    public String showTemplateHtml() {
//        return "/CompanyHtml/templateTest.html";
//        return "testPage.html";
        return "/MyPage.html";
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
