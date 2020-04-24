
/**
 * Write a description of class Ruler here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ruler extends Generics
{
    public static final String type = "Ruler";
	public enum KeyType {combo, brand, units, price};
	public static KeyType key = KeyType.combo;
	private String brand;
	private double price;
	private String units;
	Ruler(String brand, double price, String Units)
	{
		this.setType(type);
		this.brand = brand;
		this.price = price;
		this.units = units;
	}
	
	/* 
	 * toString provides output based off of this.key setting
	 */
	@Override
	public String toString() {		
		String output="";
		switch(key) {
		case brand:
			output += this.brand;
			break;
		case price:
			output += this.price;
			break;
		case units:
			output += this.units;
			break;
		case combo:
		default:
			output = type + ": " + this.brand + ", " + this.price + ", " + this.units;
		}
		return output;
	}
	
	public static Generics[] rulerData() {
		Generics[] cc = { 
				new Ruler("Staedler", 3.50, "Inches"),
			    new Ruler("Arteza", 12.99, "Architectural"),
			    new Ruler("Bazic", 5.59, "Inches"),
			    new Ruler("Westcott", 1.62, "Inches"),
			    new Ruler("Fiskars", 0.47, "Inches"),
		};
		return cc;
	}
	
	public static void main(String[] args)
	{
		Generics[] cc = rulerData();
		for(int i = 0; i < cc.length; i++)
			System.out.println(cc[i]);
	}
}
