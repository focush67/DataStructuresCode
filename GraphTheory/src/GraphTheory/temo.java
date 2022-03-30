package GraphTheory;
import java.util.*;
public class temo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int p[] = new int[10001];
		for(int i=1;i<=10000;i++)
			p[i] = i+p[i-1];
		
		for(int i=1;i<=1000;i++)
			System.out.println(p[i]+"  ("+i+")");
	}

}
