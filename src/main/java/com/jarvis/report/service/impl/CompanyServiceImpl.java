package com.jarvis.report.service.impl;

import com.jarvis.report.domain.Company;
import com.jarvis.report.repository.CompanyRepo;
import com.jarvis.report.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Jarvis(Tang Hui)
 * @version 1.0
 * @date 2022/2/23 21:27
 * 公司业务层实现类
 */
@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepo companyRepo;

    @Override
    public void save(Company company) {
        companyRepo.save(company);
    }

    @Override
    public void delete(String uuid) {
        companyRepo.deleteById(uuid);
    }

    @Transactional
    @Override
    public void update(Company company) {
        companyRepo.save(company);
    }

    @Override
    public List<Company> findAll() {
        return companyRepo.findAll();
    }

    @Override
    public List<Company> findByNativeSQL(String company) {
        return companyRepo.findByNativeSQL(company);
    }
}
