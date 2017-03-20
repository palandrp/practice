package com.javarush.task.task36.task3604;

import java.util.TreeSet;

/*
Разбираемся в красно-черном дереве
*/
public class Solution {
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        tree.insert(0);
        RedBlackTree.Node n1 = tree.current;
        tree.insert(1);
        RedBlackTree.Node n2 = tree.current;
        tree.insert(2);
        RedBlackTree.Node n3 = tree.current;
        tree.insert(-3);
        RedBlackTree.Node n4 = tree.current;
        tree.insert(-2);
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
        System.out.println(n4);
        System.out.println(tree.current);
    }
}
