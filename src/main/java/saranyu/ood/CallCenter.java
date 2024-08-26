package saranyu.ood;

import java.util.*;

public class CallCenter {
    private static Queue<Call> callQueue = new LinkedList<>();

    public static void queueCall(Call call) {
        callQueue.add(call);
    }

    public static void runQueue() {
        while(!callQueue.isEmpty()) {
            Call call = callQueue.poll();
            call.execute();
        }
    }
}
