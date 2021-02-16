package com.kmjuq.bootbase;

import com.kmjuq.bootbase.constant.PropertyConstant;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>
 * base 工具包的所有配置信息
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/11/19 16:57
 */
@Setter
@Getter
@ConfigurationProperties(PropertyConstant.BOOT_BASE_PREFIX)
public class BootBaseProperties {

    @Setter
    @Getter
    @ConfigurationProperties(PropertyConstant.BOOT_BASE_MODULE_PREFIX)
    private static class BaseModule{
        private boolean redis=false;
    }

    @Setter
    @Getter
    @ConditionalOnProperty(prefix = PropertyConstant.BOOT_BASE_MODULE_PREFIX,name = PropertyConstant.BOOT_BASE_MODULE_REDIS,havingValue = PropertyConstant.YES)
    @ConfigurationProperties(PropertyConstant.BOOT_BASE_CONFIG_REDIS_PREFIX)
    private static class RedisProperties{
        private String host;
        private String port;
    }

}
