package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Pengurangan {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "Oppo A12");
        dc.setCapability("udid", "EEOZJR59DACELZD6");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "com.google.android.calculator");
        dc.setCapability("appActivity", "com.android.calculator2.Calculator");
        dc.setCapability("noReset", true);
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, dc);
        System.out.println("Appium Online");

        MobileElement btnSatu = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_1");
        MobileElement btnDua = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_2");
        MobileElement btnTiga = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_3");
        MobileElement btnTambah = (MobileElement) driver.findElementById("com.google.android.calculator:id/op_add");
        MobileElement btnKurang = (MobileElement) driver.findElementById("com.google.android.calculator:id/op_sub");
        MobileElement btnSamaDengan = (MobileElement) driver.findElementById("com.google.android.calculator:id/eq");

        btnTiga.click();
        System.out.println("klik 3");

        btnKurang.click();
        System.out.println("klik -");

        btnSatu.click();
        System.out.println("klik 1");

        btnSamaDengan.click();
        System.out.println("klik =");

        MobileElement txtHasil = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
        String hasil = txtHasil.getText();
        System.out.println("hasilnya adalah " + hasil);

        if (hasil.equals("2")){
            System.out.println("oke");
        } else {
            System.out.println("fail");
        }
    }
}


//ASSCI