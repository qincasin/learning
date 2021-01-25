package agent;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

import java.lang.instrument.Instrumentation;

/**
 * Created by qincasin on 2021/1/22.
 */
public class MyAgentByteBuddy {


    /**
     * @param args
     * @param instrumentation
     */
    public static void premain(String args, Instrumentation instrumentation) {
        System.out.println("hi my agent:" + args);
        AgentBuilder.Transformer transformer = (build, typeDescription, classLoader, javaModule) -> {
            return build
                    .method(ElementMatchers.any())//拦截任意方法
                    .intercept(MethodDelegation.to(MethodCostTime.class));//委托
        };

        AgentBuilder.Listener listener = new AgentBuilder.Listener() {
            @Override
            public void onDiscovery(String s, ClassLoader classLoader, JavaModule javaModule, boolean b) {
                System.out.println("onDiscovery....");
            }

            @Override
            public void onTransformation(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, boolean b, DynamicType dynamicType) {
                System.out.println("onTransformation....");

            }

            @Override
            public void onIgnored(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, boolean b) {
                System.out.println("onIgnored....");

            }

            @Override
            public void onError(String s, ClassLoader classLoader, JavaModule javaModule, boolean b, Throwable throwable) {
                System.out.println("onError....");

            }

            @Override
            public void onComplete(String s, ClassLoader classLoader, JavaModule javaModule, boolean b) {
                System.out.println("onComplete....");
            }
        };

        new AgentBuilder
                .Default()
                .type(ElementMatchers.nameStartsWith("agent.test"))//指定拦截的类
                .transform(transformer)
                .with(listener)
                .installOn(instrumentation);

    }
    //如果代理类没有实现上面的方法，那么 JVM 将尝试调用该方法
    public static void premain(String agentArgs) {
    }

}
