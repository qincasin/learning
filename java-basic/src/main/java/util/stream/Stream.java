package util.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qincasin on 2020/6/24.
 */
public class Stream {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<Integer>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        //findAny()操作，返回的元素是不确定的，
        // 对于同一个列表多次调用findAny()有可能会返回不同的值。
        // 使用findAny()是为了更高效的性能。如果是数据较少，串行地情况下，一般会返回第一个结果，如果是并行的情况，那就不能确保是第一个
        //findFirst() 返回列表中的第一个元素
        Integer integer = integers.stream()
                .filter(i -> i > 1)
                .findAny()
                .orElse(null);
        System.out.println(integer);


        //short-circuiting是指：有时候需要在遍历中途停止操作，
        // 比如查找第一个满足条件的元素或者limit操作。
        // 在Stream中short-circuiting操作有：anyMatch、allMatch、noneMatch、findFirst、findAny、limit
        // ，这些操作在Sink中都有一个变量来判断是否短路，比如limit用的是m，match用的是stop，find用的是hasValue。

        List<Integer> b = new ArrayList<>();
        b.add(3);

        integers.removeAll(b);
        System.out.println(integers);
        integers.remove(1);
        System.out.println(integers);


    }
}
