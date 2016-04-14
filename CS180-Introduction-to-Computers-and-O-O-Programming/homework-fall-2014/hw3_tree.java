/**
* Shadman Jubaer
* This describes the class tree that takes a serial number, circumference,
* and species input to store different kinds of tree data.
* Methods:
* setSerial(serial) 
* setCircumference(circumference)
* setSpecies(species)
* describe() - outputs formatted information about the tree.
*/

public class hw3_tree{
	private int serial;
	private double circumference;
	private String species;

	public hw3_tree(int serial,double circumference,String species){
		setSpecies(species);
		setSerial(serial);
		setCircumference(circumference);
	}

	public void setSerial(int serial){this.serial = serial;}

	public void setCircumference(double circumference){this.circumference = circumference;}

	public void setSpecies(String species){this.species = species;}

	public void describe(){
		String output = String.format(
			"Tree number %d has a circumference of %.2f and is of species %s.",
			 serial, circumference, species);
		System.out.println(output);

	}
}