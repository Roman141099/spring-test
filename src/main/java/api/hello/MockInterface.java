package api.hello;

import api.dto.TestDto;

import java.util.List;

public interface MockInterface {

    String test();

    void go(String s);

    List<TestDto> testList();

}
