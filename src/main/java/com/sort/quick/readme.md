## 6. 快速排序（Quick Sort）
快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序

### 6.1 算法描述
快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：

- 从数列中挑出一个元素，称为 “基准”（pivot）；
- 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
- 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
### 6.2动图演示
![](./asserts/001.gif)

数组：     20 40 50 10 60   0=left  4=right 20=pivot
第一趟：   10 40 50 10 60   1=left++ 3=right--  从右边
           10 40 50 40 60   2=left++ 2=right--  从左边
           left == right ---> exit
           10 20 50 40 60
// 第二趟、第三趟、递归去排序即可

### 6.3 代码实现
```
    public static void main(String[] args) {
        int[] arr = {-9, 12, 8, 55, 84, -90, 25, 28, 25, 3};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int x = arr[left];
            while (i < j) {
                while (i < j && arr[j] >= x) {
                    j--;
                }
                if (i < j) {
                    arr[i++] = arr[j];
                }
                while (i < j && arr[i] < x) {
                    i++;
                }
                if (i < j) {
                    arr[j--] = arr[i];
                }
            }
            arr[i] = x;
            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        }
    }
```

### 6.4 其他
关于基准位的选择有很多。这里我们取得是数组第一个元素。

随机选择基准数；以中间的数作为基准数的，要实现这个方便非常方便，直接将中间的数和第一个数进行交换。





