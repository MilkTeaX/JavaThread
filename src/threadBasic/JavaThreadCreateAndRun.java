package threadBasic;

/**
 * @ClassName JavaThreadCreateAndRun
 * @Deacription TODO
 * @Author Lemonsoul
 * @Date 2020/6/2 22:49
 * @Version 1.0
 **/

public class JavaThreadCreateAndRun {

    public static void main(String[] args) {
        System.out.println("执行main方法的线程是："+Thread.currentThread().getName());

        Helper helper = new Helper("嘻嘻");

        Thread thread = new Thread(helper);

        thread.setName("lemon thread");

        thread.start();
        System.out.println(Thread.activeCount());
    }

    static class Helper implements Runnable{

        private final String message;

        public Helper(String message){
            this.message = message;
        }

        private void doSomething(String message){
            System.out.println("执行这个方法的线程是："+Thread.currentThread().getName());
            System.out.println("消息是："+message);
        }

        @Override
        public void run() {
            doSomething(message);

            System.out.println(message+Thread.currentThread().getName());
        }
    }
}
