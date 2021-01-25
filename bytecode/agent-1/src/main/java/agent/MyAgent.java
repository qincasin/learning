package agent;

import java.lang.instrument.Instrumentation;

/**
 * Created by qincasin on 2021/1/22.
 */
public class MyAgent {
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("this is my agent：" + agentArgs);
        MyMonitorTransformer myMonitorTransformer =  new MyMonitorTransformer();
        inst.addTransformer(myMonitorTransformer);
    }
    //如果代理类没有实现上面的方法，那么 JVM 将尝试调用该方法
    public static void premain(String agentArgs) {
        System.out.println("222222222");
    }


}
