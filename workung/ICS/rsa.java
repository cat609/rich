package rsa_algorithm;

import java.util.Scanner;

class RSA
{
	int gcd(int p,int q)
	{
		if(q==0)
			return p;
		else
			return gcd(q,p%q);
	}

	int public_key(int phi,int p,int q)
	{
		int i=2,num=0;
		while(gcd(i,phi)!=1)
		{
			if(i+1==p)
				i=i+2;
			i++;
		}
		return i;
	}

	int private_key(int phi,int e)
	{
		int d =0,i=1;
		while(i<phi)
		{
			if((i*e)%phi==1)
			{
				d=i;
				break;
			}
			i++;
		}
		return d;
	}
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);

		RSA g = new RSA();

		System.out.println("Enter two numbers:\n 1st :");
		int p = sc.nextInt();
		System.out.println("2nd :");
		int q = sc.nextInt();

		int product = p*q;
		int phi = (p-1)*(q-1);


		int e = g.public_key(phi,p,q);
		System.out.println("public_key is :" + e);	
		
		int d = g.private_key(phi,e);
		System.out.println("private_key is :"+d);

		System.out.println("Enter plain text: ");
		int m = sc.nextInt();

		long cipher_text = ((long)Math.pow(m,e)%product);
		System.out.println("Your cipher_text is :\t"+ cipher_text);

		long plain_text = ((long)Math.pow(cipher_text,d)%product);
		System.out.println("Your plain_text is:"+plain_text);
	}
}
