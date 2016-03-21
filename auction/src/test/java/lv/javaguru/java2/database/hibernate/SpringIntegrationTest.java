package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.config.SpringAppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by papa on 15.3.3.
 */
//@Ignore

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringAppConfig.class)
@WebAppConfiguration
@TransactionConfiguration(defaultRollback = false)
public class SpringIntegrationTest {

    @Test
    public void test() {

    }


}
