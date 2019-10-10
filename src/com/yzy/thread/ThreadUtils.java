package com.yzy.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * Date: 2019-09-17
 *
 * @author youzhiyong
 */
public class ThreadUtils {

    /**
     * 线程sleep
     * @param time
     */
    public static void sleep(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 打印所有线程信息
     */
    public static void printAllThreadStatus() {
        printThreadStatus(true);
    }

    public static void printThreadStatus(boolean printSystemThread) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        Arrays.stream(threadInfos).forEach((info) -> {
            if (!printSystemThread) {
                if (info.getThreadId() > 6) {
                    System.out.println("ThreadId:" + info.getThreadId() + " - ThreadName:" + info.getThreadName() + " - ThreadState:" + info.getThreadState());
                }
            } else {
                System.out.println("ThreadId:" + info.getThreadId() + " - ThreadName:" + info.getThreadName() + " - ThreadState:" + info.getThreadState());
            }

        });

    }
}
