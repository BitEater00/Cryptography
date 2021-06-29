import java.util.*;
public class RSA {
    static Scanner br = new Scanner(System.in);
    public int[] public_key = new int[2];
    public int private_key;
    RSA()
    {
        System.out.println("Enter the value of p");
        int p = br.nextInt();
        System.out.println("Enter the value of q");
        int q = br.nextInt();
        primechecker(p,q);
        int n = p*q;
        int phi_n = (p-1)*(q-1);
        possible_E(phi_n);
        System.out.println("Enter the valueof e");
        int e = br.nextInt();
        int d = GCD(phi_n,e,true);
        public_key[0] = e;
        public_key[1] = n;
        private_key = d;
        //System.out.println("N : " + n);
        //System.out.println("Public Key: " + e);
        //System.out.println("Private Key: " + d);
    }
    public void primechecker(int p , int q)
    {
        for(int i = 2 ; i < p/2 ; i++)
            if(p%i == 0)
                System.exit(0);
        
        for(int i = 2 ; i < q/2 ; i++)
            if(q%i == 0)
                System.exit(0);
    }
    public void possible_E(int n)
    {
        for(int i = 2 ; i < n ; i++)
            if(GCD(n,i,false) == 1)
                System.out.print(i + " ");
        System.out.println();
    }
    public int GCD(int a , int b , boolean inv)
    {
        int s1 = 1 ;
        int s2 = 0 ;
        int t1 = 0 ;
        int t2 = 1 ;
        int q = a/b;
        int ad = a;
        int r = a%b ;
        int t = 0 ;
        while(r > 0)
        {
            a = b;
            b = r; 
            t = s1 ;
            s1 = s2; 
            s2 = t - q*s2; 
            t = t1 ;
            t1 = t2; 
            t2 = t - q*t2;
            r = a %b;
            q = a /b ;
        }
        
        if(inv && t2 > 0)
            return t2;
        else if(inv && t2 < 0)
         return t2+ad;
        else
            return b;
    }
    
}
