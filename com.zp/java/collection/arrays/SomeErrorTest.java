package collection.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class SomeErrorTest{
    public static void main(String[] args) {
        //误区1
        int arr[] = {1,2,3};
        List list = Arrays.asList(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(list.toString());
        System.out.println(list.size());

        //误区2
        String arr1[] = {"我们","都爱","java"};
        List list1 = Arrays.asList(arr1);
        arr1[1] = "是";
        list1.set(2,"猪");
        System.out.println(Arrays.toString(arr1));
        System.out.println(list1.toString());

        //误区3
        String arr2[] = {"我们","都爱","java"};
        List list2 = Arrays.asList(arr2);
        StringBuilder operation = null;
        try {
            operation = new StringBuilder("add");
            list2.add("嘻嘻");
            operation = operation.append(" remove");
            list2.remove("java");
        } catch (Exception e) {
            System.out.println(operation + "操作出现问题！");
        }
        System.out.println(list2.toString());


        /*
            1、错误一
         
            由于Arrays.ArrayList参数为可变长泛型，而基本类型是无法泛型化的，所以它把int[] arr数组当成了一个泛型对象，所以集合中最终只有一个元素arr。

            2、错误二

            由于asList产生的集合元素是直接引用作为参数的数组，所以当外部数组或集合改变时，数组和集合会同步变化，这在平时我们编码时可能产生莫名的问题。

            3、错误三

            由于asList产生的集合并没有重写add,remove等方法，所以它会调用父类AbstractList的方法，而父类的方法中抛出的却是异常信息。
         */

         //java8 数组转换集合
         int[] intArr = { 1, 2, 3 };
         List<Integer> list3 = Arrays.stream(intArr).boxed().collect(Collectors.toList());
         System.out.println(list3.toString());
    }
}