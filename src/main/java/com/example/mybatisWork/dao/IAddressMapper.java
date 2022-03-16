package com.example.mybatisWork.dao;

import com.example.mybatisWork.pojo.Address;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface IAddressMapper {
    @Select("select * from t_address where id = #{id}")
    public Address getAddressById(int id);
    @Insert("insert into t_address (addr,phone,postcode) values (#{addr},#{phone},#{postcode})")
    public Address setAddressById(Address address);
}
