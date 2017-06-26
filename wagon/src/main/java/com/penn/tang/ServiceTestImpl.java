package com.penn.tang;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * @Description :
 * @Project : collections
 * @Program Name  : com.penn.tang.ServiceTestImpl
 * @Author : zhongpingtang@yiruntz.com 唐忠平
 */

@Service
public class ServiceTestImpl implements ServiceTest {
    @Override
    public void test1() {
        System.out.println(123);
    }
}
