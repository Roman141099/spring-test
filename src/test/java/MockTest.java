import api.hello.MockInterface;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockTest {

    @Mock
    MockInterface mockInterface;

    @Test
    public void testNthg(){
        Mockito.doNothing().when(mockInterface).go(Mockito.any());
        mockInterface.go("Hello");
    }

    @Test
    public void testThrow(){
        Mockito.doThrow(new RuntimeException()).when(mockInterface).go(Mockito.any());
        Assertions.assertThatThrownBy(() -> mockInterface.go("Hello"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void testCaptor(){
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        Mockito.doNothing().when(mockInterface).go(stringArgumentCaptor.capture());
        mockInterface.go("Hello");

        System.out.println(stringArgumentCaptor.getValue());

        Mockito.verify(mockInterface, Mockito.times(1)).go(stringArgumentCaptor.getValue());
    }

    @Test
    public void testCaptor2(){

        Mockito.doNothing().when(mockInterface).go(Mockito.eq(new String("Hello")));
        mockInterface.go("Hello");

        Mockito.verify(mockInterface, Mockito.times(1)).go(Mockito.any());
    }

}
