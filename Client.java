package ClientPackage;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Client {
	private double moneySpend;
	private	String name;
	private double balance;
	private Collection<PackageType> packagesAdquiered = new ArrayList<PackageType>();
	private PackageType mostExpensivePackage = null;
	
	//Constructor
	public Client(String name, double balance){
		this.name = name;
		this.balance = balance;
		this.moneySpend = 0;
	}
	
	public void setBalance(double balance){
		this.balance = balance;
	}
	
	public String getName(){
		return name;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public void buyPackage(PackageType PackageToBuy){
		double amount = PackageToBuy.PackagePrice(this);
		try{
			if(balance > amount){
				System.out.println("Balance: "+balance);
				balance = balance - amount;
				System.out.println("Package Amount: "+amount);
				System.out.println("New Balance: "+balance);
				packagesAdquiered.add(PackageToBuy);
				this.moneySpend = this.moneySpend + amount;
				this.verifyExpensive(PackageToBuy);
			}
			else
			{
				throw new NotHaveSufficientFundsException();
			}
		}
		catch(NotHaveSufficientFundsException e){
			System.out.println("Excepcion: " + e);
		}
		finally{
			System.out.println("Balance: "+ amount);
		}
		
	}
	public void verifyExpensive(PackageType paquetito){
		if( !(this.mostExpensivePackage == null) ){
			if(paquetito.PackagePrice(this) > this.mostExpensivePackage.PackagePrice(this))
			{
				this.mostExpensivePackage = paquetito;
			}
		}
		else
		{
			this.mostExpensivePackage = paquetito;
		}
	}
	public double getMoneySpend(){
		return this.moneySpend;
	}
	public int getPackagesAdquiered(){
		return packagesAdquiered.size();
	}
	public PackageType getMostExpensivePackage(){
		return this.mostExpensivePackage;
	}
//	public double getBuyHistory(Client cliente){
//		double moneyWasted = 0;
//		for (PackageType packageType : packagesAdquiered) {
//			moneyWasted = moneyWasted + packageType.();
//		}
//		return moneyWasted;
//	}
}
