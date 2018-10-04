package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
	@Test
	public void testDefaultSharingStrategies() {
		//Given
		User tekla = new Millenials("Tekla Bright");
		User michael = new YGeneration("Michael Mutler");
		User trust = new ZGeneration("Trust Frost");
		
		//When
		String teklaWillPublish = tekla.sharePost();
		System.out.println("Tekla will publish using: " + teklaWillPublish);
		String michaelWillPublish = michael.sharePost();
		System.out.println("Michael will publish using: " + michaelWillPublish);
		String trustWillPublish = trust.sharePost();
		System.out.println("Trust will publish using: " + trustWillPublish);
		
		//Then
		Assert.assertEquals("Facebook", teklaWillPublish);
		Assert.assertEquals("Twitter", michaelWillPublish);
		Assert.assertEquals("Snapchat", trustWillPublish);
	}
	
	@Test
	public void testIndividualSharingStrategy() {
		//Given
		User tekla = new Millenials("Tekla Bright");
		
		//When
		String teklaWillPublish = tekla.sharePost();
		System.out.println("Tekla will publish using: " + teklaWillPublish);
		tekla.setSocialPublisher(new SnapchatPublisher());
		teklaWillPublish = tekla.sharePost();
		System.out.println("Tekla now will publish by: " + teklaWillPublish);
		
		//Then
		Assert.assertEquals("Snapchat", teklaWillPublish);
	}
}