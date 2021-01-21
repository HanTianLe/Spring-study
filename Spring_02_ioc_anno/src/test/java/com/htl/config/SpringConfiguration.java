package com.htl.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//用于指定当前类是一个Spring配置类，当创建容器时会从该类上加载注解
@Configuration
//<!--注解的组件扫描-->
//<context:component-scan base-package="com.htl"/>
@ComponentScan("com.htl")
//<import resource=""/>                     //引入其他文件
@Import({DataSourceConfiguration.class})    //用于导入其他配置类
public class SpringConfiguration {

}
