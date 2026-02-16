package com.lpu;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@ComponentScan(basePackages = "com.lpu")
//tells spring container where the bean classes present.
@Configuration
public class MyConfig {

}
//it is a replacement for Config.xml file