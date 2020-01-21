package com.crowdFunding.common.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SMSUtils {

    private static Properties properties;

    private static String host = getProperty("sms.host");
    private static String path = getProperty("sms.path");
    private static String sign = getProperty("sms.sign");
    private static String skin = getProperty("sms.skin");
    private static String appCode = getProperty("sms.appCode");

    public static void sendMessage(String phoneNumber, String param) {
        String url = host + path + "?" + "param=" + param + "&phone=" + phoneNumber + "&sign=" + sign + "&skin=" + skin;
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .header("Authorization", "APPCODE " + appCode)
                .build();
        try (Response response = okHttpClient.newCall(request).execute()) {
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean strCheckEffective(String string) {
        return (string != null) && (string.length() > 0);
    }

    public static String generateRandomVerificationCode(Integer length) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int randomNumber = (int) (Math.random() * 10);
            list.add(String.valueOf(randomNumber));
        }
        return StringUtils.join(list, null);
    }

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
}
