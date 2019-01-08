package xyz.sluggard.boot.turbo.autoconfigure;

import static xyz.sluggard.boot.turbo.utils.TurboUtils.TURBO_PREFIX;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(TURBO_PREFIX)
public class TurboProperties {
	
	private String currencyPair;
	
	public String getCurrencyPair() {
		return currencyPair;
	}

	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}

}
