package xyz.sluggard.boot.turbo.autoconfigure;

import static xyz.sluggard.boot.turbo.utils.TurboUtils.TURBO_PREFIX;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import xyz.sluggard.transmatch.core.Engine;
import xyz.sluggard.transmatch.engine.ExecutorEngine;
import xyz.sluggard.transmatch.service.EventService;
import xyz.sluggard.transmatch.service.InitService;
import xyz.sluggard.transmatch.service.impl.EventServiceImpl;
import xyz.sluggard.transmatch.service.impl.NoneInitServiceImpl;

@Configuration
@ConditionalOnProperty(prefix = TURBO_PREFIX, name = "enabled", matchIfMissing = true, havingValue = "true")
@EnableConfigurationProperties(TurboProperties.class)
public class TurboAutoConfiguration{

	private TurboProperties properties;
	
	public TurboAutoConfiguration(TurboProperties properties) {
		super();
		this.properties = properties;
	}

	@Bean
	@ConditionalOnMissingBean
	public Engine engine() {
		Engine engine = new ExecutorEngine(properties.getCurrencyPair(), eventService(), initService());
		return engine;
	}

	@Bean
	@ConditionalOnMissingBean
	public EventService eventService() {
		return new EventServiceImpl();
	}

	@Bean
	@ConditionalOnMissingBean
	public InitService initService() {
		return new NoneInitServiceImpl();
	}

}
