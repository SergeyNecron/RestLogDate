package ru.restlogdate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import ru.restlogdate.model.LogDate;
import ru.restlogdate.model.LogStatus;
import ru.restlogdate.service.LogDateServiceStencil;

import static java.lang.Thread.sleep;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class MainControllerTest {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;
    private MockMvc mockMvc;
    @Autowired
    private LogDateServiceStencil logDateService;


    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void getLogDate() throws Exception {
        mockMvc.perform(get("/task/77777"))
                .andExpect(status().isOk());
    }

    @Test
    public void getLogDateNotExists() throws Exception {
        mockMvc.perform(get("/task/88"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void createLogDate() throws Exception {
        String GUID = mockMvc.perform(post("/task"))
                .andExpect(status().isAccepted()).andReturn().getResponse().getContentAsString();

        int guid = Integer.valueOf(GUID);
        LogDate logDate = logDateService.get(guid);
        assertNotNull("Task was not created", logDate);
        String statusLogDate = logDate.getLogStatus();
        String status = LogStatus.created.toString();
        for (int i = 0; i < 3; i++) {
            if (i == 1) {
                sleep(2000);
                status = LogStatus.running.toString();
            }
            if (i == 2) {
                while (Utilities.isRunTread()) {
                    sleep(1000);
                }
                status = LogStatus.finished.toString();
            }
            if (i > 0)
                statusLogDate = logDateService.get(guid).getLogStatus();
            assertEquals(statusLogDate, status);
        }
    }
}
