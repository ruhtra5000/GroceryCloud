package br.com.grocerycloud.grocerycloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class GrocerycloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrocerycloudApplication.class, args);
	}
	
	@RequestMapping("/")
	public String init(){
		return "APLICAÇÃO RODANDO";
	}
}
