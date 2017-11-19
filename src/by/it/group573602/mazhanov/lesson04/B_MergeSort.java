package by.it.group573602.mazhanov.lesson04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/*
Реализуйте сортировку слиянием для одномерного массива.
Сложность алгоритма должна быть не хуже, чем O(n log n)

Первая строка содержит число 1<=n<=10000,
вторая - массив A[1…n], содержащий натуральные числа, не превосходящие 10E9.
Необходимо отсортировать полученный массив.

Sample Input:
5
2 3 9 2 9
Sample Output:
2 2 3 9 9
*/
public class B_MergeSort {


    int[] getMergeSort(InputStream stream) throws FileNotFoundException {
        //подготовка к чтению данных
        Scanner scanner = new Scanner(stream);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!

        //размер массива
        int n = scanner.nextInt();
        //сам массива
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = scanner.nextInt();
            System.out.print(res[i]);

        }

        // тут ваше решение (реализуйте сортировку слиянием)
        // https://ru.wikipedia.org/wiki/Сортировка_слиянием
        res = mergeSort(res, 0, res.length - 1);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return res;
    }

    private int[] mergeSort(int[] array, int start, int end){
        if(start>=end)
            return null;
        int mid=start+(end-start)/2;
        mergeSort(array, start, mid);
        mergeSort(array,mid+1, end);


        int[] buff= Arrays.copyOf(array,array.length);
        int i=start;
        int j=mid+1;

        for(int k=start; k<=end; k++){
            if(i>mid){
                array[k]=buff[j++];}
            else if(j>end){
                array[k]=buff[i++];}
            else if(buff[j]<buff[i]){
                array[k]=buff[j++];}
            else {
                array[k]=buff[i++];}
        }
        return array;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/a_khmelev/lesson04/dataB.txt");
        B_MergeSort instance = new B_MergeSort();
        //long startTime = System.currentTimeMillis();
        int[] result = instance.getMergeSort(stream);
        //long finishTime = System.currentTimeMillis();
        for (int index : result) {
            System.out.print(index + " ");
        }
    }


}
