package com.atguigu.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by user on 2019/1/26.
 *
 * @Author user
 */
@Configuration
public class ConfigBean   //boot -->spring  applicationContext.xml   --- @Configuration配置 ConfigBean = applicationContext.xml
{
    @Bean
    @LoadBalanced     //springCloud Ribbon 是基于Netflix Ribbon 实现的一套客户端   负载均衡的工具
    public RestTemplate getRestTemplate(){
     return new RestTemplate();
    }

    @Bean
    public IRule myRule(){         //此方法覆盖默认轮询算法
      //return  new RandomRule();  //达到随机算法代替默认的轮询算法
        return  new RetryRule();  // 先按照默认的RoundRobinRule策略获取服务，当有一个服务宕机获取几次不成功，则重新获取其他可用服务
    }
}
