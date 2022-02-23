package com.jarvis.report.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author Jarvis(Tang Hui)
 * @version 1.0
 * @date 2022/2/23 0:15
 * 公司实体类
 */
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(generator = "myuuid")
    @GenericGenerator(name = "myuuid", strategy = "uuid")
    @Column(length = 32)
    private String uuid;

    @Column(length = 60)
    private String comname;

    @Column(length = 120)
    private String comaddress;

    @Column(length = 30)
    private String comurl;

    @Column(length = 30)
    private String comtelephone;

    @Column(columnDefinition = "char(7)")
    private String comestablishdate;

    @Column
    private int comemployeenumber;

    @Column(columnDefinition = "float(20,4) default '0.0000'")
    private String totaloutput;

    @Column(columnDefinition = "text")
    private String comdesc;

    @Column(columnDefinition = "char(4)")
    private String comstatus;

    @Column(length = 20)
    private String contactname;

    @Column(length = 20)
    private String contectmobile;

    @Column(length = 30)
    private String contactemail;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname;
    }

    public String getComaddress() {
        return comaddress;
    }

    public void setComaddress(String comaddress) {
        this.comaddress = comaddress;
    }

    public String getComurl() {
        return comurl;
    }

    public void setComurl(String comurl) {
        this.comurl = comurl;
    }

    public String getComtelephone() {
        return comtelephone;
    }

    public void setComtelephone(String comtelephone) {
        this.comtelephone = comtelephone;
    }

    public String getComestablishdate() {
        return comestablishdate;
    }

    public void setComestablishdate(String comestablishdate) {
        this.comestablishdate = comestablishdate;
    }

    public int getComemployeenumber() {
        return comemployeenumber;
    }

    public void setComemployeenumber(int comemployeenumber) {
        this.comemployeenumber = comemployeenumber;
    }

    public String getTotaloutput() {
        return totaloutput;
    }

    public void setTotaloutput(String totaloutput) {
        this.totaloutput = totaloutput;
    }

    public String getComdesc() {
        return comdesc;
    }

    public void setComdesc(String comdesc) {
        this.comdesc = comdesc;
    }

    public String getComstatus() {
        return comstatus;
    }

    public void setComstatus(String comstatus) {
        this.comstatus = comstatus;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public String getContectmobile() {
        return contectmobile;
    }

    public void setContectmobile(String contectmobile) {
        this.contectmobile = contectmobile;
    }

    public String getContactemail() {
        return contactemail;
    }

    public void setContactemail(String contactemail) {
        this.contactemail = contactemail;
    }
}
