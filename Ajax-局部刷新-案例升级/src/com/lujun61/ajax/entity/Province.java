package com.lujun61.ajax.entity;

public class Province {
    private Integer id;
    private String name;
    private String simpleName;
    private String province;

    public Province() {
    }

    public Province(Integer id, String name, String simpleName, String province) {
        this.id = id;
        this.name = name;
        this.simpleName = simpleName;
        this.province = province;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public String getprovince() {
        return province;
    }

    public void setprovince(String province) {
        this.province = province;
    }
}
