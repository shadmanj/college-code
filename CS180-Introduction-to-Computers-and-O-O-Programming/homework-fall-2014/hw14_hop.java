/**
* Shadman Jubaer
* This class chains constructors
*/

public class hw14_hop{


	public hw14_hop(){
		System.out.println("Hop");
	}

	 class Skip{

		 Skip(){
			System.out.println("Skip");
		}
		private class Jump{

				public static void main(String[] args) {
		Jump a = new Jump();	
	}

			 Jump(){
				System.out.println("Jump");
			}
		}
	}


}