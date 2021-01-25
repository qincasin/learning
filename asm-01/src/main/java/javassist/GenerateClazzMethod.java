package javassist;

import javassist.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by qincasin on 2021/1/18.
 * 1. CtClass.doubleType 、 intType 、 floatType 等 8 个基本类型和一个 voidType ，也就是空的
 * 返回类型。
 * 2. 传递和返回的是对象类型时，那么需要时用； pool.get(Double.class.getName() ，进行设
 * 置。
 * 3. 当需要设置多个入参时，需要在数组中以此设置入参类型； new CtClass[] {CtClass.doubleType, CtClass.doubleType} 。 4. 在方法体中需要取得入参并计算时，需要使用 $1 、 $2 ...，数字表示入参的位置。 $0 是 this。 5. 设置属性字段，并赋值
 * 6. Javassist 中的装箱/拆箱
 *
 *
 */
public class GenerateClazzMethod {

    public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassPool pool = ClassPool.getDefault();

        CtClass ctClass = pool.makeClass("javassist.MathUtil");

        // 属性字段
        CtField ctField = new CtField(CtClass.doubleType, "π", ctClass);
        ctField.setModifiers(Modifier.PRIVATE + Modifier.STATIC + Modifier.FINAL);
        ctClass.addField(ctField,"3.14");

        // 方法：求圆面积
        CtMethod calculateCircularArea = new CtMethod(CtClass.doubleType, "calculateCircularArea", new CtClass[]{CtClass.doubleType}, ctClass);
        calculateCircularArea.setModifiers(Modifier.PUBLIC);
        calculateCircularArea.setBody("{return π * $1 * $1;}");
        ctClass.addMethod(calculateCircularArea);

        // 方法；两数之和
        CtMethod sumOfTwoNumbers = new CtMethod(pool.get(Double.class.getName()), "sumOfTwoNumbers", new CtClass[]{CtClass.doubleType, CtClass.doubleType}, ctClass);
        sumOfTwoNumbers.setModifiers(Modifier.PUBLIC);
        sumOfTwoNumbers.setBody("{return Double.valueOf($1 + $2);}");
        ctClass.addMethod(sumOfTwoNumbers);

        //动态修改内部返回值
//        CtMethod sumOfTwoNumbers2 = new CtMethod(pool.get(Double.class.getName()), "sumOfTwoNumbers2", new CtClass[]{CtClass.doubleType, CtClass.doubleType}, ctClass);
//        sumOfTwoNumbers2.setModifiers(Modifier.PUBLIC);
//        sumOfTwoNumbers2.setBody("");
        // 输出类的内容
        ctClass.writeFile();



        // 测试调用
//        Class clazz = ctClass.toClass();
//        Object obj = clazz.newInstance();
//
//        Method method_calculateCircularArea = clazz.getDeclaredMethod("calculateCircularArea", double.class);
//        Object obj_01 = method_calculateCircularArea.invoke(obj, 1.23);
//        System.out.println("圆面积：" + obj_01);
//
//        Method method_sumOfTwoNumbers = clazz.getDeclaredMethod("sumOfTwoNumbers", double.class, double.class);
//        Object obj_02 = method_sumOfTwoNumbers.invoke(obj, 1, 2);
//        System.out.println("两数和：" + obj_02);

        Class clazz = ctClass.toClass();
        Object obj = clazz.newInstance();
        Method method_calculateCircularArea = clazz.getDeclaredMethod("calculateCircularArea", double.class);
        Object obj_01 = method_calculateCircularArea.invoke(obj, 1.23);
        System.out.println("圆的面积: " + obj_01);


        Method method_sumOfTwoNumbers = clazz.getDeclaredMethod("sumOfTwoNumbers", double.class, double.class);
        Object obj_02 = method_sumOfTwoNumbers.invoke(obj, 1, 2);
        System.out.println("两数和：" + obj_02);


    }

}
