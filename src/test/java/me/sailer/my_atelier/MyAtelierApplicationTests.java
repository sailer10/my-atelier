package me.sailer.my_atelier;

import me.sailer.my_atelier.domain.Category;
import me.sailer.my_atelier.domain.Member;
import me.sailer.my_atelier.repository.CategoryRepository;
import me.sailer.my_atelier.statics.Statics;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import java.util.List;


import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * 범용 테스트 작성 클래스
 * JUnit 테스트 겸 공부용
 * 테스트코드는 given-when-then 을 따름.
 * Given-When-Then 3단계
 * 	1. 테스트 준비
 * 	2. 테스트 진행
 * 	3. 결과 검증
 * spring-boot-starter-test에 테스트를 위한 도구가 모여있음
 * 이중 JUnit 과 AssertJ 를 가장 많이 사용함
 * 
 * # JUnit
 * 자바 언어를 위한 테스트 프레임워크. 단위테스트를 작성하고 테스트 하는데 도움을 줌
 * JUnit 은 각 테스트에 대해 객체를 만들어 독립적으로 시해앻줌.
 * 
 * # AssertJ
 * JUnit 과 함께 검증문의 가독성을 높여주는 라이브러리.
 * AssertJ 를 적용하지 않은 코드는 다음과 같다.
 * Assertions.assertEquals(sum, a+b); // 해당 코드는 가독성이 떨어져 다음과 같이 코드를 사용함.
 * assertThat(a + b).isEqualTo(sum); // 해당 코드가 AssertJ 를 적용한 코드임. 가독성이 높은 장점이 있다.
 * 
 * 	
 */
@SpringBootTest
@AutoConfigureMockMvc	// MockMvc를 생성하고 자동으로 구성해주는 애너테이션
	// MockMvc: 애플리케이션을 서버에 배포하지 않고도 테스트용 Mvc환경을 만들어 요청 및 전송, 응답 기능을
	// 	제공하는 유틸리티 클래스. 즉 컨트롤러를 테스트할 때 사용하는 클래스
class MyAtelierApplicationTests {

	@Autowired
	protected MockMvc mockMvc;
	@Autowired
	private WebApplicationContext context;	// application context 를 상속하고
	// servlet context 에 접근할 수 있는 기능이 추가된 application context 이다.
	@Autowired
	protected CategoryRepository categoryRepository;


	@BeforeEach
	public void mockMvcSetup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@AfterEach
	public void cleanup() {
		categoryRepository.deleteAll();
	}

	@Test
	@DisplayName("카테고리 이름 검색 테스트")
	public void getAllCategories() throws Exception {
		// given
		Category c1 = categoryRepository.save(new Category((byte)1, "목공"));
		// when
		Category c2 = categoryRepository.findById((byte)1).orElseThrow();
		// then
//		Assertions.assertThat(c2.getCategoryName()).isEqualTo(c1.getCategoryName());
	}


	/**
	 * 테스트 예제. 이런 느낌으로 테스트코드 짜면 됨.
	 */
	@DisplayName("getAllMembers: 모든 멤버 조회에 성공한다")
	@Test
	public void getAllMembers() throws Exception {
		// given
		String url = Statics.API_PRODUCTS;

		// when
		final ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get(url).
				accept(MediaType.APPLICATION_JSON));
		// then
		result.andExpect(MockMvcResultMatchers.status().isOk());
//				.andExpect(jsonPath("$[0].id").value())
	}


}
