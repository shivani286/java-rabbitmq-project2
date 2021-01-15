package com.rabbitmq.myBatisMapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.rabbitmq.entity.MyBatisObject;

@Mapper
public interface PolicyMapper {

	@Select("select * from policy_table")
	List<MyBatisObject> findAll();

	@Insert("insert into policy_table(quote_number,status) values(#{quotenumber},#{status})")
    @SelectKey(statement = "SELECT LASTVAL()", keyProperty = "id",
            before = false, resultType = Integer.class)
	void insert(MyBatisObject myBatisObject);
	
	@Select("select id, quote_number,status from users WHERE id=#{id}")
	MyBatisObject findPolicyById(Integer id);

}
