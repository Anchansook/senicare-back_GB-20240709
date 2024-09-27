package com.korit.senicare.repository.resultSet;

//# 고객 정보 보기

public interface GetCustomerResultSet {
    Integer getCustomerNumber();
    String getProfileImage();
    String getName();
    String getBirth();
    String getChargerName();
    String getChargerId();
    String getAddress();
    String getLocation();
}
