import api.hello.MockInterface;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestAsserts {

    @Mock
    MockInterface mockInterfaceMOCK;

    @Test
    public void test1(){
        when(mockInterfaceMOCK.test())
                .thenReturn("Hello from mock");

        assertThat(mockInterfaceMOCK.test())
                .isEqualTo("Hello from mock");
    }

}
