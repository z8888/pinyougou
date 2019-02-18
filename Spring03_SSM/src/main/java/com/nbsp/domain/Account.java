package com.nbsp.domain;

import com.mchange.v2.ser.SerializableUtils;

import java.io.Serializable;
import java.util.Date;

public class Account implements Serializable {
    private Integer aid;
    private Date birthday;
    private String address;
 //   private Ssm ssm;
    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

   /* public Ssm getSsm() {
        return ssm;
    }

    public void setSsm(Ssm ssm) {
        this.ssm = ssm;
    }*/

    @Override
    public String toString() {
        return "Account{" +
                "aid=" + aid +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                '}';
    }
}
