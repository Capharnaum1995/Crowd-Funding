package com.crowdFunding.common.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SMSUtils {

    public static void sendMessage(SMS sms) {
        String url = sms.getHost() + sms.getPath() + "?" + "param=" + sms.getParam() + "&phone=" + sms.getPhoneNumber() + "&sign=" + sms.getSign() + "&skin=" + sms.getSkin();
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .header("Authorization", "APPCODE " + sms.getAppCode())
                .build();
        try (Response response = okHttpClient.newCall(request).execute()) {
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String generateRandomVerificationCode(Integer length) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int randomNumber = (int) (Math.random() * 10);
            list.add(String.valueOf(randomNumber));
        }
        return StringUtils.join(list, null);
    }
    /**
     静态加载配置文件。经过修改，不在这里加载
     private static Properties properties;
     private static String host = getProperty("sms.host");
     private static String path = getProperty("sms.path");
     private static String sign = getProperty("sms.sign");
     private static String skin = getProperty("sms.skin");
     private static String appCode = getProperty("sms.appCode");

     private static String getProperty(String key) {
     if (properties == null) {
     properties = new Properties();
     ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
     try {
     properties.load(classLoader.getResourceAsStream("application.properties"));
     } catch (IOException e) {
     e.printStackTrace();
     }
     }
     return properties.getProperty(key);
     }
     */
}
