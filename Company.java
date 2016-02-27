package ClientPackage;

import java.util.Collection;

public class Company extends Client{

	public Company(String name, double balance) {
		super(name, balance);
	}
	public void buyPackageCollection(Collection<PackageType> PackagesToBuy) throws Exception{
		for (PackageType packageToBuy : PackagesToBuy) {
			this.buyPackage(packageToBuy);
		}
	}

}
