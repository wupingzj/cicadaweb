package com.yang.cicada.web.country;

import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yang.cicada.domain.country.Country;

@RestController
@RequestMapping({"/country"})
public class CountryController {
	@RequestMapping("/list")
	public List<Country> greeting() {
		List<Country> countries = new LinkedList<Country>();
		
		Country country = new Country("NZ", "New Zealand", "image/country/NewZealand.3.jpg", "Description of New Zealand", true, false);
		countries.add(country);

		country = new Country("AU", "Australia", "image/country/Australia.3.jpg", "Description of Australia", true, false);
		countries.add(country);

		country = new Country("CHN", "China", "image/country/China.3.jpg", "Description of China", true, false);
		countries.add(country);

		country = new Country("THL", "Thailand", "image/country/Thailand.3.jpg", "Description of Thailand", true, false);
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
}
