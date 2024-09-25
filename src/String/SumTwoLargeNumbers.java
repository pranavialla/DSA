package String;

import java.util.Arrays;

public class SumTwoLargeNumbers {
    public SumTwoLargeNumbers(String num1, String num2) {
        String[] num1decimal = new String[2];
        String[] num2decimal = new String[2];
        String sum ="";

        num1decimal = getNumDecimal(num1);
        num2decimal = getNumDecimal(num2);

        if(num1decimal[1].length()<num2decimal[1].length()){
            String temp1 = num1decimal[1];
            num1decimal[1] = num2decimal[1];
            num2decimal[1] = temp1;
            String zero = "0";
            num2decimal[1] = num2decimal[1] + zero.repeat(num1decimal[1].length()- num2decimal[1].length());
        }
        else {
            String zero = "0";
            num1decimal[1] = num1decimal[1] + zero.repeat(num2decimal[1].length()- num1decimal[1].length());
        }



        String decimalSum[]= computeSum(num1decimal[1], num2decimal[1], num1decimal[1].length()-1, num2decimal[1].length()-1, 0);
        sum = decimalSum[1];
        int carry = Integer.parseInt(decimalSum[0]);


        if( num1decimal[0].length() < num2decimal[0].length() ){
            String temp = num1decimal[0];
            num1decimal[0] = num2decimal[0];
            num1decimal[0] = temp;
        }

        num1decimal[0].replace(",", "");
        num2decimal[0].replace(",", "");

        int i1 = num1decimal[0].length()-1;
        int i2 = num2decimal[0].length()-1;


        String[] IntegrSum = computeSum(num1decimal[0], num2decimal[0],  i1, i2, carry);
        if(Integer.parseInt(IntegrSum[0])!=0){
            sum = sum + IntegrSum[0];
        }

        IntegrSum[1] = BeautifyWithComma(IntegrSum[1]);

        if(sum!=""){
            sum = IntegrSum[1]+"."+sum;
        }
        else{
            sum = IntegrSum[1];
        }


        System.out.println(sum);
    }

    private String[] getNumDecimal(String num1) {
        String[] num1decimal = new String[2];

        if(num1.indexOf('.') == -1){
            num1+=".0";
        }
        num1decimal[0]= num1.substring(0, num1.indexOf('.') );
        num1decimal[1]= num1.substring(num1.indexOf('.')+1, num1.length() );

        return num1decimal;
    }

    private String BeautifyWithComma(String num1) {

        int count =0;
        int l = num1.length()-1;
        String ans = "";

        while(l>=0){

            if(count%3==0 && l!=0 && count!=0){
                ans =  "," + ans;
                l--;
            }
            ans = num1.charAt(l) + ans;
            l--;
            count++;
        }
         return ans;

    }

    private String[] computeSum(String num1, String num2, int i1, int i2, int carry) {
        while (i1 >= 0){
            int tempSum = carry + Integer.parseInt(String.valueOf(num1.charAt(i1)));


            if( i2 >= 0 ){
                tempSum += Integer.parseInt(String.valueOf(num2.charAt(i2)));
                i2--;
            }

            carry = 0;

            if( tempSum >= 10 ){
                carry = tempSum/10;
                tempSum = tempSum%10;
            }

            if(i1==num1.length()-1){
                num1 = num1.substring(0, i1) + String.valueOf(tempSum);
                i1--;
                continue;
            }
            num1 = num1.substring(0, i1) + String.valueOf(tempSum) + num1.substring(i1+1, num1.length());
            i1--;

        }



        return new String[]{String.valueOf(carry), num1 };
    }




}
