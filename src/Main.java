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
            in = input.nextLine();
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
        for(int i=0;i<q.length()-1;i+=2){
            sum += Integer.parseInt(String.valueOf(q.charAt(i)))*calcRoman(q.charAt(i+1));
        }
        return sum;
    }

    public static Integer calcRoman(char x){
        if(x=='I'){
            return 1;
        }else
            if(x=='V'){
                return 5;
                }else
                if(x=='X'){
                    return 10;
                }else
                    if(x=='L'){
                        return 50;
                    }else
                        if(x=='C'){
                            return 100;
                        }else
                            if(x=='D'){
                                return 500;
                            }else
                                if(x=='M'){
                                    return 1000;
                                }
        return 0;
    }
}
