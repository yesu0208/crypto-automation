package arile.toy.crypto_automation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CryptoAutomationApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(CryptoAutomationApplication.class, args);
        SpringApplication.exit(run);
	}

}
