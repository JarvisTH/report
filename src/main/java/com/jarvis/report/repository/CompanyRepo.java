package com.jarvis.report.repository;

import com.jarvis.report.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Jarvis(Tang Hui)
 * @version 1.0
 * @date 2022/2/23 21:02
 * 公司数据仓库接口
 */
@Repository
public interface CompanyRepo extends JpaRepository<Company, String> {

    // 原生sql语句查询
    @Query(value = "select * from company where comname=?1", nativeQuery = true)
    List<Company> findByNativeSQL(String name);

    @Query(value = "select * from company where comname like '%?1%'", nativeQuery = true)
    List<Company> findByNativeSQL1(String name);

    // 涉及数据变动，必须添加@Modifying注解
    @Modifying
    @Query(value = "update company set comaddress = ?1 where conname=?2",nativeQuery = true)
    void updateByName(String comaddress, String name);
}
