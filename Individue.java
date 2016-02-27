package ClientPackage;

import java.util.ArrayList;
import java.util.Collection;

public class Individue extends Client{

	Collection<PackageType> bookingsPackages = new ArrayList<PackageType>();
	
	public Individue(String name, double balance) {
		super(name, balance);
	}
	public void bookPackage(PackageType packageToBook){
		
		this.setBalance(this.getBalance() - this.bookPrice(packageToBook));
		bookingsPackages.add(packageToBook);
		
	}
	public Collection<PackageType> getBookings(){
		return this.bookingsPackages;
	}
	public double bookPrice(PackageType packageToBook){
		return packageToBook.PackagePrice(this) / 2;
	}
	public void payBookingPackage(PackageType packageToPay){
		this.setBalance( this.getBalance() - this.bookPrice(packageToPay) );
		bookingsPackages.remove(packageToPay);
		}

}
