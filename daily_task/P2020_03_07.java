package daily_task;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * P2020_03_07
 */
public class P2020_03_07 {

    static class MaxQueue {
        // 使用单队列来管理入队出队，使用双端队列管理最大值
        // 双端队列总是存储分段的最大值，且最大值总是段尾的存在，因此，只要双端队列头部和当前出队的头部相同，当前最大值前的所有值都已经被删除了
        Queue<Integer> queue;
        Deque<Integer> dequeue;

        public MaxQueue() {
            queue = new LinkedList<>();
            dequeue = new LinkedList<>();
        }
        
        public int max_value() {
            if(dequeue.isEmpty()){
                return -1;
            }
            return dequeue.getFirst();
        }
        
        public void push_back(int value) {
            while(!dequeue.isEmpty() && dequeue.getLast() < value){
                dequeue.removeLast();
            }
            dequeue.add(value);
            queue.add(value);
        }
        
        public int pop_front() {
            if(queue.isEmpty()){
                return -1;
            }
            int pop = queue.poll();
            if(pop == dequeue.getFirst()){
                dequeue.removeFirst();
            }
            return pop;
        }
    }
    

    public static void main(String[] args) {
        MaxQueue mq = new MaxQueue();
        assert -1 == mq.max_value();
        mq.push_back(1);
        mq.push_back(2);
        assert 2 == mq.max_value();
        assert 1 == mq.pop_front();
        assert 2 == mq.max_value();
    }
}