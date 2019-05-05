/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos_ncq;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author hanen
 */
public class Solution {

    public int solutionFirstAlgo(int[] A) {
        HashSet<Integer> set = new HashSet<Integer>();
        int size = A.length;
        for (int i = 0; i < size; i++) {
            int value = A[i];
            if (!set.add(value)) {
                set.remove(value);
            }
        }
        Iterator<Integer> iterator = set.iterator();
        return iterator.next();
    }

    public int[] solutionSecondAlgo(int N, int[] A) {
        int[] result = new int[N];
        int sizeA = A.length;
        int max = 0;
        for (int i = 0; i < sizeA; i++) {
            if (A[i] == N + 1) {
                Arrays.fill(result, max);
            } else {
                result[A[i] - 1]++;
                if (result[A[i] - 1] > max) {
                    max++;
                }
            }
        }

        return result;
    }

    public int[] solutionThirdAlgo(int[] A, int[] B) {
        int size = A.length;
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            int rungs = A[i];
            int resultElement = 1;
            int twoNbrs = 1;

            while (rungs >= 2 * twoNbrs) {
                int oneNbrs = rungs - 2 * twoNbrs;
                int sum = oneNbrs + twoNbrs;
                float combination = 1;
                if(sum > twoNbrs){
                     combination = (factorialRecursive(sum)) / (factorialRecursive(sum - twoNbrs) * factorialRecursive(twoNbrs));
                }
               
                resultElement += combination;
                twoNbrs++;
            }
            Double power = Math.pow(2, B[i]);
            result[i] = resultElement % power.intValue();
        }
        return result;
    }

    public static long factorialRecursive(int n) {
        return n == 1 ? 1 : n * factorialRecursive(n - 1);
    }
}
