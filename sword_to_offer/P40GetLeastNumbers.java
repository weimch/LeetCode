package sword_to_offer;

import java.util.Arrays;

/**
 * P40GetLeastNumbers
 */
public class P40GetLeastNumbers {


    // int parition(int[] arr, int start, int end){
    //     // 选择第一个值
    //     int left = start, right = end;
    //     int split_val = arr[left]; // 小于split放置在左边, 大于split元素放置在右边
    //     while(left < right){
    //         while(left < right && arr[right] > split_val){
    //             right --;
    //         }
    //         arr[left] = arr[right];
    //         while(left < right && arr[left] <= split_val){
    //             left ++;
    //         }
    //         arr[right] = arr[left];
    //     }
    //     arr[left] = split_val;
    //     return left;
    // }
    // public int[] getLeastNumbers(int[] arr, int k) {
    //     // 快速排序的变体, 选择第一个值, 将arr划分为小于以及大于该值的部分, 返回该值的下标
    //     // 如果只有返回下标等于中间下标, 才返回该下标所对应的值
    //     // 否则, 如果返回下标大于中间下标, 则移动左边界, 否则移动右边界
    //     if(k <= 0) return new int[]{};
    //     int start = 0, end = arr.length - 1;
    //     int idx = parition(arr, start, end);
    //     k -= 1;
    //     while(idx != k){
    //         if(idx < k){
    //             start = idx + 1;    
    //         }else if(idx > k){
    //             end = idx - 1;
    //         }
    //         idx = parition(arr, start, end);
    //     }
    //     int[] ans = Arrays.copyOfRange(arr, 0, k + 1);
    //     return ans;
    // }
    void sink(int[] heap, int node){
        int left = node * 2 + 1;
        int right = node * 2 + 2;
        if(left >= heap.length) return ;
        // 在left和right之间选择一个最大值
        int max_subnode = left;
        if(right < heap.length && heap[left] < heap[right]){
            max_subnode = right;
        }
        // 在max_node和node之间选择一个最大值
        if(heap[max_subnode] < heap[node]) return;
        // 交换node和max_node
        int tmp = heap[node];
        heap[node] = heap[max_subnode];
        heap[max_subnode] = tmp;
        // 发生交换, 需要检查其子树是否需要交换
        sink(heap, max_subnode);
    }
    void buildHeap(int[] heap){
        for(int i = heap.length / 2 - 1; i >= 0; i --){
            sink(heap, i);
        }
    }
    public int[] getLeastNumbers(int[] arr, int k) {
        // 使用最大堆的实现, 最大堆保持容量为k
        // 首先使用arr前k个元素建立最大堆, 然后将剩余元素依次替换最大堆第一个元素, 然后重新建立最大堆
        if(k <= 0) return new int[]{};
        int[] heap = Arrays.copyOf(arr, k);
        buildHeap(heap);
        for(int i = k; i < arr.length; i ++){
            // 如果当前值小于最大堆的堆顶, 则交换, 继续建立最大堆
            if(heap[0] > arr[i]){
                int tmp = heap[0];
                heap[0] = arr[i];
                arr[i] = tmp;
                buildHeap(heap);
            }
        }
        return heap;
    }

    public static void main(String[] args) {
        P40GetLeastNumbers sol = new P40GetLeastNumbers();
        // sol.getLeastNumbers(new int[]{0,0,0,2,0,5}, 0);
        // sol.getLeastNumbers(new int[]{0,0,2,3,2,1,1,2,0,4}, 10);
        sol.getLeastNumbers(new int[]{3, 2, 1}, 2);
    }
}