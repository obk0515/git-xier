package com.obk.util;

import com.alibaba.fastjson.JSON;
import com.obk.Bean.cityBean;
import com.obk.Bean.weatherBean;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsoupTest {
    public static void cityCrawler(String url){
        String html = HttpUtils.getHtml(url);
        Document doc = Jsoup.parse(html);
        String text = doc.getElementsByTag("body").text();
//        System.out.println(text);

        String pattern="\\[\\{(.*)}]";
        Pattern reg = Pattern.compile(pattern);
        Matcher matcher = reg.matcher(text);
        String jsonStr="";
        if(matcher.find()){
            jsonStr= matcher.group(0);
//            System.out.println(jsonStr);
        }
        List<cityBean> cityBeans = JSON.parseArray(jsonStr, cityBean.class);

        cityBean pBean = cityBeans.get(0);
        System.out.println(pBean);
        Connection conn =null;
        PreparedStatement pstmt =null;
        try {
            conn = JDBCUtils.getConnection();
            String sql="replace into city(`c_id`,`c_name`,`lat`,`lon`) values(?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,pBean.getId());
            pstmt.setString(2,pBean.getName());
            pstmt.setString(3,pBean.getLat());
            pstmt.setString(4,pBean.getLon());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (pstmt!=null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void weatherCrawler(String url,int c_id){
        String html = HttpUtils.getHtml(url);
        Document doc = Jsoup.parse(html);
        String text = doc.getElementsByTag("body").text();
        String pattern="\\[\\{(.*)}]";
        Pattern reg = Pattern.compile(pattern);
        Matcher matcher = reg.matcher(text);
        String jsonStr="";
        if(matcher.find()){
            jsonStr= matcher.group(0);
        }
        List<weatherBean> weatherBeans = JSON.parseArray(jsonStr, weatherBean.class);
        int i=0;
        for (weatherBean weatherBean : weatherBeans) {
            weatherBean.setId(c_id);
            System.out.println(weatherBean);
            Connection conn =null;
            PreparedStatement pstmt =null;
            try {
                conn = JDBCUtils.getConnection();
                String sql="replace into weather (`c_id`,`day_no`,`fxDate`,`tempMax`,`tempMin`,`textDay`) values(?,?,?,?,?,?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1,c_id);
                pstmt.setInt(2,++i);
                pstmt.setString(3,weatherBean.getFxDate());
                pstmt.setInt(4,weatherBean.getTempMax());
                pstmt.setInt(5,weatherBean.getTempMin());
                pstmt.setString(6,weatherBean.getTextDay());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                if (pstmt!=null){
                    try {
                        pstmt.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                if (conn!=null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
