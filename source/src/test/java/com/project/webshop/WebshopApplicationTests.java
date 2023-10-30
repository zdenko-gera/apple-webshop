package com.project.webshop;

import com.project.webshop.Controllers.UserController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.testng.Assert.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebshopApplicationTests {

	static UserController uc;
	@BeforeAll
	static void setup() {
		uc = new UserController();
	}
	@Test
	void testEmailValidation1() {
		String testEmail = "varga@varga.gmail";
		assertTrue(uc.emailValidation(testEmail));
	}

	@Test
	void testEmailValidation2() {
		String testEmail = "@varga.gmail";
		assertFalse(uc.emailValidation(testEmail));
	}

	@Test
	void testEmailValidation3() {
		String testEmail = "vargavarga.gmail";
		assertFalse(uc.emailValidation(testEmail));
	}

	@Test
	void testEmailValidation4() {
		String testEmail = "varga@vargagmail";
		assertFalse(uc.emailValidation(testEmail));
	}

	@Test
	void testEmailValidation5() {
		String testEmail = "varga@varga.";
		assertFalse(uc.emailValidation(testEmail));
	}

	@Test
	void testEmailValidation6() {
		String testEmail = "varga@.gmail";
		assertFalse(uc.emailValidation(testEmail));
	}

	@Test
	void testEmailValidation7() {
		String testEmail = "varga@.varga.gmail";
		assertFalse(uc.emailValidation(testEmail));
	}

	@Test
	void testEmailValidation8() {
		String testEmail = "varga@-varga.gmail";
		assertFalse(uc.emailValidation(testEmail));
	}

	@Test
	void testEmailValidation9() {
		String testEmail = "varga@_varga.gmail";
		assertFalse(uc.emailValidation(testEmail));
	}

	@Test
	void testEmailValidation10() {
		String testEmail = "varga@varga.gmail.";
		assertFalse(uc.emailValidation(testEmail));
	}

	@Test
	void testEmailValidation11() {
		String testEmail = "varga@varga.gmail_";
		assertFalse(uc.emailValidation(testEmail));
	}


	@Test
	void testEmailValidation12() {
		String testEmail = "varga@varga.gmail-";
		assertFalse(uc.emailValidation(testEmail));
	}


	@Test
	void testEmailValidation13() {
		String testEmail = "1varga@varga.gmail-";
		assertFalse(uc.emailValidation(testEmail));
	}


	@Test
	void testEmailValidation14() {
		String testEmail = "varga1@varga.gmail";
		assertTrue(uc.emailValidation(testEmail));
	}


	@Test
	void testEmailValidation15() {
		String testEmail = "";
		assertFalse(uc.emailValidation(testEmail));
	}


	@Test
	void testEmailValidation16() {
		String testEmail = "@.";
		assertFalse(uc.emailValidation(testEmail));
	}


	@Test
	void testEmailValidation17() {
		String testEmail = "a@a.a";
		assertTrue(uc.emailValidation(testEmail));
	}


	@Test
	void testEmailValidation18() {
		String testEmail = "aaaaaaaaaaaaa@1aaaaaaaaaaaa.aaaaaaaaaaaaaa";
		assertFalse(uc.emailValidation(testEmail));
	}

	@Test
	void testEmailValidation19() {
		String testEmail = "aaaaaaaaaaaaa@aaaaaaaaaaaa.1aaaaaaaaaaaaaa";
		assertFalse(uc.emailValidation(testEmail));
	}

	@Test
	void testEmailValidation20() {
		String testEmail = ".a@1aaaaaaaaaaaa.aaaaaaaaaaaaaa";
		assertFalse(uc.emailValidation(testEmail));
	}




}
