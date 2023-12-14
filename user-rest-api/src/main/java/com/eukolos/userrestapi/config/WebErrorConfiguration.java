package com.eukolos.userrestapi.config;

import com.eukolos.userrestapi.user.UserAppErrorAttributes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebErrorConfiguration {

    @Value("${user.api.version}")
    private String currentApiVersion;
    @Value("${user.sendreport.uri}")
    private String sendReportUri;

    @Bean
    public ErrorAttributes errorAttributes() {
        return new UserAppErrorAttributes(currentApiVersion, sendReportUri);
    }

}