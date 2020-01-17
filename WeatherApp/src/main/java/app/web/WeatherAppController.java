package app.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ebixWeatherApp")
public class WeatherAppController {
    
	@GetMapping("/{city}")
	public String getWeather(@PathVariable("city") String city, Model model) {
		System.out.println(city);
		model.addAttribute("message", "Hello Shiv you entered city name"+city);
		return "view";
	}
}
