package com.edw.bean;

import java.io.Serializable;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.KeywordField;


/**
 * <pre>
 *     com.edw.bean.User
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 27 Apr 2023 11:31
 */
@Indexed
public class User implements Serializable {

    @KeywordField
    private String name;

    @KeywordField
    private Integer age;

    @KeywordField
    private String address;

    public User() {
    }

    public User(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
