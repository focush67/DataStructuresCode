package TemporaryCodes;
import java.util.*;
public class Shufflin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n+1];
			int odd = 0;
			int even = 0;
			for(int i=1;i<=n;i++)
			{
				arr[i] = sc.nextInt();
				if(arr[i]%2 == 0)
					even++;
				else
					odd++;
			}
			
			int oddPos = (n%2 != 0)?(n/2 + 1):(n/2);
			int evenPos = n - oddPos;
			int x = Math.min(oddPos, even);
			int y = Math.min(evenPos, odd);
			if(x<=3 && y<=3)
				System.out.println(x+y);
		}
	}

}
