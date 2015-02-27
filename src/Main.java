/**
 * Aromatic Number Converter
 * Direct Console (User) Input Version
 * 
 * https://www.codeeval.com/open_challenges/150/
 *
 * Author: todyerutz@plainintricacy.wordpress.com
 */

//Initial commit only adds aromatic pairs according to (A*R)+(A'*R')+... formula
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String in;
        do {
            System.out.println("Please enter your aromatic number:");
            in = input.nextLine().toUpperCase();
        }while(checkAromatic(in)==false);
        input.close();
        System.out.println("Decimal value of " + in + ": " + calcAromatic(in));
    }


    public static boolean checkAromatic(String q){
        String romans = "IVXLCDM";
        for(int i=0; i<q.length(); i++){
            if(i%2==0&&!Character.isDigit(q.charAt(i))){
                return false;
            }
            if(i%2==1&&!romans.contains(String.valueOf(q.charAt(i)))){
                return false;
            }
        }
        return true;
    }

    public static Integer calcAromatic(String q){
        int sum = 0;
        for(int i=1;i<q.length()-2;i+=2){
            if(calcRoman(q.charAt(i))<calcRoman(q.charAt(i+2))){
                sum-=Integer.parseInt(String.valueOf(q.charAt(i-1)))*calcRoman(q.charAt(i));
            }else{
                sum+=Integer.parseInt(String.valueOf(q.charAt(i-1)))*calcRoman(q.charAt(i));
            }
        }
        sum+=Integer.parseInt(String.valueOf(q.charAt(q.length()-2)))*calcRoman(q.charAt(q.length()-1));
        return sum;
    }

    public static Integer calcRoman(char x){
        Integer[] numbers = {1,5,10,50,100,500,1000};
        char[] romans = {'I','V','X','L','C','D','M'};
        for(int i=0; i<romans.length; i++){
            if(romans[i]==x){
                return numbers[i];
            }
        }
        return 0;
    }

}
