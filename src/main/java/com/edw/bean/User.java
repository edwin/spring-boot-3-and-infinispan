package com.edw.bean;

import org.infinispan.protostream.annotations.ProtoDoc;
import org.infinispan.protostream.annotations.ProtoField;

import java.io.Serializable;


/**
 * <pre>
 *     com.edw.bean.User
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 27 Apr 2023 11:31
 */
@ProtoDoc("@Indexed")
public class User implements Serializable {

    private String name;

    private Integer age;

    private String address;

    public User() {
    }

    public User(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @ProtoDoc("@Field(store = Store.YES, index=Index.YES, analyze = Analyze.YES, analyzer = @Analyzer(definition= \"standard\"))")
    @ProtoField(number = 1, required = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ProtoDoc("@Field(store = Store.YES, index=Index.YES)")
    @ProtoField(number = 2)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @ProtoDoc("@Field(store = Store.YES, index=Index.YES, analyze = Analyze.YES, analyzer = @Analyzer(definition= \"standard\"))")
    @ProtoField(number = 3)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
