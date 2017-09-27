package com.hlh.aop.service.impl;

import com.hlh.aop.annotation.ParamsValid;
import com.hlh.aop.entity.HlhUserEntity;
import com.hlh.aop.service.AopTestService;
import org.springframework.stereotype.Service;

/**
 *
 * Created by hebo on 2017-9-27.
 */
@Service
public class AopTestServiceImpl implements AopTestService{

    @ParamsValid
    public void test(HlhUserEntity userEntity) {
        System.out.println("----------------------userEntity = "+ userEntity);
    }
}
