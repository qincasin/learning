package com.qjx.java8.steam;

import com.qjx.tool.util.JsonTools;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by qincasin on 2020/11/8.
 */
@SpringBootTest
@Slf4j
public class StreamTest {


    List<Integer> int1 ;
    List<Integer> int2 ;

    List<Integer> reduce;

    @BeforeEach
    public void before(){
        int1 = Arrays.asList(1,2,3);
        int2 = Arrays.asList(3,4);
        reduce = Arrays.asList(1,2,3,4,5);
    }

    /**
     * ==================== flatMap ===================
     */

    /**
     * flat map 给定两个列表[1,2,3],[3,4] ， 返回数对 (1,3),(1,4),(2,3),(2,4),(3.3),(3.4)
     */
    @Test
    public void testFlatMap(){

        List<int[]> list = int1.stream()
                .flatMap(i -> int2.stream().map(j -> new int[]{i, j}))
                .collect(toList());
        System.out.println(JsonTools.defaultMapper().toJson(list));
        log.info("数对为:{}",list);
    }

    /**
     * 如上，只展示 返回的数对中和可以被3整除的数对列表
     */
    @Test
    public void testFlatMap2() {
        List<int[]> result = int1.stream()
                .flatMap(i -> int2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j})
                ).collect(toList());
        log.info("result:{}", JsonTools.defaultMapper().toJson(result));
    }

    /**
     * ==================== 查找和匹配 ===================
     */
    /**
     * findFirst 和 findAny 区别？ 并行时 ，any限制更少，如果想要随机选择一个，建议使用any,findFirst 在并行上限制更多
     */

    /**
     * ==================== reduce ===================
     */
    @Test
    public void testReduce(){
        Integer reduce = this.reduce.stream().reduce(0, (a, b) -> a + b);
        log.info("reduce:{}",reduce);
    }
    /**
     * ==================== 查找和匹配 ===================
     */
    /**
     * 判断给定的a b 是否可以构成勾股数 Math.sqrt(a*a+b*b) %1 == 0
     */
    @Test
    public void testGouGuNum() {
//        log.info("1:{}", 1.122 % 1 == 0);
//        log.info("2:{}", 12 % 1 == 0);
//        log.info("2:{}", 12.111 % 1.0 == 0);

        List<double[]> result = IntStream.rangeClosed(1, 100) //有边界的
                .boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)}))
                .filter(t -> t[2] % 1 == 0)
                .collect(toList());
        log.info("1----100内的勾股数:{}", JsonTools.defaultMapper().toJson(result));
    }

    /**
     * ==================== 构建流 ===================
     */
    /**
     * 构建一个无线流  使用Steam#iterate或者#generate 这两个操作可以创建所谓的无限流
     */
    @Test
    public void iterate(){
        //0 2 4 6 8  .....   偶数 前10 个
//        printNum();
        //斐波那契元组 的前20个
        printFib();
    }

    public void printNum(){
        Stream.iterate(0,n->n+2)
                .limit(10)
                .forEach(System.out::print);
    }

    public void printFib(){
        Stream.iterate(new int[]{0,1},
                t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .forEach(t -> System.out.println(t[0] + " " + t[1]));
    }

    /**
     * ==================== 收集器 ===================
     * 1.将流元素归约和汇总为一个值
     * 2.元素分组
     * 3.元素分区
     */

    /**
     *  分区
     *  将数据按照质数和非质数分区
     */
    @Test
    public void testIsPrime(){
        int candidate = 10;
        Map<Boolean, List<Integer>> prime2 = isPrime2(candidate);
        System.out.println(prime2);

    }
    public Map<Boolean, List<Integer>> isPrime2(int candidate){
        Map<Boolean, List<Integer>> result = IntStream.rangeClosed(2, candidate).boxed()
                .collect(Collectors.partitioningBy(this::isPrime));
        return result;

    }
    private boolean isPrime(int candidate){
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }





}



