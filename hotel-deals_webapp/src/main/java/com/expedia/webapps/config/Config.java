package com.expedia.webapps.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.expedia.util.Utilities;

@RestController
public class Config {
	private static Logger log = Logger.getLogger(Config.class);
	public static Properties props;
	
	public void init() {
		System.out.println("****************LandingPage-init*******************");
		PropertyConfigurator.configure(this.getClass().getClassLoader().getResource("log.properties"));

		log = Logger.getLogger(Config.class);

		log.debug("*****************************************");

		refreshConfig();
	}
	
	@RequestMapping(value = "/refreshConfig", method = RequestMethod.GET, headers = "Accept=application/xml")
	public void refreshConfig(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("inside init method of ConfigServlet..................");

		refreshConfig();
	}
	
	public void refreshConfig() {
		log.debug("Config Refresh was requested");
		loadCities();
	}
	
	public void destroy() {
		log.debug("shutdown Hotel Deals --------------------");
		System.out.println("shutdown Hotel Deals --------------------");
	}
	
	public void loadCities() {
		String path = this.getClass().getClassLoader().getResource("cities.csv").getPath();
		System.out.println("path: " + path);
		
		try (Stream<String> stream = Files.lines(Paths.get(path))) {
			Utilities.cities = new ArrayList<>();
			stream.forEach(Utilities.cities::add);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		(new Config()).loadCities();
	}
}