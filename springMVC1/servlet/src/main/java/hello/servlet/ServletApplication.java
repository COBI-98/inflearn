package hello.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan // 패키지 서블릿 자동등록
@SpringBootApplication
public class ServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletApplication.class, args);
	}

	/* prefix , suffix spring boot가 자동으로 해줌
	@Bean
	InternalResourceViewResolver internalResourceView(){
		return new InternalResourceViewResolver("/WEP-INF/views",".jsp");
	}
	*/

}
