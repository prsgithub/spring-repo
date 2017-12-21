package com.sdrc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
public class TilesConfiguration {
	
	@Bean
	public TilesConfigurer tilesConfigurer() {
		final TilesConfigurer tilesConfigurer = new TilesConfigurer();

		String[] defs = { "WEB-INF/tiles.xml" };

		tilesConfigurer.setDefinitions(defs);
		tilesConfigurer.setCheckRefresh(true);
		return tilesConfigurer;
	}

	@Bean
	public UrlBasedViewResolver tilesViewResolver() {
		final TilesViewResolver resolver = new TilesViewResolver();
        resolver.setViewClass(TilesView.class);
        return resolver;
	}

}
