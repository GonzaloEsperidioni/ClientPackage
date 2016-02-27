package ClientPackage;

public class PackageBasePercent implements PackageType{

	private double finalPrice;
	private double tax;
	
	public PackageBasePercent(double tax){
		this.tax = tax;
	}

	public double PackagePrice(Client cliente) {
	
		this.finalPrice = cliente.getBalance() / 10;
		this.finalPrice = this.finalPrice * ( (tax/100) + 1 ) ;
		return this.finalPrice;
	}
	
}
