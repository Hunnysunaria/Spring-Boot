package com.product.productrest;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProdAspect {
    private static final Logger logger= LoggerFactory.getLogger(PerformanceMonitorInterceptor.class);



}
