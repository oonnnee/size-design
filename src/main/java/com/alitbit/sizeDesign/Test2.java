package com.alitbit.sizeDesign;

public class Test2 {

    public static void main(String[] args){
        int a = 3;
        int b = (a<<4) & (a<<3);
        System.out.println(b);
        System.out.println(find());
    }

    public static String find(){
        int[] arr = {98, 12, 8, 92, 13};
        int M = 20;

        int min = arr[0];
        for (int i=1; i<arr.length; i++){
            if (arr[i] < min){
                min = arr[i];
            }
        }

        int max = M - min;
        int[] arr2 = new int[arr.length];

        int count = 0;
        for (int i=0; i<arr.length; i++){
            if (arr[i] == max){
                return min + " " + max;
            }else if (arr[i] < max){
                count++;
                arr2[count-1] = arr[i];
            }
        }


        for (int i=0; i<arr2.length-1; i++){
            for (int j=i; j<arr2.length-1; j++){
                if (arr2[j] + arr2[j+1] == M){
                    return arr2[j] + " " + arr2[j+1];
                }
            }
        }

        return null;
    }

}
