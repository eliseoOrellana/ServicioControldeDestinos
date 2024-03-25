package cl.infoclub.controlDestinos.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("cl.infoclub.controlDestinos") 
@PropertySource("classpath:database.properties") //permite decir que esta clase trabajara con propiedades de configuracion 
public class AppConfig {
	
	@Autowired
	Environment environment;// inyectando ambiente al fichero de coneccion
	
	@Bean
	DataSource dataSource() {//todo lo que se conecte a base datos es datasourse sql
		
		DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
		
		driverManagerDataSource.setUrl(environment.getProperty("url"));
		driverManagerDataSource.setDriverClassName(environment.getProperty("driver"));
		driverManagerDataSource.setUsername(environment.getProperty("dbuser"));
		driverManagerDataSource.setPassword(environment.getProperty("dbpassword"));
		
		return driverManagerDataSource;
		
	}
	

}
