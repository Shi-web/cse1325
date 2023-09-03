public class TestLine
{
	public static void main(String[] args)
	{
		Line line1 = new Line(8.987,5.767,2.567,7.898,Color.PURPLE);
		System.out.println(line1 + " " + line1.length());
		
		Line line2 = new Line(10.987,25.767,7.567,7.898, Color.INDIGO);
		System.out.println(line2 + " " + line2.length());
		
		Line line3 = new Line(6.987,5.767,4.567,7.898,Color.CYAN);
		System.out.println(line3 +" "+line3.length());
		
		Line line4 = new Line(11.987,2.767,5.567,9.898,Color.CRIMSON);
		System.out.println(line4 + " " + line4.length());
		
	}
}
