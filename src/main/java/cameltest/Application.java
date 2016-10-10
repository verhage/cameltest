package cameltest;

import org.apache.camel.component.spring.ws.bean.CamelEndpointMapping;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

/**
 * @author verhage
 * @since 10/10/16 16:53
 */
@EnableWs
@SpringBootApplication
public class Application
{
	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext)
	{
		MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
		messageDispatcherServlet.setApplicationContext(applicationContext);
		messageDispatcherServlet.setTransformWsdlLocations(true);

		return new ServletRegistrationBean(messageDispatcherServlet, "/soap/*");
	}

	@Bean
	public CamelEndpointMapping endpointMapping()
	{
		return new CamelEndpointMapping();
	}
}
