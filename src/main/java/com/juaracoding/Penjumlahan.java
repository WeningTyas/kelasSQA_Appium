package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Penjumlahan {

    public static void main(String[] args) throws MalformedURLException {
        // ini bagian setting utk eksekusi awal aplikasi di HPnya //
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

        // Inisiasi elemen tombol yg bkl dipakai //
        MobileElement btnSatu = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_1");
        MobileElement btnDua = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_2");
        MobileElement btnTambah = (MobileElement) driver.findElementById("com.google.android.calculator:id/op_add");
        MobileElement btnSamaDengan = (MobileElement) driver.findElementById("com.google.android.calculator:id/eq");

        // Eksekusi tombol //
        btnSatu.click();
        System.out.println("klik 1");

        btnTambah.click();
        System.out.println("klik +");

        btnDua.click();
        System.out.println("klik 2");

        btnSamaDengan.click();
        System.out.println("klik =");

        // Ini di eksekusi terakhir, karena bagian hasil ini bakal muncul setelah tombol sama dengan (=) di klik
        MobileElement txtHasil = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
        String hasil = txtHasil.getText();
        System.out.println("hasilnya adalah " + hasil);

        // Verifikasi assert manual //
        if (hasil.equals("3")){
            System.out.println("oke");
        } else {
            System.out.println("fail");
        }

        /*
        * Tujuannya :
          Di aplikasi kalkulator (google) yg bisa di download di google play
          klik 1+2= agar dapat hasil 3

          Jangan lupa di setting HP (terutama yg real device)
            * Jadikan Developer mode, atau mode Pengembang
            * Debugging USB, on
            * Paksa izinkan aplikasi Eksternal

            * Tambahan:
            * - Jangan gunakan layar kunci
            * - Biarkan layar hidup selagi mengisi daya (soalnya klo mati, nanti Appiumnya putus)
            * - Matikan pemantauan izin
         */
    }
}
