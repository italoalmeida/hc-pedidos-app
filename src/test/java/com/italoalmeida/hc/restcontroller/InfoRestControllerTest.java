package com.italoalmeida.hc.restcontroller;

import static com.italoalmeida.hc.utils.Endpoint.INFO;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InfoRestControllerTest {
	
private MockMvc mvc;
	
	@Autowired
	private WebApplicationContext context;
	
	@Before
	public void setup() {
		mvc = MockMvcBuilders
				.webAppContextSetup(context)
				.build();
	}
	
	@Test
	public void carregarInformacoesComSucesso() throws Exception {
		mvc.perform(get(INFO))
			.andExpect(status().isOk());
	}

}
