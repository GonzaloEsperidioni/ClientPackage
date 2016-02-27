package ClientPackage;

public class PackageRoomPrice implements PackageType{
	
	private int roomAmount;
	private double roomPrice;
	private double finalPrice;
	private double tax;
	
	public PackageRoomPrice(int roomAmount, double roomPrice, double tax){
		this.roomAmount = roomAmount;
		this.roomPrice = roomPrice;
		this.tax = tax;
	}
	
	public double PackagePrice(Client cliente){
		double pricePerRoom = roomAmount * roomPrice; 
		this.finalPrice = pricePerRoom * ( (tax/100) + 1);
		return finalPrice;
	}

	public double FinalPrice() {
		return this.finalPrice;
	}
}