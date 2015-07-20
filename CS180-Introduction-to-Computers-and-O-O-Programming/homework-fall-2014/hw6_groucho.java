/**
* Shadman Jubaer
* This class checks input string against a set "secret" string.
* If the input string contain the "secret string" the player wins.
*/

public class hw6_groucho{
	private String secret;

	public hw6_groucho(String secret){
		this.secret = secret;
	}

	public boolean saysSecret(String line){
		if (line.indexOf(secret)>=0)
			return true;
		else
			return false;
	}
}