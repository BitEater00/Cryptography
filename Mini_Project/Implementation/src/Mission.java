public class Mission 
{
	public void activateShield()
	{
		int[] cipher = cipherMaker("GSNKY" , new int[] {44,173,331,47,132});
		RSA key = new RSA();
		int[] levelThreeRemoved = new int[cipher.length];
		int i = 0 ;
		for(int x:cipher)
		{
			DRSA obj = new DRSA();
			levelThreeRemoved[i] = obj.main(key,x);
			i++;
		}
		
		System.out.println("Level Three Removed");
		for(int x: levelThreeRemoved)
			System.out.print(x + " ");
		
		i = 0;
		int[] levelTwoRemoval = new int[levelThreeRemoved.length];
		for(int x : levelThreeRemoved)
		{
			DSDES obj = new DSDES();
			levelTwoRemoval[i] = obj.main(x);
			i++;
		}
		
		System.out.println("\nLevel Two Removed");
		for(int x:levelTwoRemoval)
			System.out.print(x + " ");
		
		
		String s = "";
		for(int x:levelTwoRemoval)
			s = s + (char)(x);
		
		DMonoAdditive rem = new DMonoAdditive();
		rem.main(s);
		s = rem.cipher;
		System.out.println("Plaintext: "+s);
	}
	
	public int[] cipherMaker(String s , int[] b)
	{
		int[] cipher = new int[b.length];
		for(int i = 0 ; i < b.length ; i++)
		{
			cipher[i] = b[i]*26 + (s.charAt(i)-65);
		}
		
		return cipher;
	}
}
