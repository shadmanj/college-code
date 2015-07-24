/**
* Shadman Jubaer
* This program takes in integer pixel values and outputs
* the red, green, and blue components as integers
*/

public class hw12_pixel{

	public static void main(String[] args){
    	/*
    	hw12_pixel p1 = new hw12_pixel(0xFFFF00FF);
    	System.out.printf("rgb = (%2x, %2x, %2x)\n", p1.getRed(), p1.getGreen(), p1.getBlue());
    	System.out.printf("rgb = (%d, %d, %d)\n", p1.getRed(), p1.getGreen(), p1.getBlue());
        
    	hw12_pixel p2 = new hw12_pixel(0xFF43BF11);
    	System.out.printf("rgb = (%2x, %2x, %2x)\n", p2.getRed(), p2.getGreen(), p2.getBlue());
    	System.out.printf("rgb = (%d, %d, %d)\n", p2.getRed(), p2.getGreen(), p2.getBlue());
		*/
    	
		hw12_pixel p3 = new hw12_pixel(0xFF000000);
		System.out.printf("rgb = (%d, %d, %d)\n", 
			p3.getRed(), p3.getGreen(), p3.getBlue());

		p3.setRed(42);
		p3.setGreen(18);
		p3.setBlue(225);
		System.out.printf("rgb = (%d, %d, %d)\n", 
			p3.getRed(), p3.getGreen(), p3.getBlue());
        
		p3.setRed(-1);
		p3.setGreen(500);
		p3.setBlue(1000);
		System.out.printf("rgb = (%d, %d, %d)\n", 
			p3.getRed(), p3.getGreen(), p3.getBlue());

		/*
		hw12_pixel p1 = new hw12_pixel(0xFF000000);
		System.out.printf("%d\n",p1.getRed());
		p1.setRed(-1);
		System.out.printf("%d\n",p1.getRed());
		*/
	}

	private int pixel;

	public hw12_pixel(int pixel){
		this.pixel = pixel;
	}

	public int getRed(){
		return (pixel >> 16) & 0xFF;
	}

	public int getGreen(){
		return (pixel >> 8) & 0xFF;
	}

	public int getBlue(){
		return pixel & 0xFF;
	}

	public void setRed(int red){
		int mask = 0xFF;
		this.pixel = ~(mask << 16) & this.pixel;
		this.pixel = (red << 16) | this.pixel; 
	}
	
	public void setGreen(int green){
		int mask = 0xFF;
		this.pixel = ~(mask << 8) & this.pixel;
		this.pixel = (green << 8) | this.pixel;
	}

	public void setBlue(int blue){
		int mask = 0xFF;
		this.pixel = blue | this.pixel;
	}
	
}