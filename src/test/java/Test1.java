import extension.BeforeEachExtension;
import extension.TestLoggingExtension;
import api.hello.MockInterface;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class, TestLoggingExtension.class, BeforeEachExtension.class})
public class Test1 {

    @Mock
    static MockInterface mockInterface;

    @Test
    @DisplayName("Test 1 name")
    public void test1() {
        System.out.println(mockInterface.test());
    }

    @Test
    public void test2() {
        System.out.println(mockInterface.test());
    }

    @Test
    public void testException() {
        System.out.println(mockInterface.test());
        if (true) {
            throw new RuntimeException();
        }
    }

    @Test
    public void testMock() {
        when(mockInterface.test()).thenReturn("Hello value");
        System.out.println(mockInterface.test());
    }

}
