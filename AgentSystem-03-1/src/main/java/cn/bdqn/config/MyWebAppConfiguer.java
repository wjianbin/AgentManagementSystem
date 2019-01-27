package cn.bdqn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import cn.bdqn.Interceptor.MyInterceptor;


//@Configuration
@SpringBootConfiguration
public class MyWebAppConfiguer implements WebMvcConfigurer {

	@Autowired
	private MyInterceptor myInterceptor;
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
		String[] excludes = new String[] {"/inc/**","/css/**","/js/**","/imgs/**"};
        registry.addInterceptor(myInterceptor).addPathPatterns("/**").excludePathPatterns(excludes);
    }
}
