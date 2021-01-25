package com.qjx.kotlin

import java.lang.Integer.parseInt

class AA

fun main() {
    println("hello world")
    var a = 5
    a += 1
    println("a=$a")
    var sum = sum(1, 7)
    println("a+b=$sum")

    println("max of 0 and 42 is ${maxOf(0, 42)}")

    // 数列迭代
    for(x in 1..10 step 2){
        print(x)
    }
    println()
    for(x in 9 downTo 0 step 3){
        print(x)
    }
    println()

    for(x in 1 until 10){
        print(x)
    }
    println()

    var listOf = listOf(1, 2, 3)
    println(listOf)

}

fun maxOf(a: Int, b: Int) = if (a > b) a else b


fun sum(a: Int, b: Int): Int {
    return a + b
}

fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    // 直接使用 `x * y` 会导致编译错误，因为它们可能为 null
    if (x != null && y != null) {
        // 在空检测后，x 与 y 会自动转换为非空值（non-nullable）
        println(x * y)
    }
    else {
        println("'$arg1' or '$arg2' is not a number")
    }

}
