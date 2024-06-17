package me.sailer.my_atelier;

import me.sailer.my_atelier.domain.Member;
import me.sailer.my_atelier.domain.Product;
import me.sailer.my_atelier.repository.MemberAddressRepository;
import me.sailer.my_atelier.repository.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
public class MemberTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    WebApplicationContext context;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberAddressRepository addressRepository;

    @BeforeEach
    public void setMockMvc() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @AfterEach
    public void clecnUp() {
        memberRepository.deleteAll();
        addressRepository.deleteAll();
    }

    @Test
    @DisplayName("배송지 조회")
    public void getAllAddress() {

    }

}
