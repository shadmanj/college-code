/**
* Shadman Jubaer
* This class just implements the three interfaces 
* Laughable, Cryable, and Shoutable.
* The methods do absoluteley nothing. Just needed it to compile.
*/

public class hw13_emote implements Laughable, Cryable,Shoutable{
	public void cry(int tear, boolean moaning){
		tear = tear;
		moaning = moaning;
	}

	public boolean laugh(int times){
		return false;
	}

	public void laugh(double volume, String words){
		volume = volume;
		words = words;
	}

}