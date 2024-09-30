package com.korit.senicare.common.object;

import java.util.ArrayList;
import java.util.List;

import com.korit.senicare.entity.CustomerEntity;

import lombok.Getter;

@Getter
public class ChargedCustomer {
    private Integer customerNumber;
    private String name;
    private String birth;
    private String location;

    // 생성자
    private ChargedCustomer(CustomerEntity customerEntity) {
        this.customerNumber = customerEntity.getCustomerNumber();
        this.name = customerEntity.getName();
        this.birth = customerEntity.getBirth();
        this.location = customerEntity.getLocation();
    }

    // List<CustomerEntity> => List<ChargedCustomer> 바꾸는 작업
    public static List<ChargedCustomer> getList(List<CustomerEntity> customerEntities) {
        List<ChargedCustomer> customers = new ArrayList<>();

        for (CustomerEntity customerEntity: customerEntities) {
            ChargedCustomer customer = new ChargedCustomer(customerEntity);
            customers.add(customer);
        }

        return customers;
    }
}

// CustomerEntity로 다 표현 가능 resultSet 필요 없음
