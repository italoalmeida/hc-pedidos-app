package com.italoalmeida.hc.restcontroller;

import static com.italoalmeida.hc.utils.Endpoint.INFO;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author Italo Almeida
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class InfoRestControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void carregarInformacoesComSucesso() throws Exception {
		mvc.perform(get(INFO)).andExpect(status().isOk());
	}

}
