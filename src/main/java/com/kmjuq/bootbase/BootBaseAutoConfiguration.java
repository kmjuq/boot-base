package com.kmjuq.bootbase;

import com.kmjuq.bootbase.constant.PropertyConstant;
import com.kmjuq.bootbase.http.BaseControllerAdvice;
import com.kmjuq.bootbase.redis.RedisConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/11/19 16:56
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(BootBaseProperties.class)
public class BootBaseAutoConfiguration {

    @Bean
    public BootBaseProperties getBootBaseProperties(){
        return new BootBaseProperties();
    }

    @Bean
    public BaseControllerAdvice exceptionHandler(){
        return new BaseControllerAdvice();
    }

    @Bean
    @ConditionalOnClass(RedisTemplate.class)
    @ConditionalOnProperty(prefix = PropertyConstant.BOOT_BASE_MODULE_PREFIX,name = PropertyConstant.BOOT_BASE_MODULE_REDIS,havingValue = PropertyConstant.YES)
    public RedisConfig redisConfig(){
        return new RedisConfig();
    }

}
