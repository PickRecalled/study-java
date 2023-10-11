package com.pickrecalled.thread;

import java.util.Objects;
import java.util.concurrent.*;

/**
 * 线程池工厂
 *
 * @author shuang
 */
public class ThreadPoolFactory {

    /**
     * 线程池的基本大小
     */
    private static final Integer CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors() + 1;
    /**
     * 线程池中允许的最大线程数
     */
    private static final Integer MAXIMUM_POOL_SIZE = 30;
    /**
     * 如果一个线程处在空闲状态的时间超过了该属性值，就会因为超时而退出
     */
    private static final Long KEEP_ALIVE_TIME = 100L;

    /**
     * 最大阻塞队列
     */
    private static final Integer DEQUE_MAX_SIZE = 10000;

    private final ConcurrentHashMap<Integer, ThreadPoolExecutor> threadMap;

    private ThreadPoolFactory() {
        threadMap = new ConcurrentHashMap<>();
    }

    public static ThreadPoolFactory getInstance() {
        return LazyThreadPoolFactoryHolder.instance;
    }

    private static class LazyThreadPoolFactoryHolder {
        public static ThreadPoolFactory instance = new ThreadPoolFactory();
    }

    /**
     * 执行任务
     *
     * @param runnable 要执行的线程
     * @param threadType 线程类型
     */
    public static void execute(Runnable runnable, ThreadType<?> threadType) {
        execute(runnable, threadType, new ThreadPoolExecutor.CallerRunsPolicy());
    }

    /**
     * 执行任务
     *
     * @param runnable 要执行的线程
     * @param threadType 线程类型
     * @param handler 拒绝执行处理器(拒绝策略)，由于达到线程边界和队列容量而阻塞执行时使用的处理程序,常用传值如下:<br>
     *            (1)new ThreadPoolExecutor.AbortPolicy()-- 终止策略，线程池会抛出异常并终止执行，它是默认的拒绝策略;<br>
     *            (2)new ThreadPoolExecutor.CallerRunsPolicy()-- 把任务交给当前线程来执行;<br>
     *            (3)new ThreadPoolExecutor.DiscardPolicy()-- 忽略此任务(最新的任务);<br>
     *            (4)new ThreadPoolExecutor.DiscardOldestPolicy()-- 忽略最早的任务(最先加入队列的任务);<br>
     */
    public static void execute(Runnable runnable, ThreadType<?> threadType, RejectedExecutionHandler handler) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolFactory().threadMap.get(threadType.type());
        if (null == threadPoolExecutor) {
            threadPoolExecutor = ThreadPoolFactory.getInstance().getThreadPool(threadType, TimeUnit.SECONDS, handler);
        }
        threadPoolExecutor.execute(runnable);
    }

    /**
     * 关闭线程池
     */
    public void shutdown(ThreadType<?> threadType) {
        ThreadPoolExecutor threadPoolExecutor = threadMap.get(threadType.type());
        if (null != threadPoolExecutor) {
            threadPoolExecutor.shutdown();
        }
    }

    /**
     * 获取线程程<br>
     * 工作队列，在执行任务之前用于保存任务的队列，常用传值如下:<br>
     * （1）new SynchronousQueue()-- 创建阻塞队列;<br>
     * （2）new LinkedBlockingDeque<>(dequeMaxSize)-- 创建阻塞队列并设置最大值的队列,按FIFO(先进先出);<br>
     * 
     * @param type 线程类型
     * @param timeUnit keepAliveTime 参数的时间单位
     * 
     * @param handler 拒绝执行处理器(拒绝策略)，由于达到线程边界和队列容量而阻塞执行时使用的处理程序,常用传值如下:<br>
     *            (1)new ThreadPoolExecutor.AbortPolicy()-- 终止策略，线程池会抛出异常并终止执行，它是默认的拒绝策略;<br>
     *            (2)new ThreadPoolExecutor.CallerRunsPolicy()-- 把任务交给当前线程来执行;<br>
     *            (3)new ThreadPoolExecutor.DiscardPolicy()-- 忽略此任务(最新的任务);<br>
     *            (4)new ThreadPoolExecutor.DiscardOldestPolicy()-- 忽略最早的任务(最先加入队列的任务);<br>
     */
    public ThreadPoolExecutor getThreadPool(ThreadType<?> type, TimeUnit timeUnit, RejectedExecutionHandler handler) {
        if (null == threadMap.get(type.type())) {
            synchronized (ThreadPoolFactory.class) {
                if (null == threadMap.get(type.type())) {
                    Integer cps = Objects.isNull(type.corePoolSize()) ? CORE_POOL_SIZE : type.corePoolSize();
                    Long kat = Objects.isNull(type.keepAliveTime()) ? KEEP_ALIVE_TIME : type.keepAliveTime();
                    Integer mps = Objects.isNull(type.maximumPoolSize()) ? MAXIMUM_POOL_SIZE : type.maximumPoolSize();
                    Integer queueSize = Objects.isNull(type.queueSize()) ? DEQUE_MAX_SIZE : type.queueSize();
                    threadMap.put(type.type(), new ThreadPoolExecutor(cps, mps, kat, timeUnit, new LinkedBlockingDeque<>(queueSize),
                        /*new CustomizableThreadFactory((type.message() + BaseConstant.ASCII_2D)),*/ handler));
                }
            }
        }
        return threadMap.get(type.type());
    }
}
