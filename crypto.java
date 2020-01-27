import java.util.Scanner;

public class crypto
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the text to be crypted: ");
        String text = input.nextLine();

        System.out.print("Enter the shift code: ");
        int shift = input.nextInt();

        System.out.print("Enter the grouping number: ");
        int group = input.nextInt();

        String cypherText = encryptText(text,shift,group);

        System.out.print("\nEnter the de-shifting value: ");
        int deshift = input.nextInt();

        System.out.println("\n\""+decryptText(cypherText,deshift)+"\"");
    }

    public static String encryptText(String text, int shift, int group)
    {
        System.out.println("\n\""+normalizeText(text)+"\"");
        StringBuilder newText = normalizeText(text);

        System.out.println("\n\""+caesar(newText, shift)+"\"");


        newText = caesar(newText,shift);
        String cypherText = newText.toString();

        System.out.println("\n\""+group(cypherText,group)+"\"");

        cypherText = group(cypherText,group);

        return cypherText;
    }

    public static String decryptText(String cypherText,int deshift)
    {
        String cyphertext = ungroup(cypherText);

        return decrypt(cyphertext,deshift);
    }

    public static StringBuilder normalizeText(String text)
    {
        StringBuilder newText = new StringBuilder();

        for(int i=0;i<text.length();i++)
        {
            if(text.charAt(i)>='a' && text.charAt(i)<='z' || text.charAt(i)>='A' && text.charAt(i)<='Z')
                newText.append(Character.toUpperCase(text.charAt(i)));
        }

        return newText;
    }

    public static StringBuilder caesar(StringBuilder newText, int shift)
    {
        int encrypt ;
        int diff;

        String encryptText;
        StringBuilder cypherText = new StringBuilder();

        for (int i=0;i<newText.length();i++)
        {
            encrypt = (int)newText.charAt(i)+shift;

            /*if(encrypt>(int)'z')
            {
                diff = 'z'-(int)newText.charAt(i);
                encrypt = ((int)'a' + (shift-1))-diff;

                encryptText = Character.toString(encrypt);
                cypherText.append(encryptText);
            }*/

            if(encrypt>(int)'Z')
            {
                diff = 'Z'-(int)newText.charAt(i);
                encrypt = ((int)'A' + (shift-1))-diff;

                encryptText = Character.toString(encrypt);
                cypherText.append(encryptText);
            }

            else
            {
                encryptText = Character.toString(encrypt);
                cypherText.append(encryptText);
            }
        }

        return cypherText;
    }

    public static String group(String newtext, int x)
    {
        String padding = "x";

        if(newtext.length()/x>0)
        {
            return newtext.substring(0,x) + " " + group(newtext.substring(x),x);
        }

        else
        {
            if(newtext.length()%x==0)
                return newtext;
            else
            {
                for(int i=1;i<(x-newtext.length());i++)
                    padding = padding + "x";
                return newtext+padding;
            }
        }
    }

    public static String ungroup(String newtext)
    {
        newtext = newtext.replace(" ","");
        newtext = newtext.replace("x","");

        return newtext;
    }

    public static String decrypt(String cyphertext, int shift)
    {
        int encrypt ;
        int diff;

        String encryptText;
        StringBuilder cypherText = new StringBuilder();

        for (int i=0;i<cyphertext.length();i++)
        {
            encrypt = (int)cyphertext.charAt(i)-shift;
            /*if(encrypt<(int)'a')
            {
                diff = (int)cyphertext.charAt(i)-'a';
                encrypt = ((int)'z' - (shift-1))+diff;
                //System.out.println(encrypt);

                encryptText = Character.toString(encrypt);
                cypherText.append(encryptText);
            }*/

            if(encrypt<(int)'A')
            {
                diff = (int)cyphertext.charAt(i)-'A';
                encrypt = ((int)'Z' - (shift-1))+diff;


                encryptText = Character.toString(encrypt);
                cypherText.append(encryptText);
            }

            else
            {
                encryptText = Character.toString(encrypt);
                cypherText.append(encryptText);
            }
        }

        return cypherText.toString();
    }
}