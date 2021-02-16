package com.kmjuq.bootbase;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/11/19 16:56
 */
@Slf4j
@Configuration
@ComponentScan("com.kmjuq.bootbase")
@EnableConfigurationProperties(BootBaseProperties.class)
public class BootBaseAutoConfiguration {

}
