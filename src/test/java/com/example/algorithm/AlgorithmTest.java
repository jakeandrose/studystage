package com.example.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 测试一些简单算法的实现
 */
public class AlgorithmTest {

    /**
     * 测试冒泡排序法(从小到大)
     */
    @Test
    public void test1(){
        int []arrays = {2,5,1,9,4,8,3,7};
        int temp =0;
        for (int i = 1; i < arrays.length -1; i++){
            for (int j = 0; j < arrays.length -1; j++){
                if(arrays[j] > arrays[j+1]){
                    temp = arrays[j];
                    arrays[j] = arrays[j+1];
                    arrays[j+1] = temp;
                }
            }
        }
        Arrays.stream(arrays).forEach(System.out::println);
    }

    @Test
    public void test2(){
        int []arrays = {2,5,1,9,4,8,3,7};
        int temp =0;
        for (int i = 0; i < arrays.length-2; i++){
            for (int j = i+1 ; j < arrays.length; j++){
                if (arrays[i] > arrays[j]){
                    temp = arrays[i];
                    arrays[i] = arrays[j];
                    arrays[j] = temp;
                }
            }
        }
        Arrays.stream(arrays).forEach(System.out::println);
    }
}
