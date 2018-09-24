package restpro.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {

	/**
	 * This is an experimental/learning on process controller
	 * about showing customizable page when errors occur.
	 * @return
	 */
	@GetMapping(value="/error/page")
	public String errorStatus() {
		return "StatusPage";
	}
}
