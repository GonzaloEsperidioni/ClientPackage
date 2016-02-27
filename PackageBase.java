package ClientPackage;

public class PackageBase implements PackageType{
	
	private double basePrice;
	private double finalPrice;
	private double tax;
	
	public PackageBase(double basePrice, double tax){
		this.basePrice = basePrice;
		this.tax = tax;
	}
	
	public void setPackageBase(double basePrice){
		this.basePrice = basePrice;
	}
	
	public double PackagePrice(Client cliente){
		this.finalPrice = ( basePrice * ( (tax/100) + 1 ));
		return this.finalPrice;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
}
