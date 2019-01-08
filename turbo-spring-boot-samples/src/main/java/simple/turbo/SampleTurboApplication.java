package simple.turbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import xyz.sluggard.transmatch.core.Engine;

@SpringBootApplication
public class SampleTurboApplication {
	
	public static void main(String... args) {
		ConfigurableApplicationContext cac = SpringApplication.run(SampleTurboApplication.class);
		Engine engine = cac.getBean(Engine.class);
		System.out.println(engine.getCurrencyPair());
	}

}
