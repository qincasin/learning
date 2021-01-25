package agent.test;

/**
 * Created by qincasin on 2021/1/22.
 */
public class TestByteBuddy {
    public static void main(String[] args) throws Exception{
        TestByteBuddy apiTest = new TestByteBuddy();
        apiTest.echoHi();
        Thread.sleep((long) (Math.random() * 50));
    }

    private void echoHi() throws InterruptedException {
        System.out.println("hi agent");
        Thread.sleep((long) (Math.random() * 500));
    }
}
