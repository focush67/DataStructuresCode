package LoveBabbarDSA_Sheet;
import java.util.*;
public class mergeInConstantSpace
{
	private static int nextGap(int gap)
    {
        if (gap <= 1)
            return 0;
        return (gap / 2) + (gap % 2);
    }
 
    private static void merge(int[] arr1,int[] arr2, int n,int m)
    {
        int i, j, gap = n + m;
        for (gap = nextGap(gap); gap > 0;
             gap = nextGap(gap))
        {
            for (i = 0; i + gap < n; i++)
                if (arr1[i] > arr1[i + gap])
                {
                    int temp = arr1[i];
                    arr1[i] = arr1[i + gap];
                    arr1[i + gap] = temp;
                }
 
            for (j = gap > n ? gap - n : 0;
                 i < n && j < m;
                 i++, j++)
                if (arr1[i] > arr2[j])
                {
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
 
            if (j < m)
            {
                
                for (j = 0; j + gap < m; j++)
                    if (arr2[j] > arr2[j + gap])
                    {
                        int temp = arr2[j];
                        arr2[j] = arr2[j + gap];
                        arr2[j + gap] = temp;
                    }
            }
        }
    }
 
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER SIZE OF FIRST ARRAY :");
		int m = sc.nextInt();
		int arr1[] = new int[m];
		System.out.println("NOW ENTER ELEMENTS IN FIRST ARRAY");
		for(int i=0;i<m;i++)
			arr1[i] = sc.nextInt();
		
		System.out.println("ENTER SIZE OF SECOND ARRAY :");
		int n = sc.nextInt();
	    int arr2[] = new int[n];
	    System.out.println("NOW ENTER ELEMENTS IN SECOND ARRAY :");
	    for(int i=0;i<n;i++)
	    {
	    	arr2[i] = sc.nextInt();
	    }
	    
	    System.out.println("BEFORE MERGING"+"\n");
	    System.out.println("FIRST ARRAY :");
	    for(int i=0;i<m;i++)
	    	System.out.print(arr1[i]+" ");
	    System.out.println("\n");
	    System.out.println("SECOND ARRAY :");
	    for(int i=0;i<n;i++)
	    	System.out.print(arr2[i]+" ");
	    System.out.println("\n");
	    merge(arr1,arr2,m,n);
	    System.out.println("AFTER MERGING"+"\n");
	    System.out.println("FIRST ARRAY :");
	    for(int i=0;i<m;i++)
	    	System.out.print(arr1[i]+" ");
	    System.out.println("\n");
	    System.out.println("SECOND ARRAY :");
	    for(int i=0;i<n;i++)
	    	System.out.print(arr2[i]+" ");
	    System.out.println("\n");

	}

}
