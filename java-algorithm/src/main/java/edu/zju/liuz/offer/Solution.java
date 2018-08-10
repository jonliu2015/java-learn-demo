package edu.zju.liuz.offer;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    /**
     * 《剑指offer》
     * */
    public int Fibonacci(int n) {
        if (n<=0) return 0;
        if (n==1) return 1;
        if (n==2) return 1;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length==0) return null;
        TreeNode root;
        root = new TreeNode(pre[0]);
        int leftSize = 0;
        while(in[leftSize]!=root.val) {
            leftSize++;
        }
        int[] leftPre = new int[leftSize];
        int[] leftIn = new int[leftSize];
        int[] rightPre = new int[pre.length-1-leftSize];
        int[] rightIn = new int[pre.length-1-leftSize];
        for(int i = 0; i < leftPre.length; i++) {
            leftPre[i] = pre[i+1];
            leftIn[i] = in[i];
        }
        for(int i = 0; i < rightPre.length; i++) {
            rightPre[i] = pre[i+leftSize+1];
            leftIn[i] = in[i+leftSize+1];
        }
        root.left = reConstructBinaryTree(leftPre, leftIn);
        root.right = reConstructBinaryTree(rightPre, rightIn);
        return root;
    }

    /**
     * 如何保证长度长的是靠前的呢
     * */
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size()-1);
        return listAll;
    }
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null) return null;
        RandomListNode head = new RandomListNode(pHead.label);
        RandomListNode pTemp = pHead;
        RandomListNode temp = head;
        int size = 1;
        ArrayList<RandomListNode> arr1 = new ArrayList<>();
        ArrayList<RandomListNode> arr2 = new ArrayList<>();
        arr1.add(pTemp);
        arr2.add(temp);
        while(pTemp.next!=null) {
            size++;
            pTemp = pTemp.next;
            temp.next = new RandomListNode(pTemp.label);
            temp = temp.next;
            arr1.add(pTemp);
            arr2.add(temp);
        }
        pTemp = pHead;
        temp = head;
        while(pTemp.next!=null) {
            int index = arr1.indexOf(pTemp.random);
            temp.random = arr2.get(index);
            pTemp = pTemp.next;
            temp = temp.next;
        }
        return head;
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null) return null;
        if (pRootOfTree.left!=null) {
            pRootOfTree.left = ConvertLeft(pRootOfTree.left);
            pRootOfTree.left.right = pRootOfTree;
        }
        if (pRootOfTree.right!=null) {
            pRootOfTree.right = ConvertRight(pRootOfTree.right);
            pRootOfTree.right.left = pRootOfTree;
        }
        return pRootOfTree;
    }
    public TreeNode ConvertLeft(TreeNode node) {
        if(node.left!=null) {
            node.left = ConvertLeft(node.left);
            node.left.right = node;
        }
        if(node.right==null) return node;
        else {
            node.right = ConvertRight(node.right);
            node.right.left = node;
        }
        while(node.right!=null) {
            node = node.right;
        }
        return node;
    }
    public TreeNode ConvertRight(TreeNode node) {
        if(node.right!=null) {
            node.right = ConvertRight(node.right);
            node.right.left = node;
        }
        if(node.left==null) return node;
        else {
            node.left = ConvertLeft(node.left);
            node.left.right = node;
        }
        while(node.left!=null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] a) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        System.out.println(new Solution().reConstructBinaryTree(pre, in));
    }
}
