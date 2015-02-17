package com.yang.cicada.web.country;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yang.cicada.domain.country.Country;

@RestController
@RequestMapping({"/country"})
public class CountryController {
	@RequestMapping("/list")
	public List<Country> greeting() {
		List<Country> countries = new LinkedList<Country>();
		
		// ISO Alpha-3 Code: http://www.nationsonline.org/oneworld/country_code_list.htm
		
		Country country = new Country("NZL", "New Zealand", "image/country/NewZealand.3.jpg", "Description of New Zealand", true, false);
		countries.add(country);

		country = new Country("AUS", "Australia", "image/country/Australia.3.jpg", "Description of Australia", true, false);
		countries.add(country);

		country = new Country("CHN", "China", "image/country/China.3.jpg", "Description of China", true, false);
		countries.add(country);

		country = new Country("THA", "Thailand", "image/country/Thailand.3.jpg", "Description of Thailand", true, false);
		countries.add(country);
		
		country = new Country("USA", "United States of America", "image/country/USA.3.jpg", "Description of United States of America", true, false);
		countries.add(country);

		return countries;
	}
	
	@RequestMapping("/update")
	public boolean update(@RequestBody Country country) {
		System.out.println("country=" + country);
		return false;
		//this.countryService.update(country);
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String  login2(@RequestHeader ("host") String hostName,
							@RequestHeader ("Content-Type") String contentType,
							@RequestHeader ("Accept") String acceptType,
				            @RequestHeader ("Accept-Language") String acceptLang,
				            @RequestHeader ("Accept-Encoding") String acceptEnc,
//				            @RequestHeader ("Cookie") String cookie,
				            @RequestHeader ("User-Agent") String userAgent)
				    {
						System.out.println("Host : " + hostName);
				        System.out.println("Content-Type: " + contentType);
				        System.out.println("Accept : " + acceptType);
				        System.out.println("Accept Language : " + acceptLang);
				        System.out.println("Accept Encoding : " + acceptEnc);
//				        System.out.println("Cookie : " + cookie);
				        System.out.println("User-Agent : " + userAgent);
				        return "{\"message\":\"example JSON result\"}";
				    }
			
	@RequestMapping("/login3")
	public List<CicadaResponse> login3(@RequestHeader ("host") String hostName,
			@RequestParam("username") String userName, @RequestParam("password") String password) {
		System.out.println("hostName=" + hostName);
		System.out.println("userName=" + userName);
		System.out.println("password=" + password);
		List<CicadaResponse> list = new ArrayList<CicadaResponse>();
		list.add(new CicadaResponse(userName, password));
		
		// The POJO must have getters and setters
		// http://stackoverflow.com/questions/7197268/spring-mvc-httpmediatypenotacceptableexception
		// The list is automatically converted to JSON. The class must provide getters and setters.
		return list;
	}
	
	@RequestMapping("/login4")
	public CicadaResponse login4(@RequestHeader ("host") String hostName,
			@RequestParam("username") String userName, @RequestParam("password") String password) {
		System.out.println("hostName=" + hostName);
		System.out.println("userName=" + userName);
		System.out.println("password=" + password);
		
		return new CicadaResponse(userName, password);
	}
	
	@RequestMapping(value="/login5", produces="application/json")
	public String login5(@RequestHeader ("host") String hostName,
			@RequestParam("username") String userName, @RequestParam("password") String password) {
		System.out.println("hostName=" + hostName);
		System.out.println("userName=" + userName);
		System.out.println("password=" + password);
		
		// NOTE, as we are using jackson to do JSON,
		// the literals are NOT converted to JSON. Only customized class are converted to JSON format.
		// unless we use produces
		// use @RequestBody to map incoming JSON to object and, @ResponseBody to return without conversion
		
		// The client expects json. This returns literal string, which doesn't match json and causes failure
		return userName + password;		
	}
}

class CicadaResponse {
	private String userName;
	private String password;
	public CicadaResponse(String userName, String password) {
	    super();
	    this.userName = userName;
	    this.password = password;
    }
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}