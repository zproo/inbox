package bobo.algo.heap_04.max_heap_class_basic_02;

import java.util.*;

/*
* 最大堆
* */
public class MaxHeap<Item> {

    private Item[] data; // 堆是一棵完全二叉树，使用数组存储
    private int count; // 堆中元素个数

    // 构造函数, 构造一个空堆, 可容纳capacity个元素
    public MaxHeap(int capacity){
        data = (Item[])new Object[capacity+1];
        count = 0;
    }

    // 返回堆中的元素个数
    public int size(){
        return count;
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty(){
        return count == 0;
    }

    // 测试 MaxHeap
    public static void main(String[] args) {

        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
        System.out.println(maxHeap.size());
    }
}
