package com.cirta.soft.tracking.api;

import com.cirta.soft.tracking.api.TzaApi;
import com.cirta.soft.tracking.service.ApplicationService;
import com.cirta.soft.tracking.service.ReleaseService;
import com.cirta.soft.tracking.service.TicketService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.verification.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(TzaApi.class)
public class TzaApiUnitTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    ApplicationService applicationService;
    @MockBean
    TicketService ticketService;

    @Test
    public void getAllApplications() throws Exception {
        mockMvc.perform(get("/tza/applications"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json("[]"));
        verify(applicationService, times(1)).listApplications();
    }

    @Test
    public void getAllTickets() throws Exception {
        mockMvc.perform(get("/tza/tickets/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json("[]"));
        verify(ticketService, times(1)).listTickets();
    }
}