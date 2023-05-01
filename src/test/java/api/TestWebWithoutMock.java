package api;

import api.hello.MockInterface;
import api.rest.TestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class TestWebWithoutMock {

    @Value("${test}")
    String test;
    @MockBean
    MockInterface mockInterface;
    @Autowired
    TestController testController;

    @Test
    public void testOk(){
        System.out.println();
    }

}
