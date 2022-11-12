// Java program to demonstrate working of split(regex,
// limit) with high limit.
package asg;
public class GFG {
	public static void main(String args[])
	{
		String str = "geekss for ; for ; geekss";
		String[] arrOfStr = str.split(" ; ", 5);

		for (String a : arrOfStr)
			System.out.println(a);
	}
}
