package TemporaryCodes;
import java.util.*;
public class tewrhw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER START AND END");
		int start = sc.nextInt();
		int end = sc.nextInt();
		int and=1;
		for(int i=start;i<=end;i++)
		{
			and = and&i;
		}
		
		System.out.println("BITWISE AND : "+and);
	}

}
