package ClientPackage;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class Client {
	
	final static Logger LOGGER = LoggerFactory.getLogger(Client.class);
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
				LOGGER.info("El usuario: {}", this.getName());
				LOGGER.info("Tiene : {}", balance); 
				balance = balance - amount;
				LOGGER.info("Compra paquete {} por {}", PackageToBuy.getClass().getName() ,amount); 
				LOGGER.info("Nuevo Balance: {}", balance); 
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
			LOGGER.error("No tenes platita!", e);
		}
		finally{
			LOGGER.info("Balance: {} y queres gastar : {}", balance, amount );
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
}
