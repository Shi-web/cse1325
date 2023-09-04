public enum Color
{
	PURPLE (128,0,128), 
	INDIGO (75,00,130), 
	CYAN (0,255,255), 
	CRIMSON (220,20,60);
	
	private int r;
	private int g;
	private int b;
	
	private Color(int r, int g, int b)
	{
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public String toString()
	{
			
			String text = "(0x" +
           Integer.toHexString(r | 0x100).substring(1).toUpperCase() +
           Integer.toHexString(g | 0x100).substring(1).toUpperCase() +
           Integer.toHexString(b | 0x100).substring(1).toUpperCase() +
           ")";
           String colorCode = String.format("\033[38;2;%d;%d;%dm",r, g, b);
		   String resetCode = "\033[0m";    
		   return   this.name() + colorCode + text + resetCode;
	}
	

}
