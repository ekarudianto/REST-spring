package com.ekarudianto.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LocaleTest {
	
	private Locale locale = new Locale();
	
	@Test
    public void testUsersNotFound() {
		String usersNotFound = "Users not found !";
        locale.setUsersNotFound(usersNotFound);
        assertEquals(locale.getUsersNotFound(), usersNotFound);
    }
	
	@Test
	public void testMustNotProvideId() {
		String mustNotProvideId = "Must not provide id !";
		locale.setMustNotProvideId(mustNotProvideId);
		assertEquals(locale.getMustNotProvideId(), mustNotProvideId);
	}

}
