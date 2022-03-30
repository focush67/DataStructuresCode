package Codechef_Questions;
import java.util.*;
public class Maximum_AND_Subarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER NUMBER OF TESTCASES");
		int t = sc.nextInt();
		while(t-->0)
		{
			System.out.println("ENTER NUMBER OF ELEMENTS\n");
			int n = sc.nextInt();
			int a = 0;
			int j = 1;
			while(j<=n)
			{
				a=j;
				j*=2;
			}
			
			int b = n-a+1;
			int ans = Math.max(a/2, b);
			System.out.println("REQUIRED LONGEST SUBARRAY LENGTH : "+ans);
			System.out.println("\n");
		}

	}

}
