## 贪婪算法
### 一、认识贪婪算法
#### 1. 教室调度问题
#### 2. 背包问题
#### 3. 集合覆盖问题

``` 
public class Main01Broadcast {

    public static void main(String[] args) throws Exception {
        // 1. 初始化广播台信息
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>(16);
        broadcasts.put("K1", new HashSet(Arrays.asList(new String[] {"ID","NV","UT"})));
        broadcasts.put("K2", new HashSet(Arrays.asList(new String[] {"WA","ID","MT"})));
        broadcasts.put("K3", new HashSet(Arrays.asList(new String[] {"OR","NV","CA"})));
        broadcasts.put("K4", new HashSet(Arrays.asList(new String[] {"NV","UT"})));
        broadcasts.put("K5", new HashSet(Arrays.asList(new String[] {"CA","AZ"})));

        // 2. 需要覆盖的全部地区
        HashSet<String> allAreas = new HashSet(Arrays.asList(new String[] {"ID","NV","UT","WA","MT","OR","CA","AZ"}));

        // 3. 最终所选择的广播台列表
        List<String> selects = new ArrayList<>();

        // 4. 进行运算
        Set<String> tempSet = new HashSet<>();
        String maxKey;
        while (allAreas.size() != 0) {
            maxKey = null;
            for (String key : broadcasts.keySet()) {
                tempSet.clear();
                HashSet<String> area = broadcasts.get(key);
                tempSet.addAll(area);
                // 求出2个集合的交集，此时tempSet会被赋值为交集的内容，所以使用临时变量
                tempSet.retainAll(allAreas);
                if (tempSet.size() > 0 && (null == maxKey || tempSet.size() > broadcasts.get(maxKey).size())) {
                    maxKey = key;
                }
            }
            if (null != maxKey) {
                selects.add(maxKey);
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }

        // 打印结果
        System.out.print("最优的广播站组合是：" + selects);
    }
}
```
### 二、近似算法：NP完全问题
### 三、小结
- 贪婪算法寻找局部最优解，企图以这种方式获得全局最优解。
- 对于NP完全问题，还没有找到快速解决方案。
- 面临NP完全问题时，最佳的做法是使用近似算法。
- 贪婪算法易于实现、运行速度快，是不错的近似算法。