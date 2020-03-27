package com.demo.tool.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangjian
 * @version 1.0
 * @date: 2020年01月07日 11:07
 */
public class TwoSum {

    /**
     * 在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。
     * 如果它存在，那我们已经找到了对应解，并立即将其返回。
     *
     * 复杂度分析：
     *
     * 时间复杂度：O(n)O(n)，
     * 我们只遍历了包含有 nn 个元素的列表一次。在表中进行的每次查找只花费 O(1)O(1) 的时间。
     *
     * 空间复杂度：O(n)O(n)，
     * 所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储 nn 个元素。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> lookup = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (lookup.containsKey(target - nums[i])) {
                res = new int[] { lookup.get(target - nums[i]), i };
                break;
            } else {
                lookup.put(nums[i], i);
            }
        }
        return res;
    }

}
