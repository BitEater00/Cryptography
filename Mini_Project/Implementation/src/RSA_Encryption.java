public class RSA_Encryption 
{
    RSA key;
    RSA_Encryption(RSA key)
    {
        this.key = key;
    }
    public int main(int p)
    {  
        int c = Fast_Expo(p,key);
        return c;
    }
    
    public int Fast_Expo(int P , RSA obj)
    {
        int x = obj.public_key[0];
        int n = obj.public_key[1];
        int[] binx = dectobin(x);
        int y = 1;
        for(int i = 0 ; i < binx.length ; i++)
        {
            
            if(binx[binx.length-i-1] == 1)
                y = mod(y * P , n); 
            
            P = mod(P*P , n);
        }
        
        return y;
    }
    public int mod(int a , int n)
    {
        return a%n;
    }
    
    public int[] dectobin(int n)
    {
        String s =  Integer.toBinaryString(n);
        int[] bin = new int[s.length()];
        for(int i = 0 ; i < s.length() ; i++)
        {
            bin[i] = s.charAt(i) - 48;
        }
        return bin;
    }
}
