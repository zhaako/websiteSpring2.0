package com.youtube.blog.services.impl;

import com.youtube.blog.services.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {


    private String testData;
    private int testIntData;
    @Override
    public String getTestData() {
        return "Some test data" + this.testData;
    }

    @Override
    public int getTestDataInt() {
        return this.testIntData;
    }

    @Override
    public void setTestData(String testData) {
        this.testData = testData;
    }

    @Override
    public void setTestDataInt(int testDataInt) {
        this.testIntData = testIntData;
    }

    @Override
    public boolean auth(String email, String password) {
        return false;
    }
}
