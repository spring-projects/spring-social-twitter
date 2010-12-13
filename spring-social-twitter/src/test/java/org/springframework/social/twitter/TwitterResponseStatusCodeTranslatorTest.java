/*
 * Copyright 2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.twitter;

import static org.junit.Assert.*;
import static org.springframework.social.twitter.TwitterResponseStatusCodeTranslator.*;

import java.util.Collections;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.social.core.AccountNotConnectedException;
import org.springframework.social.core.OperationNotPermittedException;
import org.springframework.social.core.SocialException;

/**
 * @author Craig Walls
 */
@SuppressWarnings("rawtypes")
public class TwitterResponseStatusCodeTranslatorTest {
	private TwitterResponseStatusCodeTranslator translator = new TwitterResponseStatusCodeTranslator();

	@Before
	public void setup() {
		new TwitterResponseStatusCodeTranslator();
	}

	@Test
	public void translate_forbiddenNonDuplicate() {
		ResponseEntity<Map> responseEntity = new ResponseEntity<Map>(Collections.singletonMap("error",
				"Some forbidden message"), HttpStatus.FORBIDDEN);
		SocialException socialException = translator.translate(responseEntity);
		assertTrue(socialException instanceof OperationNotPermittedException);
		assertEquals("Some forbidden message", socialException.getMessage());
	}

	@Test
	public void translate_duplicateTweet() {
		ResponseEntity<Map> responseEntity = new ResponseEntity<Map>(Collections.singletonMap("error",
				DUPLICATE_STATUS_TEXT), HttpStatus.FORBIDDEN);
		SocialException socialException = translator.translate(responseEntity);
		assertTrue(socialException instanceof DuplicateTweetException);
		assertEquals(DUPLICATE_STATUS_TEXT, socialException.getMessage());
	}

	@Test
	public void translate_unauthorized() {
		ResponseEntity<Map> responseEntity = new ResponseEntity<Map>(
				Collections.singletonMap("error", "That's a no-no"), HttpStatus.UNAUTHORIZED);
		SocialException socialException = translator.translate(responseEntity);
		assertTrue(socialException instanceof AccountNotConnectedException);
		assertEquals("That's a no-no", socialException.getMessage());
	}
}
