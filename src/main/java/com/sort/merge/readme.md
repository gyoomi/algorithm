## 5、归并排序（Merge Sort）
将两个的有序数列合并成一个有序数列，我们称之为"归并"。

归并排序(Merge Sort)就是利用归并思想对数列进行排序。根据具体的实现，归并排序包括"从上往下"和"从下往上"2种方式。
### 5.1 算法实现
1. 从下往上的归并排序：将待排序的数列分成若干个长度为1的子数列，然后将这些数列两两合并；得到若干个长度为2的有序数列，再将这些数列两两合并；得到若干个长度为4的有序数列，再将它们两两合并；直接合并成一个数列为止。这样就得到了我们想要的排序结果。(参考下面的图片)

2. 从上往下的归并排序：它与"从下往上"在排序上是反方向的。它基本包括3步：
   ① 分解 -- 将当前区间一分为二，即求分裂点 mid = (low + high)/2;
   ② 求解 -- 递归地对两个子区间a[low...mid] 和 a[mid+1...high]进行归并排序。递归的终结条件是子区间长度为1。
   ③ 合并 -- 将已排序的两个子区间a[low...mid]和 a[mid+1...high]归并为一个有序的区间a[low...high]。
### 5.2 算法图解
![](./asserts/001.png)
### 5.3 算法实现
```
public static void main(String[] args) {
        int[] arr = {-9, 12, 8, 55, 84, -90, 25, 28, 25, 3};
        mergeSortUp2Down(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSortUp2Down(int[] arr, int start, int end) {
        if (null == arr || start >= end) {
            return;
        }
        int mid = (end + start) / 2;
        mergeSortUp2Down(arr, start, mid);
        mergeSortUp2Down(arr, mid + 1, end);
        merge(arr, start, mid ,end);
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= end) {
            temp[k++] = arr[j++];
        }

        for (int l = 0; l < k; l++) {
            arr[start + l] = temp[l];
        }
        temp = null;
    }
```
### 5.4 其他
自下而上的方式实现：


