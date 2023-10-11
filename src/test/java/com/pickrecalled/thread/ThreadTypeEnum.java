package com.pickrecalled.thread;

/**
 * 线程类型枚举
 * 
 * @author shuang
 */
public enum ThreadTypeEnum implements ThreadType<ThreadTypeEnum> {

    /**
     * 推送消息主线程
     */
    PUSH_MESSAGE_MAIN_THREAD(1, 5, (Runtime.getRuntime().availableProcessors() + 1), 200L, 10000, "pushMessageManThread"),

    /**
     * 推送消息子线程
     */
    PUSH_MESSAGE_CHILD_THREAD(2, 1, (Runtime.getRuntime().availableProcessors() + 1), 200L, 10000, "pushMessageChildThread"),

    /**
     * 删除用户缓存
     */
    DELETE_USER_CACHE_THREAD(3, 1, (Runtime.getRuntime().availableProcessors() + 1), 20L, 3, "deleteUserCacheThread"),;

    /**
     * 线程类型
     */
    private final Integer type;

    /**
     * 线程池的基本大小
     */
    private final Integer corePoolSize;

    /**
     * 线程池中允许的最大线程数
     */
    private final Integer maximumPoolSize;

    /**
     * 一个线程处在空闲状态的时间超过了该属性值就会因为超时而退出（单位秒）
     */
    private final Long keepAliveTime;

    /**
     * 工作队列
     */
    private final Integer queueSize;

    /**
     * 线程描述
     */
    private final String message;

    ThreadTypeEnum(Integer type, Integer corePoolSize, Integer maximumPoolSize, Long keepAliveTime, Integer queueSize, String message) {
        this.type = type;
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.message = message;
        this.keepAliveTime = keepAliveTime;
        this.queueSize = queueSize;
    }

    @Override
    public ThreadTypeEnum enumObject() {
        return this;
    }

    @Override
    public Integer type() {
        return this.type;
    }

    @Override
    public String message() {
        return this.message;
    }

    @Override
    public Integer corePoolSize() {
        return this.corePoolSize;
    }

    @Override
    public Integer maximumPoolSize() {
        return this.maximumPoolSize;
    }

    @Override
    public Long keepAliveTime() {
        return this.keepAliveTime;
    }

    @Override
    public Integer queueSize() {
        return this.queueSize;
    }
}
