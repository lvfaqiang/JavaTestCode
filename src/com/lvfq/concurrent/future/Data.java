package com.lvfq.concurrent.future;

/**
 * Data
 *
 * @author lvfq
 * @date 2017/4/18 上午9:39
 * @mainFunction : 模拟回调接口
 */
public interface Data {
    String getResult() throws InterruptedException;
}
