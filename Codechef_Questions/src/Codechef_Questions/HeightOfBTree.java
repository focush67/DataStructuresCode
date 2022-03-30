package Codechef_Questions;
import java.util.*;
public class HeightOfBTree 
{
	static class Node
	{
		static int val;
		static Node left;
		static Node right;
		
		public Node() {}
		@SuppressWarnings("static-access")
		public Node(int val)
		{
			this.val = val;
		}
		
		@SuppressWarnings("static-access")
		public Node(int val,Node left,Node right)
		{
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	public static void createTree(int x,int y)
	{
		Node tree = new Node();
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			System.out.println("ENTER X AND Y");
			int x = sc.nextInt();
			int y = sc.nextInt();
			createTree(x,y);
			int ans = height();
			System.out.println(ans);
		}

	}

}
