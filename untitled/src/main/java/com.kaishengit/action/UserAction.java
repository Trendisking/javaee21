package com.kaishengit.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import java.util.ArrayList;
import java.util.List;

@Namespace("/user")
public class UserAction extends BaseAction {

    private String code;
    private String name;
    private List<String> nameList;
    @Action("home")
    public String list() {
        name="jack";
        System.out.println("user home");
        nameList=new ArrayList<>();
        nameList.add("niua");
        nameList.add("niub");
        nameList.add("niuc");
        return SUCCESS;
    }
    @Action(value="new",results = {
            @Result(name="success",type = "redirectAction",
                    params = {"actionName","home","namespace","/user","code","${code}"})
    })
    public String toSave() {
        code="101";
        return SUCCESS;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }
}