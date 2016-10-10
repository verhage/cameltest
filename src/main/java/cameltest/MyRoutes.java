package cameltest;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author verhage
 * @since 10/10/16 17:06
 */
@Component
public class MyRoutes extends RouteBuilder
{
	@Override
	public void configure() throws Exception
	{
		from("spring-ws:soapaction:http://example.com/myservice")
		 .to("log:cameltest?level=DEBUG");
	}
}
