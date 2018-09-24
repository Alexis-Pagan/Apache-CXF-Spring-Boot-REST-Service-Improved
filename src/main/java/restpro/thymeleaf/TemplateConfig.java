package restpro.thymeleaf;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
@EnableWebMvc
public class TemplateConfig implements ApplicationContextAware {

	@Autowired
	public ApplicationContext applicationContext;

	private static final String UTF8 = "UTF-8";
	
	@Bean
	public ITemplateResolver templateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setPrefix("/src/main/resources/templates/"); 
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML5"); 
		templateResolver.setCacheable(false);
		templateResolver.setCacheTTLMs(0L);
		templateResolver.setNonCacheablePatterns(null);
		return templateResolver;
	}

	@Bean
	// execute templates
	/*@Description("Subclasss than uses TemplateEngine to execution of templates.")*/
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine template = new SpringTemplateEngine();
		template.setTemplateResolver(templateResolver());		
		template.setEnableSpringELCompiler(true);
		return template;
	}

	@Bean
	// process the HTML view
	/*@Description("Implementation of the Spring MVC ViewResolvser: View resolvers execute after the controller ends its execution."
			+ "They receive the name of the view to be processed and are in charge of creating (and configuring) the corresponding View object for it.The View implementations managed by this class are subclasses of Abs")*/
	public ThymeleafViewResolver viewResolver() {
		ThymeleafViewResolver view = new ThymeleafViewResolver();
		view.setCharacterEncoding(UTF8); 
		view.setTemplateEngine(templateEngine());
		view.setOrder(1);
		return view;
	}

	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void setApplicationContext(ApplicationContext appCon) throws BeansException {
		applicationContext = appCon;
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
}
	
	/**
	 * not yet 08/7/2018 
	 * this is for validation handling
	 */
	/*@Bean 
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages_errors");
		return messageSource;
	}*/
