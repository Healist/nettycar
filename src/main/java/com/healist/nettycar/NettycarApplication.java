package com.healist.nettycar;

import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(
		exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@ComponentScan(basePackages = {"com.healist"})
@ImportResource(locations = {"classpath:applicationContext.xml"})
@EnableScheduling
public class NettycarApplication {

	public static void main(String[] args) {
		SpringApplication.run(NettycarApplication.class, args);
	}

	@Bean
	public TomcatEmbeddedServletContainerFactory tomcatEmbeddedServletContainerFactory() {
		TomcatEmbeddedServletContainerFactory tomcatFactory =
				new TomcatEmbeddedServletContainerFactory();
		tomcatFactory.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
            // tomcat default nio connector
            Http11NioProtocol handler = (Http11NioProtocol) connector.getProtocolHandler();
            // acceptCount is backlog, default value is 100, you can change
            // which you want value in here
            handler.setBacklog(100);
            handler.setMaxThreads(1000);
            connector.setMaxPostSize(-1);
        });
		return tomcatFactory;
	}

}
