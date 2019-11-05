package chinese_remainder_theorem;
import java.io.*;
import java.util.Scanner;

public class CRT {

	static int ChineseRemainder(int[] xi,int[] remainder) {
		int x = 1;
		while(true) {
			int j;
			for(j=0;j<xi.length;j++) {
				if(x%xi[j] != remainder[j]) {
					break;
				}
			}
			if(j == xi.length) {
				return x;
			}
			x++;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n;
		System.out.println("Enter the number of equations");
		n = input.nextInt();
		int[] xi = new int[n];
		int[] remainder = new int[n];
		
		for(int i=0;i<n;i++) {
			System.out.println("Enter x("+i+")");
			xi[i] = input.nextInt();
		}
		
		for(int i=0;i<n;i++) {
			System.out.println("Enter remainder("+i+")");
			remainder[i] = input.nextInt();
		}
		System.out.println(" X is "+ ChineseRemainder(xi,remainder));
	}

}
