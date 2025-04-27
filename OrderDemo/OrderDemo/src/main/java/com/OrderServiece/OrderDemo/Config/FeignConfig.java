package com.OrderServiece.OrderDemo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.OrderServiece.OrderDemo.External.Decoder.CustomeErrorDecoder;

import feign.codec.ErrorDecoder;
import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
public class FeignConfig {

    @Bean
    ErrorDecoder errorDecoder() {
        return new CustomeErrorDecoder();
    }

}
