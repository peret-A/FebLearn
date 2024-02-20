package com.bdqn.test05;

public class PrivateTest {
    //有私有name属性，并且属性值为hellokitty，
    private String name="hellokitty";
    //只提供name的getName的公有方法
    public String getName() {
        return name;
    }
}
