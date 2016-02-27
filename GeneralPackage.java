package ClientPackage;

public class GeneralPackage implements PackageType{

	private PackageType packType;
	
	public double bookPrice(){
		return 12;
	}
	
	public GeneralPackage(PackageType packType){
		this.packType = packType;
	}
	
	public double PackagePrice(Client cliente){
		return packType.PackagePrice(cliente);
	}
	public void SetPackageType(PackageType packType){
		this.packType = packType;
	}
	public PackageType GetPackageType(){
		return packType;
	}
	public double getFinalPrice(){
		return this.getFinalPrice();
	}
	
}
