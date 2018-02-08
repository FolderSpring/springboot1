import com.company.MainController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class SpringbootApplicationTest {

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        this.mockMvc = standaloneSetup(new MainController()).build();
    }

    /**
     * Verify View Name
     *
     * @throws Exception
     */
    @Test
    public void testSayHelloWorld() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(view().name("index.html"));
    }

    /**
     * Verify Response Body (json value)
     */
    @Test
    public void givenGreetURI_whenMockMVC_thenVerifyResponse() throws Exception {
        MvcResult mvcResult = null;
        mvcResult = this.mockMvc.perform(get("/greet"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello World!!!"))
                .andReturn();

        Assert.assertEquals("application/json;charset=UTF-8",
                mvcResult.getResponse().getContentType());
    }

    /**
     * Send GET Request with Path Variable then check json value
     */
    @Test
    public void givenGreetURIWithPathVariable_whenMockMVC_thenResponseOK() throws Exception {
        this.mockMvc.perform(get("/greet/{name}", "John"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.message").value("Hello World John!!!"));
    }

    /**
     * Send GET Request with Query Parameters
     *
     * @throws Exception
     */
    @Test
    public void givenGreetURIWithQueryParameter_whenMockMVC_thenResponseOK() throws Exception {
        this.mockMvc.perform(get("/greetParams")
                .param("name", "John").param("surname", "Doe")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.message").value("Hello World John Doe!!!"));
        // second version
//        this.mockMvc.perform(get("/greetParams?name={name}&surname={surname}", "John", "Doe"))
//                .andDo(print()).andExpect(status().isOk())
//                .andExpect(content().contentType("application/json;charset=UTF-8"))
//                .andExpect(jsonPath("$.message").value("Hello World John Doe!!!"));
    }

    /**
     * Send POST Request
     * @throws Exception
     */
    @Test
    public void givenGreetURIWithPost_whenMockMVC_thenVerifyResponse() throws Exception {
        this.mockMvc.perform(post("/greet")).andDo(print())
                .andExpect(status().isOk()).andExpect(content()
                .contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.message").value("Hello World!!!"));
    }

    @Test
    public void givenGreetURIWithPostAndFormData_whenMockMVC_thenResponseOK() throws Exception {
        this.mockMvc.perform(post("/greetParams")
                .param("name", "John").param("surname", "Doe")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.message").value("Hello World John Doe!!!"))
                .andExpect(jsonPath("$.id").value(1));
    }

}