package com.kodilla.good.patterns.challenges.shop;

public class ProductOrderService {
	
	private ProductSearchingService productSearchingService;
	private ShopCart shopCart;
	private ProductSendingService productSendingService;
	private Checkout checkout;
	private ArchiveService archiveService;
	
	public ProductOrderService(ProductSearchingService productSearchingService, ShopCart shopCart,
	                           ProductSendingService productSendingService, Checkout checkout,
	                           ArchiveService archiveService) {
		this.productSearchingService = productSearchingService;
		this.shopCart = shopCart;
		this.productSendingService = productSendingService;
		this.checkout = checkout;
		this.archiveService = archiveService;
	}
	
	public shoping(new User() {
	
	}
	
	process(User user1, User user2) {
	
	}
	
	() {
	
	}
	
	
	
	
	private RentalService rentalService;
	private RentalRepository rentalRepository;
	
	public RentalProcessor(final InformationService informationService,
	                       final RentalService rentalService,
	                       final RentalRepository rentalRepository) {
		this.informationService = informationService;
		this.rentalService = rentalService;
		this.rentalRepository = rentalRepository;
	}
	
	public RentalDto process(final RentRequest rentRequest) {
		boolean isRented = rentalService.rent(rentRequest.getUser(), rentRequest.getFrom(),
				rentRequest.getTo());
		
		if(isRented) {
			informationService.inform(rentRequest.getUser());
			rentalRepository.createRental(rentRequest.getUser(), rentRequest.getFrom(), rentRequest.getTo());
			return new RentalDto(rentRequest.getUser(), true);
			
		} else {
			return new RentalDto(rentRequest.getUser(), false);
		}
	}
}