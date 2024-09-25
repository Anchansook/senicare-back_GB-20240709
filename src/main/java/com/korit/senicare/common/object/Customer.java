package com.korit.senicare.common.object;

import java.util.List;

import com.korit.senicare.repository.resultSet.GetCustomerResultSet;

import java.util.ArrayList;

import lombok.Getter;

//# 고객 리스트 객체

@Getter
public class Customer {
    private Integer customerNumber;
    private String name;
    private String birth;
    private String location;
    private String chargerName;
    private String chargerId;

    // CustomerEntity만으론 필요한 리스트의 정보를 다 가져올 수 없음 (없는게 있음)
    // : CustomerEntity와 NurseEntity join해서 결과를 얻어와야 함

    // 생성자
    private Customer(GetCustomerResultSet resultSet) {
        this.customerNumber = resultSet.getCustomerNumber();
        this.name = resultSet.getName();
        this.birth = resultSet.getBirth();
        this.location = resultSet.getLocation();
        this.chargerName = resultSet.getChargerName();
        this.chargerId = resultSet.getChargerId();
    }

    public static List<Customer> getList(List<GetCustomerResultSet> resultSets) {

        List<Customer> customers = new ArrayList<>();

        for (GetCustomerResultSet resultSet: resultSets) {
            Customer customer = new Customer(resultSet);
            customers.add(customer);
        }

        return customers;

    }
}
