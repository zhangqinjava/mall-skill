package com.zq.config;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties(prefix="ignore.url")
@Component
public class IgnoreUrlsConfig {
    private  List<String> urls=new ArrayList<String>();

    public  List<String> getUrls() {
        return urls;
    }

    public  void setUrls(List<String> urls) {
        this.urls = urls;
    }
}
