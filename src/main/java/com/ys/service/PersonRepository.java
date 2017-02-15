package com.ys.service;

import com.ys.bean.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by yushi on 2017/2/15.
 */
public interface PersonRepository extends CustomRepository<Person, Long> {
    //使用方法名查询，接受一个name的参数
    List<Person> findByAddress(String address);
    //使用方法名查询，接受name和address，返回为单个对象
    Person findByNameAndAddress(String name,String address);
    //使用@Query查询，参数按照名称绑定
    @Query("select p from Person p where p.name= :name and p.address= :address")
    Person withNameAndAddressQuery(@Param("name")String name,@Param("address")String address);
    //使用@NamedQuery查询，请注意实体中做的@NamedQuery的定义
    Person withNameAndAddressNamedQuery(String name,String address);

}
