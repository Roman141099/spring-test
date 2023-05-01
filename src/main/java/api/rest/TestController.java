package api.rest;

import api.dto.TestDto;
import api.hello.MockInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final MockInterface mockInterface;

    @GetMapping("/test")
    public TestDto test() {
        return new TestDto(mockInterface.test(), 123);
    }

    @PostMapping("/test")
    public TestDto testPost(@RequestBody TestDto testDto) {
        return new TestDto(testDto.getTestString(), testDto.getTestInt());
    }

}
