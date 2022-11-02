/*package com.trabajoFinal.app.Controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabajoFinal.app.Model.Login;

package com.trabajoFinal.app.Controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.trabajoFinal.app.Model.Login;


@RestController
@RequestMapping("/login")
@CrossOrigin(origins="http://localhost:4200")

public class LoginController {

	@Autowired
	 private ILoginService iloginService;
}


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class LoginController{

	@GetMapping("/")
	public String login() {
		return "authenticated succesfully";
	}

	@GetMapping("/getUser")
	public List<Login> getUser(){
		return Stream.of(new Login("mmiguel","ready")).collect(Collectors.toList());
	}

}*/
