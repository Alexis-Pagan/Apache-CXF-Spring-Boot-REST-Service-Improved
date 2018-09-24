package restpro.main;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import restpro.impls.ProgrammingEndpoint;

@SpringBootApplication(scanBasePackages = {"restpro.mvc.controllers"})
@ImportResource({"classpath:META-INF/cxf/cxf.xml"})
public class RESTMain {

	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus bus() {
		return new SpringBus();
	}
	
	public static void main(String[] args) throws Exception {
		System.setProperty("spring.config.name", "master-java");
		SpringApplication.run(RESTMain.class, args);
	}
	
	@Bean
	public Server jaxrserver() {
		JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
		endpoint.setBus(bus());
		endpoint.setServiceBean(new ProgrammingEndpoint());
		endpoint.setProvider(JSONprovider());
		return endpoint.create();
	}

	@Bean
	public JacksonJsonProvider JSONprovider() {
		return new JacksonJsonProvider();
	}	
}
