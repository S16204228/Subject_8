package W16204228.p01;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@Value("${welcome.message}")
	private String message;
	
	private List<String> tasks=Arrays.asList("Git","Maven","Spring");
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("message", message);
		model.addAttribute("tasks", tasks);
		return "welcome";
	}
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}

/*
welcome.message:adva


*/