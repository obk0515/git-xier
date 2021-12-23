package com.obk;

import com.obk.util.JsoupTest;
import org.junit.jupiter.api.Test;

import java.security.Key;
import java.util.Scanner;
public class getWeather {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入和风的Key");
        String key=in.next();
        JsoupTest.cityCrawler("https://geoapi.qweather.com/v2/city/lookup?key="+key+"&location=%E7%A6%8F%E5%B7%9E");//福州
        JsoupTest.cityCrawler("https://geoapi.qweather.com/v2/city/lookup?key="+key+"&location=%E5%8C%97%E4%BA%AC");//北京
        JsoupTest.cityCrawler("https://geoapi.qweather.com/v2/city/lookup?key="+key+"&location=%E4%B8%8A%E6%B5%B7");//上海

        JsoupTest.weatherCrawler("https://devapi.qweather.com/v7/weather/3d?key="+key+"&location=101230101",101230101);//福州
        JsoupTest.weatherCrawler("https://devapi.qweather.com/v7/weather/3d?key="+key+"&location=101010100",101010100);//北京
        JsoupTest.weatherCrawler("https://devapi.qweather.com/v7/weather/3d?key="+key+"&location=101020100",101020100);//上海
    }
}
