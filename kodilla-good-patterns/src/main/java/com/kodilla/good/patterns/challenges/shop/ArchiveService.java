package com.kodilla.good.patterns.challenges.shop;

import java.util.HashMap;
import java.util.Map;

public class ArchiveService {
	private static ArchiveService instance;
	private Checkout checkout;
	private Map<Long, Checkout> orderArchive = new HashMap<>();
	
	private ArchiveService() {}
	
	public static ArchiveService getInstance() {
		if(instance == null) {
			synchronized(ArchiveService.class) {
				if(instance == null) {
					instance = new ArchiveService();
				}
			}
		}
		return instance;
	}
	
	private void addingToOrderArchive(Checkout checkout) {
		orderArchive.put(checkout.;
	}
	
	public Map<Long, Checkout> getOrderArchive() {
		return orderArchive;
	}
}