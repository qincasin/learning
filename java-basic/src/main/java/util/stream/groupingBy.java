//package util.stream;
//
///**
// * Created by qincasin on 2020/9/7.
// */
//public class groupingBy {
//    public static void main(String[] args) {
//
//
//        ArrayList<Student> list = new ArrayList<>();
//        list.add(new Student("王一", 21, "11", 1, new BigDecimal("193.0"), Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now().plusMinutes(15L))));
//        list.add(new Student("郑二", 22, "22", 0, new BigDecimal("171.0"), Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now().plusHours(16L))));
//        list.add(new Student("张三", 23, "33", 1, new BigDecimal("180.1"), Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now().plusSeconds(500L))));
//        list.add(new Student("李四", 24, "44", 0, new BigDecimal("183.2"), Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now().plusMinutes(18L))));
//        list.add(new Student("赵五", 25, "55", 1, new BigDecimal("178.3"), Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now().plusMinutes(13L))));
//        list.add(new Student("韩六", 26, "88", 0, new BigDecimal("169.4"), Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now().plusMinutes(1L))));
//        list.add(new Student("田七", 27, "77", 1, new BigDecimal("173.5"), Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now().plusMinutes(17L))));
//        list.add(new Student("卢八", 28, "88", 0, new BigDecimal("159.6"), Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now().plusMinutes(1L))));
////        list.add(new Student("钱九", 29, null, 1, new BigDecimal("180.1")));
////        list.add(new Student("魏十", null, "99", null, null));
////        list.add(new Student("肖十一", null, "", null, null));
////        list.add(new Student("柘十二", null, null, null, null));
//
//        //1根据性别进行分组
//        //1.1 为null的数据不需要，直接过滤
//        Map<Integer, List<Student>> collect = list.stream()
//                .filter(a -> a.getGender() != null)
//                .collect(Collectors.groupingBy(Student::getGender));
//        //1.2 需要保留为null的数据
//        Map<? extends Serializable, List<Student>> collect1 = list.stream()
//                .collect(Collectors.groupingBy(a -> {
//                    if (a.getGender() == null) {
//                        return "null";
//                    }
//                    return a.getGender();
//                }));
//
//        //2根据性别分组后，再根据分数分组，>=60:A <60:B 为null的数据保留
//        Map<? extends Serializable, Map<String, List<Student>>> collect2 = list.stream().collect(Collectors.groupingBy(a -> {
//            if (a.getGender() == null) {
//                return "null";
//            }
//            return a.getGender();
//        }, Collectors.groupingBy(b -> {
//            String score = b.getScore();
//            if (score == null) {
//                return "B";
//            } else {
//                return score.compareTo("60") >= 0 ? "A" : "B";
//            }
//        })));
//
//        //3按照gender和height分组，TreeMap默认按key升序 TreeMap key不能为null
//        TreeMap<String, List<Student>> collect3 = list.stream().collect(Collectors.groupingBy(a -> {
//                    if (a.getGender() == null || a.getHeight() == null) {
//                        return "null";
//                    }
//                    return a.getGender() + "->" + a.getHeight();
//                }
//                , TreeMap::new
//                , Collectors.toList()));
//
//
//        //统计gender为1和0的人数
//        Map<? extends Serializable, Long> collect4 = list.stream()
//                .collect(Collectors.groupingBy(a -> {
//                            if (a.getGender() == null) {
//                                return "mix";
//                            }
//                            return a.getGender();
//                        }
//                        , counting()));
//        //按gender分组后，统计60为分界的人数
//        Map<String, Map<String, Long>> collect5 = list.stream().collect(
//                Collectors.groupingBy(//gender分组
//                        a -> {
//                            if (a.getGender() == null) {
//                                return "null";//gender为null
//                            }
//                            return a.getGender() == 1 ? "M" : "F";
//                        }
//                        , Collectors.groupingBy(//60为分界
//                                b -> {
//                                    String score = b.getScore();
//                                    if (score == null) {
//                                        return "null";
//                                    } else {
//                                        return score.compareTo("60") >= 0 ? "A" : "B";
//                                    }
//                                }
//                                , counting()//统计
//                        )
//                ));
//        //统计60分界的男女各多少
//        Map<String, Map<Integer, Long>> collect6 = list.stream()
//                .filter(a -> StringUtils.isNoneBlank(a.getScore()))//过滤score为""和null的数据
//                .filter(b -> b.getGender() != null)//过滤gender为null的数据
//                .collect(
//                        Collectors.groupingBy(
//                                c -> c.getScore().compareTo("60") >= 0 ? "G" : "B",//以60分组
//                                Collectors.groupingBy(
//                                        Student::getGender,//以gender分组
//                                        counting()//统计
//                                )
//                        )
//                );
//
//        //统计男女各年龄之和
//        Map<Integer, Integer> collect7 = list.stream()
//                .filter(a -> a.getAge() != null || a.getGender() != null)
//                .collect(Collectors.groupingBy(Student::getGender,
//                        Collectors.summingInt(Student::getAge)));
//
//        //分组元素存储在自定义集合
//        Map<Integer, TreeSet<Integer>> collect8 = list.stream()
//                .filter(a -> a.getGender() != null)
//                .collect(Collectors.groupingBy(Student::getGender,
//                        Collectors.mapping(Student::getAge, toCollection(TreeSet::new))));
//
//        //计算男女中最高的分数
//        Map<Integer, Student> collect9 = list.stream().filter(a -> a.getGender() != null)
//                .collect(Collectors.groupingBy(
//                        Student::getGender, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Student::getScore)), Optional::get)
//                        )
//                );
//        //计算男女中最低的分数
//        Map<Integer, Student> collect10 = list.stream().filter(a -> a.getGender() != null)
//                .collect(Collectors.toMap(Student::getGender, Function.identity(), BinaryOperator.minBy(Comparator.comparing(Student::getScore)))
//                );
//
//
//        // //计算男女中最高的分数 分数相同去用时最短
//        Map<Integer, Student> collect11 = list.stream().filter(a -> a.getGender() != null)
//                .collect(Collectors.toMap(
//                        Student::getGender,//性别
//                        Function.identity(),//t->t
//                        BinaryOperator.maxBy(
//                                Comparator.comparing(Student::getScore)//分数比较
//                                        .thenComparing(b -> b.getEndTime().getTime() - b.getStartTime().getTime()//分数相同，按时间比较
//                                                , Comparator.reverseOrder()))//外层用的max，故此处排序取反
//                        )
//                );
//
//
//        //相同的存放在list中
//        TreeMap<Integer, Student> collect12 = list.stream().filter(a -> a.getGender() != null)
//                .collect(Collectors.toMap(
//                        Student::getGender,
//                        Function.identity(),
//                        BinaryOperator.maxBy(
//                                Comparator.comparing(Student::getScore)
//                                        .thenComparing(b -> b.getEndTime().getTime() - b.getStartTime().getTime()
//                                                , Comparator.reverseOrder())
//
//                        ),
//                        TreeMap::new
//                        )
//                );
//        HashMap<Integer, List<Student>> hashMap = new HashMap<>();
//        collect12.forEach((k, v) -> {
//            Map<Integer, ArrayList<Student>> listMap = list.stream()
//                    .filter(a ->
//                            k.equals(a.getGender())
//                                    && v.getScore().equals(a.getScore())
//                                    && (a.getEndTime().getTime()-a.getStartTime().getTime())==(v.getEndTime().getTime() - v.getStartTime().getTime())
//                    )
//                    .collect(Collectors.toMap(
//                            Student::getGender,
//                            t -> {
//                                List<Student> students = Collections.singletonList(t);
//                                return new ArrayList<>(students);
//                            },
//                            (v1, v2) -> {
//                                v2.addAll(v1);
//                                return v2;
//                            })
//                    );
//            hashMap.putAll(listMap);
//        });
//
//
//
//
//        //分数最高用时最短
//        Optional<Student> max = list.stream().max(Comparator
//                .comparing(Student::getScore)
//                .thenComparing(a -> a.getEndTime().getTime() - a.getStartTime().getTime(),
//                        Comparator.reverseOrder())
//        );
//        Student student = max.isPresent() ? max.get() : null;
//
//        //最大值 分数 用时
//        Student student1 = list.stream().max(Comparator
//                .comparing(Student::getScore)
//                .thenComparing(a -> a.getEndTime().getTime() - a.getStartTime().getTime(),
//                        Comparator.reverseOrder())
//        ).orElse(null);
//
//
//
//
//        //男女各组的平均分数
//        Map<Integer, Double> collect13 = list.stream()
//                .filter(a -> a.getGender() != null)
//                .filter(b -> StringUtils.isNoneBlank(b.getScore()))
//                .collect(Collectors.groupingBy(Student::getGender,
//                        Collectors.averagingDouble(a -> Double.parseDouble(a.getScore()))));
//
//
//        System.out.println();
//
//    }
//}