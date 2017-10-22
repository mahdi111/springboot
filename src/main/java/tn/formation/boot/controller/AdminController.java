package tn.formation.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("admin")
public class AdminController {
	
	//@Autowired
	//private UserRepository userRepository;
	/**
	 * show user management ui
	 * return view: users.jsp
	 * @return
	 */
	
	@GetMapping("users")
	public String users() {
		return "users";
		
	}

}
