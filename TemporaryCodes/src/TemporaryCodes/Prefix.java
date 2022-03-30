package TemporaryCodes;
import java.util.*;
public class Prefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER T");
		int t = sc.nextInt();
		while(t-->0)
		{
			System.out.println("ENTER N");
		    int n = sc.nextInt();
		    int sum = (n*(n+1))/2;
		    if(sum%2 != 0)
		    {
		        System.out.println("NO");
		        continue;
		    }
		    
		    int sum1 = sum/2;
		    int sum2 = sum/2;
		    int a[] = new int[n/2+1];
		    int b[] = new int[n/2+1];
		    int arr[] = new int[n+1];
		    int k = 1;
		    int m = n;
		    int left = 1;
		    int right = n/2;
		    Arrays.fill(arr,1);
		    while(left < right)
		    {
		        if(arr[left] <= 0 || arr[right] <= 0)
		        {
		            System.out.println("NO");
		            break;
		        }
		        
		        a[left] = k;
		        arr[k]--;
		        ++k;
		        a[right] = m;
		        arr[m]--;
		        --m;
		        b[left] = k;
		        arr[k]--;
		        ++k;
		        b[right] = m;
		        arr[m]--;
		        --m;
		        left++;
		        right--;
		    }
		    
		    System.out.println("YES");
		    for(int i=1;i<a.length;i++)
		    System.out.print(a[i]+" ");
		    System.out.println();
		    for(int i=1;i<b.length;i++)
		    System.out.print(b[i]+" ");
	}
}
}

