package com.calendar.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * fileName : DevWebClient
 * author :  KimSangHoon
 * date : 2022/12/18
 */
@Profile("dev")
@Configuration
public class DevWebClient implements WebMvcConfigurer {
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new FakeAuthUserResolver());
    }
}
