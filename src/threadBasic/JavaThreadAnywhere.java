package threadBasic;

/**
 * @ClassName JavaThreadAnywhere
 * @Deacription 多线程基础，认识
 * @Author Lemonsoul
 * @Date 2020/6/2 0:01
 * @Version 1.0
 **/

public class JavaThreadAnywhere {
    public static void main(String[] args) {

        System.out.println("执行main方法的线程是："+Thread.currentThread().getName());
        Helper helper = new Helper("Thread Demo");
        helper.run();
        System.out.println(Thread.activeCount());
        Thread.currentThread().getThreadGroup().list();
    }


    /**
     * 静态内部类，实现Runnable接口
     */
    static class Helper implements Runnable{

        private final String message;

         Helper(String message){
            this.message = message;
        }

         void doSomething(String message){
            System.out.println("执行doSomething方法的线程是："+Thread.currentThread().getName());
            System.out.println("这个message内容是："+message);
        }

         @Override
         public void run() {
            doSomething(message);
         }
     }

}
