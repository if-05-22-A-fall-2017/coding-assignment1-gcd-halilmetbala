/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcd;

/**
 *
 * @author halil
 */
public class Gcd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) //482, 802
    {
        System.out.println(gcdPrimeFactors(510, 345));
        System.out.println(gcdEucledian(510, 345));
    }
    public static int gcdPrimeFactors(int a, int b)
    {
        int[] array1 = new int[a/2];
        int[] array2 = new int[b/2];
        array1 = findPrimeFactors(a);
        array2 = findPrimeFactors(b);
        int count1= 0;
        int count2 = 0;
        int multi = 1;
        while((count1 != array1.length  && count2 != array2.length) && (array1[count1] != 0 || array2[count2] != 0 ))
        {
            if(array1[count1] == array2[count2])
            {
                multi = multi * array1[count1];
                count1++;
                count2++;
            }
            else if(array1[count1] < array2[count2])
                count1++;
            else if(array1[count1] > array2[count2])
                count2++;
                
        }
        return multi;
    }
    public static int[] findPrimeFactors(int number)
    {
        int temp = 2;
        int count = 0;
        int[] primeFactors = new int [number/2];
        while(number != 1)
        {
            if(number%temp == 0)
            {
                primeFactors[count] = temp;
                count++;
                number = number/temp;
                temp = 2;
            }
            else
                temp++;
        }
        return primeFactors;
    }
    public static int gcdEucledian(int a, int b)
    {
        if(a<b)
        {
           int temp = a;
           a = b;
           b = temp;
        }
        if(b == 0)
            return a;
        return gcdEucledian(b, (a%b));
    }
}
