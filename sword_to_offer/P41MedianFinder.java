package sword_to_offer;

import java.util.ArrayList;
import java.util.List;

/**
 * P41MedianFinder
 */
public class P41MedianFinder {
    // 使用最大堆存储左半部分元素
    // 使用最小堆存储右半部分元素
    // 使用数据流的下标表示当前应该插入哪个部分, 奇数插入最大堆, 偶数插入最小堆

    List<Integer> maxHeap, minHeap;
    int elem_num;

    public P41MedianFinder() {
        maxHeap = new ArrayList<>();
        minHeap = new ArrayList<>();
        elem_num = 0;
    }
    
    public void addNum(int num) {
        elem_num ++;
        // 插入数据时, 需要保持最大堆的最大值总是小于最小堆的最小值
        if((elem_num & 0x1) == 1){
            // 插入最大堆, 需要判断当前元素是否大于当前最小堆最小值, 把最小堆的最小值拿出来插入最大堆, 把新元素放入到最小堆中
            if(minHeap.size() > 0 && minHeap.get(0) < num){
                maxHeap.add(minHeap.get(0));
                minHeap.set(0, num);
                buildHeap(true);
                buildHeap(false);
            }else{
                maxHeap.add(num);
                buildHeap(true);
            }
        }else{
            // 插入最小堆, 需要判断当前元素是否小于当前最大堆最大值, 将最大堆的最大值拿出来插入最小堆, 把新元素放入最大堆中
            if(maxHeap.size() > 0 && maxHeap.get(0) > num){
                minHeap.add(maxHeap.get(0));
                maxHeap.set(0, num);
                buildHeap(true);
                buildHeap(false);
            }else{
                minHeap.add(num);
                buildHeap(false);
            }
        }
    }
    
    void sink(List<Integer> heap, int nodeidx, boolean max_heap){
        int left = nodeidx * 2 + 1;
        int right = nodeidx * 2 + 2;
        if(left >= heap.size()) return;
        // left和right中, 选择最小/最大值
        int selectidx = left;
        if(max_heap) {
            // 选择最大值
            if(right < heap.size() && heap.get(selectidx) < heap.get(right)){
                selectidx = right;
            }
        }else{
            // 选择最小值
            if(right < heap.size() && heap.get(selectidx) > heap.get(right)){
                selectidx = right;
            }
        }
        // selectidx和nodeidx中选择最大最小值
        if(max_heap){
            if(heap.get(nodeidx) > heap.get(selectidx)) return;
            // 交换并递归
            int node = heap.get(nodeidx);
            heap.set(nodeidx, heap.get(selectidx));
            heap.set(selectidx, node);
            sink(heap, selectidx, max_heap);
        }else{
            // 交换并递归
            if(heap.get(nodeidx) < heap.get(selectidx)) return;
            int node = heap.get(nodeidx);
            heap.set(nodeidx, heap.get(selectidx));
            heap.set(selectidx, node);
            sink(heap, selectidx, max_heap);
        }
    }

    void buildHeap(boolean max_heap){
        List<Integer> heap = max_heap ? maxHeap : minHeap;
        for(int i = heap.size() / 2 - 1; i >= 0; i --){
            sink(heap, i, max_heap);
        }
    }
    
    public double findMedian() {
        if(elem_num <= 0) return 0.0;
        if(elem_num == 1) return maxHeap.get(0);
        return (elem_num & 0x1) == 0 ? (maxHeap.get(0) + minHeap.get(0)) / 2.0 : maxHeap.get(0);
    }

    public static void main(String[] args) {
        P41MedianFinder medianFinder = new P41MedianFinder();
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        medianFinder.addNum(6);
        medianFinder.addNum(1);
        medianFinder.addNum(4);
        medianFinder.findMedian();
    }
}