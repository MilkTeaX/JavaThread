package threadBasic;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @ClassName WorkerThread
 * @Deacription 工作者线程
 * @Author Lemonsoul
 * @Date 2020/6/17 21:23
 * @Version 1.0
 **/

public class WorkerThread {

    public static void main(String[] args) {
        Helper helper = new Helper();
        helper.init();

        //此处，helper的客户端线程为main线程
        helper.submit("something");
    }


    static class Helper{
        /*
        * 基于数组的阻塞队列
        * */
        private final BlockingQueue<String> workQueue = new ArrayBlockingQueue<String>(100);

        //用于处理队列workQueue中的任务的工作线程
        private final Thread workerThread = new Thread(()->{
            String task;
            while (true){
                try {
                    task = workQueue.take();
                }catch (InterruptedException e){
                    break;
                }
                System.out.println(doProcess(task));
            }
        });


        /*
        Runnable workerThread=()->{
            String task = null;
            while (true) {
                try {
                    task = workQueue.take();
                } catch (InterruptedException e) {
                    break;
                }
                System.out.println(doProcess(task));
            }
        };
        */

        void init(){
            workerThread.start();
        }

        String doProcess(String task){
            return task + "->process.";
        }

        void submit(String task){
            try {
                workQueue.put(task);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
}
