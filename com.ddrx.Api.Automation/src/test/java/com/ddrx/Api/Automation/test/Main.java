package com.ddrx.Api.Automation.test;
public class Main {
    public static void main(String[] args) {
        TestClass test = new TestClass();
        test.setName("John");
        test.setAge(30);
        System.out.println("Name: " + test.getName() + ", Age: " + test.getAge());
    }
}
