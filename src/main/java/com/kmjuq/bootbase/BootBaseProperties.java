package com.kmjuq.bootbase;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/11/19 16:57
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "ke.config")
public class BootBaseProperties {


    @Setter
    @Getter
    private class RedisProperties{

    }

}
