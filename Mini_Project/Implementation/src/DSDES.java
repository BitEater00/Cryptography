public class DSDES
{
	 int[] plain = new int[8];
	 int[] right = new int[4];
	 int[] left = new int[4];
	 int[] cipher = new int[8];
	 int[][] keyfinal = {{1,1,1,0,1,0,1,0},{0,0,1,0,1,1,1,1}};
	 int CipherText;
	public  void permutation()
	{
		int[] p = {1,5,2,0,3,7,4,6};
		int[] a = new int[8];
		for(int i = 0 ; i< p.length ; i++)
		{
			a[i] = plain[p[i]];
		}
		plain = a;
	}
	public  void separator()
	{
		for(int i = 0;i<4;i++)
		{
			left[i] = plain[i];
			right[i] = plain[i+4];
		}
	}
	public  int[] expansion(int[]c)
	{
		int[] p = {3,0,1,2,1,2,3,0};
		int[] b = new int[8];
		for(int i = 0 ; i< p.length ; i++)
		{
			b[i] = c[p[i]];
		}
		return b;
	}
	public  void swapper()
	{
		int[] a = right;
		right = left;
		left = a;
	}
	public  int[] permutationfour(int[] a)
	{
		int[] p = {1,3,2,0};
		int[] b = new int[4];
		for(int i = 0 ; i< p.length ; i++)
		{
			b[i] = a[p[i]];
		}
		return b;
	}
	public  int[] sbox(int[] a)
	{
		int[][] szero = {{1,0,3,2},{3,2,1,0},{0,2,1,3},{3,1,3,2}};
		int[][] sone = {{0,1,2,3},{2,0,1,3},{3,0,1,0},{2,1,0,3}};
		int one,two,three,four;
		one = a[0]*2 + a[3];
		two = a[1]*2 + a[2];
		three = a[4]*2 + a[7];
		four = a[5]*2 + a[6];
		int o = szero[one][two];
		int t = sone[three][four];
		int[] b = {o/2,o%2,t/2,t%2};
		return b;
	} 
	public  int[] function(int n)
	{
		int[] a = expansion(right);
		for(int i = 0 ; i < 8 ; i++)
			a[i] = keyfinal[n][i]^a[i] ;
		a = sbox(a);
		a = permutationfour(a);
		for(int i = 0 ; i < a.length ; i++)
			a[i] = a[i]^left[i]; 
		return a;
	}
	public  void combine()
	{
		for(int i = 0 ; i < 4 ; i++)
		{
			plain[i] = left[i];
			plain[i+4] = right[i];
		}
	}
	public  void ipermutation()
	{
		int[] p = {3,0,2,4,6,1,7,5};
		int[] a = new int[8];
		for(int i = 0 ; i< p.length ; i++)
		{
			a[i] = plain[p[i]];
		}
		cipher = a;
	}
	public void setplaintext(int con)
    {
        int ci = con ;
        String s = Integer.toBinaryString(ci);
        for(int i = 0 ; i < 8 ; i++)
        {
            if(i < 8 - s.length())
            	plain[i] = 0;
            else
            	plain[i] = (int)(s.charAt(i - (8-s.length())) - 48);
        }
    }
    void setCipherText()
    {   
        int t = 1 ;
       for(int i = 0 ; i < 8 ; i++)
       {
    	   CipherText = CipherText + t*cipher[7 - i];
           t =t*2;
       }
    }
	public char main(int c)
	{
		setplaintext(c);
		permutation();
		separator();
		left = function(0);
		swapper();
		left = function(1);
		combine();
		ipermutation();
		setCipherText();
		return (char)CipherText;
	}
}