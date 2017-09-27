package service;

import com.hlh.aop.entity.HlhUserEntity;
import com.hlh.aop.service.AopTestService;
import com.hlh.aop.valid.ValidateException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by hebo on 2017-9-27.
 */
public class AopTestServiceTest extends BaseTest{

    @Autowired
    private AopTestService aopTestService;

    @Test
    public void testAop(){
        try {
            HlhUserEntity userEntity = new HlhUserEntity();
//            userEntity.setUsername("username1");
            userEntity.setPassword("123123123");
            aopTestService.test(userEntity);
        } catch (ValidateException v){
            System.out.println(v.getErrMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
