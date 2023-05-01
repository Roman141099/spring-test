package api;

import api.hello.MockInterface;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@TestPropertySource("classpath:application.yaml")
@ContextConfiguration(classes = TestApplication.class)
public class TestAssertJ {

    @Value("${test}")
    String s;
    @Autowired
    MockInterface mockInterface;

    @Test
    public void test1(){
        Assertions.assertThat(mockInterface.testList())
                .hasSize(2)
                .extracting("testInt")
                .containsExactly(1,2);
    }

}
