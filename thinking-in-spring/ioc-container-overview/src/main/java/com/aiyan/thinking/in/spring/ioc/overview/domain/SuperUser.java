package com.aiyan.thinking.in.spring.ioc.overview.domain;

import com.aiyan.thinking.in.spring.ioc.overview.annotation.Super;

/**
 * @author zhangchaoyue
 * @date 2021-01-11
 */
@Super
public class SuperUser extends User {

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
