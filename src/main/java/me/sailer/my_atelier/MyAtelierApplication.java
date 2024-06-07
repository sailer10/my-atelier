package me.sailer.my_atelier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // 해당 어노테이션을 적용함으로써 createdDate, updatedDate 같이 DB에 데이터가 저장되거나 수정될 때 언제, 누가 했는지 자동으로 관리 가능
@SpringBootApplication
public class MyAtelierApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAtelierApplication.class, args);
	}

}
