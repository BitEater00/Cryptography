import java.util.Scanner;
public class DMonoAdditive
{
    Scanner br = new Scanner(System.in);
    String cipher ;
    public void main(String P)
    {
        System.out.println("\nEnter the key for dencryption: ");
        int key = br.nextInt();
        Decrypt( P /*"CRYPTOGRAPHYISFORINFORMATIONSECURITY" */ , key);
    }
    void Decrypt(String cipertext , int i)
    {
        String message = "";
        for(int j = 0 ; j < cipertext.length() ; j++)
        {
            char letter = cipertext.charAt(j);
            int number = converter(letter);
            number = modifier(number - i);
            letter = deconverter(number);
            message = message + letter ;
        }
        
        //System.out.println("Plaintext: "+message);
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