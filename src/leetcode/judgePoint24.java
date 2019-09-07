package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class judgePoint24 {
    @Test
    public void test() {
        System.out.println(judgePoint24opstr(new int[]{4, 6, 3, 7}));
        System.out.println(judgePoint24opbool(new int[]{4, 6, 3, 7}));
    }

    public List<String> judgePoint24opstr(int[] nums) {

        List<Double> res = new ArrayList<>();
        List<String> result = new ArrayList<>();
        List<String> nowRes = new ArrayList<>();
        for (int i : nums) {
            res.add((double) i);
            nowRes.add(String.valueOf(i));
        }

        partition(res, nowRes, result);
        return result;
    }

    private void partition(List<Double> nums, List<String> nowRes, List<String> result) {
        if (nums.size() == 0) {
            return;
        }
        if (nums.size() == 1) {
            if (Math.abs(nums.get(0) - 24) < 1e-6) {
                result.add(nowRes.get(0));
            }
        }

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                // 选择其中任意两个进行运算
                //保证这两个不相等
                if (i != j) {
                    ArrayList<Double> nums2 = new ArrayList<>();
                    ArrayList<String> nowRes2 = new ArrayList<>();
                    //对非被选中的，直接加入
                    for (int k = 0; k < nums.size(); k++) {
                        if (k != i && k!=j) {
                            nums2.add(nums.get(k));
                            nowRes2.add(nowRes.get(k));
                        }
                    }
                    //对被选中的运算
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && j > i) {
                            continue;
                        } else if (k == 0) {
                            nums2.add(nums.get(i) + nums.get(j));
                            nowRes2.add(
                                    '(' + nowRes.get(i) + '+' + nowRes.get(j) + ')');
                            partition(nums2, nowRes2, result);
                            nums2.remove(nums2.size() - 1);
                            nowRes2.remove(nowRes2.size() - 1);
                        } else if (k == 1) {
                            nums2.add(nums.get(i) * nums.get(j));
                            nowRes2.add(
                                    "" + nowRes.get(i) + '*' + nowRes.get(j) + "");
                            partition(nums2, nowRes2, result);
                            nums2.remove(nums2.size() - 1);
                            nowRes2.remove(nowRes2.size() - 1);
                        } else if (k == 2) {
                            nums2.add(nums.get(i) - nums.get(j));
                            nowRes2.add(
                                    '(' + nowRes.get(i) + '-' + nowRes.get(j) + ')');
                            partition(nums2, nowRes2, result);
                            nums2.remove(nums2.size() - 1);
                            nowRes2.remove(nowRes2.size() - 1);
                        } else if (k == 3 && nums.get(j) != 0) {
                            nums2.add(nums.get(i) / nums.get(j));
                            nowRes2.add(
                                    "" + nowRes.get(i) + '/' + nowRes.get(j) + "");
                            partition(nums2, nowRes2, result);
                            nums2.remove(nums2.size() - 1);
                            nowRes2.remove(nowRes2.size() - 1);
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
        return;
    }

    public boolean judgePoint24opbool(int[] nums) {

        List<Double> res = new ArrayList<>();
        for (int i : nums) {
            res.add((double)i);
        }

        return partition(res);
    }

    private boolean partition(List<Double> nums) {
        if (nums.size() == 0) return false;
        if (nums.size() == 1)
            return Math.abs(nums.get(0) - 24) < 1e-6;//1e-6(也就是0.000001)叫做epsilon，用来抵消浮点运算中因为误差造成的相等无法判断的情况
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                List<Double> nums2 = new ArrayList<>();
                if (i != j) {
                    for (int k = 0; k < nums.size(); k++) {
                        if (k != i && k != j) {
                            nums2.add(nums.get(k));
                        }
                    }
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && j > i) {
                            continue;//加法和乘法满足交换律，所以不用重复计算
                        } else if (k == 0) {
                            nums2.add(nums.get(i) + nums.get(j));
                        } else if (k == 1) {
                            nums2.add(nums.get(i) * nums.get(j));
                        } else if (k == 2) {
                            nums2.add(nums.get(i) - nums.get(j));
                        } else if (nums.get(j) != 0) {
                            nums2.add(nums.get(i) / nums.get(j));
                        } else continue;
                        if (partition(nums2)) {
                            return true;
                        }
                        nums2.remove(nums2.size() - 1);//如果不等于24表示刚刚用的运算符不合适，需要回退
                    }
                }
            }
        }
        return false;
    }
}
