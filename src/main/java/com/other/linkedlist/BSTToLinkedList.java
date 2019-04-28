package com.other.linkedlist;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/4/23 22:28
 */
public class BSTToLinkedList {

    public static void main(String[] args) throws Exception {
        Node<Integer, Object> root = new Node<Integer, Object>(10, null);
        root.left = new Node<Integer, Object>(8, null);
        root.right = new Node<Integer, Object>(12, null);
        root.left.left = new Node<Integer, Object>(6, null);
        root.left.right = new Node<Integer, Object>(9, null);
        Node rootToUse = convert(root);
        System.out.println(rootToUse);
    }


    /**
     *                   10
     *                 /     \
     *              8          12
     *             / \        /  \
     *           5    9    11     15
     *                              \
     *                               17
     *
     * @param root
     * @return
     */
    public static Node convert(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            // 先转换左子树，获得转换后的头指针
            Node left = convert(root.left);
            // 获得指向左子树的最后一个元素的指针
            while (left.right != null) {
                left = left.right;
            }
            // 与root链接，注意双向
            root.left = left;
            left.right = root;
        }
        if (root.right != null) {
            // 同理，转换右子树
            Node right = convert(root.right);
            // 获得指向右子树的第一个元素的指针，这里直接就是right，与root双向链接
            root.right = right;
            right.left = root;
        }

        // 最后把root指向双向链表的第一个元素再返回
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    static class Node<K, V>{
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }
}
