package jpabook.jpashop;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpashopApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpashopApplication.class, args);
	}

	@Bean // 엔티티를 노출하지않으면 상관없음 Dto JsonIgnore // 강제 지연로딩 설정
	Hibernate5Module hibernate5Module() {
		return new Hibernate5Module();
	}
}
