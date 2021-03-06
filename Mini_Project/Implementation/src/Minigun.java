public class Minigun 
{
	public void activatemain() 
    {
		//LEVEL ONE ENCRYPTION
        MONOADDITIVE level1 = new MONOADDITIVE();
        String level1Cipher = level1.cipher;
        
        //LEVEL TWO ECRYPTION
        int[] levelTwo = new int[level1Cipher.length()];
        System.out.print("Level Two Encryption: ");
        for(int i = 0 ; i < level1Cipher.length();i++)
        {
        	SDES level2 = new SDES();
        	levelTwo[i] = level2.main(level1Cipher.charAt(i));
        }
        for(int x:levelTwo)
        	System.out.print(x+" ");
        System.out.println();
        display(levelTwo);
        
        //LEVEL THREE ENCRYPTION
        RSA key = new RSA();
        RSA_Encryption level3 = new RSA_Encryption(key);
        int[] levelThree = new int[levelTwo.length];
        
        for(int i = 0 ; i < level1Cipher.length();i++)
        {
            levelThree[i] = level3.main(levelTwo[i]);
        }
        
        int[] remove = new int[levelThree.length];
        int i = 0 ;
        for(int x:levelThree)
        {
        	System.out.print(x+" ");
        	remove[i] = x/26;
        	i++;
        }
        
        
        System.out.println("\nPrinting removal");
        for(int x : remove)
        	System.out.print(x+" ");
        
        System.out.println();
        display(levelThree);
    }
	
	public void display(int[] a)
	{
		for(int x :a)
		{
			System.out.print((char)((x%26)+65));
		}
		System.out.println();
	}
}


//47 77 97 16 230 60 331 209 173 208 196 314 268 313 292 132 323 313 383 331 3 44 92 165 373 272 
//KLMUSXZMSCJJVAEYZMPNYGFQAW


