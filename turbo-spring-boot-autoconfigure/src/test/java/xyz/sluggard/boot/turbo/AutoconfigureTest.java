package xyz.sluggard.boot.turbo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.Bean;

import xyz.sluggard.boot.turbo.autoconfigure.TurboAutoConfiguration;
import xyz.sluggard.transmatch.core.Engine;
import xyz.sluggard.transmatch.engine.ExecutorEngine;
import xyz.sluggard.transmatch.service.impl.EventServiceImpl;
import xyz.sluggard.transmatch.service.impl.NoneInitServiceImpl;

public class AutoconfigureTest {
	
	private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
			.withConfiguration(AutoConfigurations.of(TurboAutoConfiguration.class));
	@Test
	public void defaultServiceBacksOff() {
		this.contextRunner.withPropertyValues("turbo.engin.currencyPair=ETH_BTC")
				.run((context) -> {
					System.out.println(context.getBean(Engine.class).getCurrencyPair());
					assertThat(context).hasSingleBean(Engine.class);
					assertThat(context.getBean(Engine.class).getCurrencyPair()).isEqualTo("ETH_BTC");
				});
	}

	static class UserConfiguration {

		@Bean
		public Engine myUserService() {
			return new ExecutorEngine("ETH_BTC", new EventServiceImpl(), new NoneInitServiceImpl());
		}

	}
}
