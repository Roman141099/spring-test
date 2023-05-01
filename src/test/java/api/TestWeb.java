package api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class TestWeb {

    @Autowired
    MockMvc MVC;

    @Test
    public void test1() throws Exception {
        MVC.perform(
                        MockMvcRequestBuilders
                                .get("/test"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(
                        MockMvcResultMatchers
                                .status()
                                .isOk()
                ).andExpect(MockMvcResultMatchers
                        .content()
                        .json("{\"testString\": \"Hi\", \"testInt\":123}"));
    }

    @Test
    public void test2() throws Exception {
        MVC.perform(
                        MockMvcRequestBuilders
                                .post("/test")
                                .content("{\"testString\": \"Hi123\", \"testInt\":12345}")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(
                        MockMvcResultMatchers
                                .status()
                                .isOk()
                ).andExpect(MockMvcResultMatchers
                        .content()
                        .json("{\"testString\": \"Hi123\", \"testInt\":12345}"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.testInt").value("12345"))
                .andExpect(MockMvcResultMatchers.header().string("content-type", MediaType.APPLICATION_JSON_VALUE));
    }

}
