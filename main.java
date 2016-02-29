package ClientPackage;

import java.util.ArrayList;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class main {

	public static void main(String[] args) throws Exception{
		

//		PackageRoomPrice packRoom = new PackageRoomPrice(100, 5);
//		PackageBase base = new PackageBase(500);
		PackageRoomPrice perRoom = new PackageRoomPrice(2, 50, 20);
		PackageBase base = new PackageBase(500, 25);
		PackageBasePercent percentPack = new PackageBasePercent(30);
		GeneralPackage villaIbiza = new GeneralPackage(base);
		GeneralPackage amsterdam = new GeneralPackage(percentPack);
		GeneralPackage marDel = new GeneralPackage(perRoom);
		Company user1 = new Company("Gonzalo" , 2000);
		Individue usuario2 = new Individue("Tito", 5000);
		Collection<PackageType> packagesToBuy = new ArrayList<PackageType>();
		packagesToBuy.add(marDel);
		packagesToBuy.add(villaIbiza);
		packagesToBuy.add(amsterdam);
		
		System.out.println(user1.getName());
		user1.buyPackage(marDel);
		marDel.SetPackageType(base);
		user1.buyPackage(marDel);
		user1.buyPackageCollection(packagesToBuy);
		user1.buyPackage(marDel);
//		user1.setBalance(2000);
//		marDel.SetPackageType(percentPack);
//		user1.buyPackage(marDel);
//		
		//user1.getPackasAdquiered();
		
	


	}

}
