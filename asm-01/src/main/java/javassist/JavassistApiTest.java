package javassist;

/**
 * Created by qincasin on 2021/1/18.
 * 1. CtClass.doubleType 、 intType 、 floatType 等 8 个基本类型和一个 voidType ，也就是空的
 * 返回类型。
 * 2. 传递和返回的是对象类型时，那么需要时用； pool.get(Double.class.getName() ，进行设
 * 置。
 * 3. 当需要设置多个入参时，需要在数组中以此设置入参类型； new CtClass[] {CtClass.doubleType, CtClass.doubleType} 。 4. 在方法体中需要取得入参并计算时，需要使用 $1 、 $2 ...，数字表示入参的位置。 $0 是 this。 5. 设置属性字段，并赋值
 * 6. Javassist 中的装箱/拆箱
 */
public class JavassistApiTest {
    private double π = 3.14D;

    public double calculateCircularArea(int r) {
        return π * r * r;
    }

    //S = a + b

    public double sumOfTwoNumbers(double a, double b) {
        return a + b;
    }


}
