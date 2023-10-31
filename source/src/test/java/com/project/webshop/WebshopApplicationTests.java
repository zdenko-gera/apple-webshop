package com.project.webshop;

import com.project.webshop.Controllers.UserController;
import com.project.webshop.Models.UserModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebshopApplicationTests {

	@Test
	void testEmailValidation1() {
		String testEmail = "varga@varga.gmail";
		assertTrue(UserModel.emailValidation(testEmail));
	}

	@Test
	void testEmailValidation2() {
		String testEmail = "@varga.gmail";
		assertFalse(UserModel.emailValidation(testEmail));
	}

	@Test
	void testEmailValidation3() {
		String testEmail = "vargavarga.gmail";
		assertFalse(UserModel.emailValidation(testEmail));
	}

	@Test
	void testEmailValidation4() {
		String testEmail = "varga@vargagmail";
		assertFalse(UserModel.emailValidation(testEmail));
	}

	@Test
	void testEmailValidation5() {
		String testEmail = "varga@varga.";
		assertFalse(UserModel.emailValidation(testEmail));
	}

	@Test
	void testEmailValidation6() {
		String testEmail = "varga@.gmail";
		assertFalse(UserModel.emailValidation(testEmail));
	}

	@Test
	void testEmailValidation7() {
		String testEmail = "varga@.varga.gmail";
		assertFalse(UserModel.emailValidation(testEmail));
	}

	@Test
	void testEmailValidation8() {
		String testEmail = "varga@-varga.gmail";
		assertFalse(UserModel.emailValidation(testEmail));
	}

	@Test
	void testEmailValidation9() {
		String testEmail = "varga@_varga.gmail";
		assertFalse(UserModel.emailValidation(testEmail));
	}

	@Test
	void testEmailValidation10() {
		String testEmail = "varga@varga.gmail.";
		assertFalse(UserModel.emailValidation(testEmail));
	}

	@Test
	void testEmailValidation11() {
		String testEmail = "varga@varga.gmail_";
		assertFalse(UserModel.emailValidation(testEmail));
	}


	@Test
	void testEmailValidation12() {
		String testEmail = "varga@varga.gmail-";
		assertFalse(UserModel.emailValidation(testEmail));
	}


	@Test
	void testEmailValidation13() {
		String testEmail = "1varga@varga.gmail-";
		assertFalse(UserModel.emailValidation(testEmail));
	}


	@Test
	void testEmailValidation14() {
		String testEmail = "varga1@varga.gmail";
		assertTrue(UserModel.emailValidation(testEmail));
	}


	@Test
	void testEmailValidation15() {
		String testEmail = "";
		assertFalse(UserModel.emailValidation(testEmail));
	}


	@Test
	void testEmailValidation16() {
		String testEmail = "@.";
		assertFalse(UserModel.emailValidation(testEmail));
	}


	@Test
	void testEmailValidation17() {
		String testEmail = "a@a.a";
		assertTrue(UserModel.emailValidation(testEmail));
	}


	@Test
	void testEmailValidation18() {
		String testEmail = "aaaaaaaaaaaaa@1aaaaaaaaaaaa.aaaaaaaaaaaaaa";
		assertFalse(UserModel.emailValidation(testEmail));
	}

	@Test
	void testEmailValidation19() {
		String testEmail = "aaaaaaaaaaaaa@aaaaaaaaaaaa.1aaaaaaaaaaaaaa";
		assertFalse(UserModel.emailValidation(testEmail));
	}

	@Test
	void testEmailValidation20() {
		String testEmail = ".a@1aaaaaaaaaaaa.aaaaaaaaaaaaaa";
		assertFalse(UserModel.emailValidation(testEmail));
	}




}
