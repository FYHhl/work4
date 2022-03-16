package com.example.mybatisWork.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private Integer id;
    private String addr;
    private String phone;
    private String postcode;
    private int userId;
}
