package com.test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTest {
    @Test
    public void testCalculator() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("emulator-5554"); // 정훈님의 에뮬레이터 이름 확인
        options.setAppPackage("com.google.android.calculator"); // 기본 계산기 패키지
        options.setAppActivity("com.android.calculator2.Calculator");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        
        System.out.println("계산기 실행 성공!");
        
        driver.quit();
    }
}