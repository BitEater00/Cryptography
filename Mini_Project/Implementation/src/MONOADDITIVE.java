import java.util.*;
public class MONOADDITIVE
{
    MONOADDITIVE()
    {
    	//System.out.println("IN ADDITION");
        this.main();
    }
    Scanner br = new Scanner(System.in);
    String cipher ;
    public void main()
    {
        System.out.println("Enter the plaintext");
        String P = br.next();
        System.out.println("Enter the key for encryption: ");
        int key = br.nextInt();
        Encrypt( P /*"CRYPTOGRAPHYISFORINFORMATIONSECURITY" */ , key);
    }
    void Encrypt(String cipertext , int i)
    {
        String message = "";
        for(int j = 0 ; j < cipertext.length() ; j++)
        {
            char letter = cipertext.charAt(j);
            int number = converter(letter);
            number = modifier(number + i);
            letter = deconverter(number);
            message = message + letter ;
        }
        
        System.out.println("Level One Encryption : " +message);
        cipher = message;
    } 
    public int converter(char a)
    {
    	
        if(a - 65 >= 0)
        return (int)(a-65);
        else
        return (int)((a-65)+26) ;
    }
    public char deconverter(int a)
    {
        return (char)(a + 65);
    }
    public int modifier(int c)
    {
        if(c < 0 )
            return (c+26)%26;
        else
            return c%26;
    }
}