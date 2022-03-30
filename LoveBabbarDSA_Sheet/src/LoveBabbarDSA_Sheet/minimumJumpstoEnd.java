package LoveBabbarDSA_Sheet;
import java.util.*;

public class minimumJumpstoEnd 
{
}
	

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER NUMBER OF ELEMENTS IN ARRAY : ");
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("ENTER ELEMENT");
			arr[i] = sc.nextInt();
		}
		
		System.out.println("YOUR ARRAY ");
		for(int i=0;i<n;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		

	}

}
