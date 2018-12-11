#!/bin/bash
echo "helloworld!"

#hello="helloworld!"

#echo $hello

#name='qincasin'

#hello='Hello,I am '$name'!'

#echo $hello

name="qincasin"
# 使用双引号拼接
greeting="hello , "$name"!"
greeting_1="hello,${name}!"
echo $greeting $greeting_1
# 使用单引号拼接
greeting_2='hello,'$name'!'
greeting_3='hello,${name}!'
echo $greeting_2 $greeting_3

# 截取字符串长度
str="qincasin"
# 第一种方式
echo ${#str}
#第二种方式
expr length $name

# expr 表达式的运算符必须要左右都有空格，否则直接输出表达式
expr 5+6
expr 5 + 6

# expr 5 * 6 表达式错误 ，需要转义字符进行转换
expr 5 \* 6

# 简单字符串截取
# 从字符串第1个字符开始往后截取3个字符
str2="qincasin"
echo ${str:0:3} # qin

# 根据表达式截取
var="http://www.runoob.com/linux/linux-shell-variable.html"
s1=${var%%t*} #h
echo $s1
s2=${var%t*} #http://www.runoob.com/linux/linux-shell-variable.h
echo $s2
s3=${var%%.*} #http://www
echo $s3
s4=${var#*//} #/www.runoob.com/linux/linux-shell-variable.html
echo $s4
s5=${var##*/} #linux-shell-variable.html
echo $s5


# shell 数组
array=(1 2 3 4 5)
# 获取数组长度
length=${#array[@]} # 5
length2=${#array[*]}
echo ${length} ${length2}

# 输出数组第三个元素
echo ${array[2]}
echo ${array[*]}
#删除下表为1的元素
unset array[1]
echo ${array[*]}

# 遍历输出
echo '遍历输出数组'
for i in ${array[@]};
        do echo $i;
        done

# 删除数组中所有元素 数组为空
unset array;
#echo ${#array[*]}
for i in ${array[@]};
do echo $i;
done

# shell 基本运算符
# 算数运算符
echo "算数运算符号"
a=10
b=20
expr $a + $b
expr $a - $b
expr $a \* $b
expr $b / $a
expr $b % $a
a=$b
echo $a
a=10

#关系运算符号，不支持字符串，只限数字，除非字符串是数字
echo '关系运算符号'
#输出B
score=90;
maxscore=100;
if [ $score -eq $maxscore ]
then
	echo 'A'
else
	echo 'B'
fi
# 逻辑运算符
echo '逻辑运算符'
# 逻辑与运算只有相与的两边都是1，与的结果才是1，否则与的结果是0
c=$((1&&0))
echo $c;
#布尔运算符号
echo '布尔运算符号'
echo '! 非运算'
echo '-o 或运算，有一个表达式为true,则返回true'
echo '-a 与运算，两边表达式都为true才返回true'
#字符串运算符
echo '字符串运算符号'
echo $a $b
d="abc"
e="efg"
if [ $d = $e ]
then
	echo "a等于b"
else
	echo "a不等于b"
fi
#文件相关运算符
# -r 可读
# -w 可写
# -x 可执行
# -s 是否为空
file="/home/code/shell/test.sh"
if [ -x $file ]
then
	echo "可执行文件"
else
	echo "不可执行"
fi
echo "------------------------"
# shell 流程控制
echo "shll流程控制"
echo "if 条件语句 "
echo $a $b
if [ $a = $b ]
then
	echo "a等于b"
elif [ $a > $b ]
then
	echo "a大于b"
else
	echo "a小于b"
fi
 echo "------------------------"
echo "for 循环语句"
echo "输出当前列表中的数据"
for loop in 1 2 3 4 5
do
	echo "当前的数据为:$loop"
done
echo "------------------------"
echo "产生10个随机数"
for i in {0..9}
do
	echo $RANDOM;
done
echo "------------------------"
echo "输出1到5"
for((i=1;i<=5;i++));do
	echo $i;
done
echo "------------------------"
echo "while语句"
int=1
while(($int<=5))
do
	echo $int
	let "int++"  # 或者let int++
done
echo "------------------------"
#echo "while循环用于读取键盘信息"
#echo "按下 <CTRL-D> 退出 "
#echo -n "请输入你最喜欢的电影:"
#while read FILM
#do
#	echo "是的！$FILM 是一个好电影"
#done

echo "------------------------"
## shell 函数
echo "shell 函数"
#echo "------------------------"
echo "不带参数没有返回值的函数"
func(){
    echo "这是第一个shell函数!"
}
func
echo "------------------------"
echo "有返回值的函数"
funcWithReturn(){
    echo "第一个数字:"
    read aNum
    echo "第二个数字:"
    read anotherNum
    echo "两个数字分别是$aNum 和 $anotherNum !"
    return $(($aNum+$anotherNum))
}
funcWithReturn

echo "输入的两个数的和为: $?"
echo "------------------------"
echo "带参数的函数"
funWithParam(){
    echo "第一个参数 $1 !"
    echo "第二个参数 $2 !"
    echo "第三个参数 $3 !"
    echo "第四个参数 $4 !"
    echo "第五个参数 $5 !"
    echo "第六个参数 $6 !"
    echo "第七个参数 $7 !"
    echo "第八个参数 $8 !"
    echo "第九个参数 ${9} !"
    echo "第十个参数 $10 !"
    echo "第十一个参数 $11 !"
    echo "参数总数有 $# 个!"
    echo "作为一个字符串输出所有参数 $*"
}
funWithParam 1 2 3 4 5 6 7 8 9 34 73
