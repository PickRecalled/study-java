package com.pickrecalled.thread;

/**
 * 线程类型
 * 
 * @author shuang
 */
public interface ThreadType<C extends Enum> {

    /**
     * 返回线程类型对象
     */
    C enumObject();

    /**
     * 返回线程类型
     */
    Integer type();

    /**
     * 返回线程类型信息
     */
    String message();

    /**
     * 线程池的基本大小
     */
    Integer corePoolSize();

    /**
     * 线程池中允许的最大线程数
     */
    Integer maximumPoolSize();

    /**
     * 如果一个线程处在空闲状态的时间超过了该属性值，就会因为超时而退出
     */
    Long keepAliveTime();

    /**
     * 队列大小
     */
    Integer queueSize();

}
