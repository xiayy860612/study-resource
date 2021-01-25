# 线性结构

## 结题思路

### 双指针 --- 左右指针向中间夹逼

通过移动左右指针来确定范围

```java
class Solution {
    public int leftRightPoints(int[] array) {
        int l = 0;
        int r = array.length - 1;
        int result = 0;
        while (l < r) {
            // ++l or --r by condition
        }
        return result;
    }
}
```

### 双指针 --- 快慢指针

快指针遍历元素, 慢指针指向的位置用于写结果

```java
public class Solution {
    public void FastSlowPoints(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; ++fast) {
            if (nums[fast] != 0) {
                int tmp = nums[slow];
                // write result to slow, then ++slow
                nums[slow++] = nums[fast];
                nums[fast] = tmp;
            }
        }
    }

    public boolean FastSlowPoints2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }
        return true;
    }

}
```

### 双指针 --- 相邻指针移动

相邻指针指向要进行处理的元素, 处理之后向后移动

```java
public class ReverseList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        // 定义相邻的指针
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            // 对相邻指针指向的元素进行处理
            ListNode tmp = cur.next;
            cur.next = pre;
            // 处理完毕后, 相邻指针向后移动
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
```

## 相关练习

- [两数之和](https://leetcode-cn.com/problems/two-sum/)
- [盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/)
- [移动零](https://leetcode-cn.com/problems/move-zeroes/)
- [爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)
- [三数之和](https://leetcode-cn.com/problems/3sum/)
- [反转链表](https://leetcode.com/problems/reverse-linked-list/)
- [两两交换链表中的节点](https://leetcode.com/problems/swap-nodes-in-pairs)
- [环形链表](https://leetcode.com/problems/linked-list-cycle)
- [环形链表 II](https://leetcode.com/problems/linked-list-cycle-ii)
- [K 个一组翻转链表](https://leetcode.com/problems/reverse-nodes-in-k-group/)
- [删除排序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)
- [旋转数组](https://leetcode-cn.com/problems/rotate-array/)

## 参考

- [Java 源码分析（ArrayList）](http://developer.classpath.org/doc/java/util/ArrayList-source.html)
- [Linked List 的标准实现代码](http://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/)
- [Linked List 示例代码](http://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/code/LinkedList.java)
- [Java 源码分析（LinkedList）](http://developer.classpath.org/doc/java/util/LinkedList-source.html)
- [LRU Cache - Linked list： LRU 缓存机制](http://leetcode-cn.com/problems/lru-cache)
- [Redis - Skip List：跳跃表、为啥 Redis 使用跳表（Skip List）而不是使用 Red-Black？](http://www.zhihu.com/question/20202931)