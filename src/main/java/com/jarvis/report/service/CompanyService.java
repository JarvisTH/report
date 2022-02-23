package com.jarvis.report.service;

import com.jarvis.report.domain.Company;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Jarvis(Tang Hui)
 * @version 1.0
 * @date 2022/2/23 21:22
 * 公司业务层接口
 */
public interface CompanyService {
    // 保存
    void save(Company company);

    // 根据uuid删除
    @Transactional
    void delete(String uuid);

    // 修改
    @Transactional
    void update(Company company);

    // 查询全部数据
    List<Company> findAll();

    // 执行原生SQL语句查询
    List<Company> findByNativeSQL(String company);
}
