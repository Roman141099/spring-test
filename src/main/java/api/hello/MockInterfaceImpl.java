package api.hello;

import api.dto.TestDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MockInterfaceImpl implements MockInterface{

    @Value("${test}")
    String testString;

    @Override
    public String test() {
        return "Hi";
    }

    @Override
    public void go(String s) {
        System.out.println(s);
    }

    @Override
    public List<TestDto> testList() {
        return List.of(new TestDto("1", 1), new TestDto("2", 2));
    }
}
