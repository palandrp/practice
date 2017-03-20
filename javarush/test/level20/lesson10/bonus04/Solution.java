package com.javarush.test.level20.lesson10.bonus04;

import java.io.*;
import java.util.*;

/* Свой список
Посмотреть, как реализован LinkedList.
Элементы следуют так: 1->2->3->4  и так 4->3->2->1
По образу и подобию создать Solution.
Элементы должны следовать так:
1->3->7->15
    ->8...
 ->4->9
    ->10
2->5->11
    ->12
 ->6->13
    ->14
Удалили 2 и 9
1->3->7->15
    ->8
 ->4->10
Добавили 16,17,18,19,20 (всегда добавляются на самый последний уровень к тем элементам, которые есть)
1->3->7->15
       ->16
    ->8->17
       ->18
 ->4->10->19
        ->20
Удалили 18 и 20
1->3->7->15
       ->16
    ->8->17
 ->4->10->19
Добавили 21 и 22 (всегда добавляются на самый последний уровень к тем элементам, которые есть.
Последний уровень состоит из 15, 16, 17, 19. 19 последний добавленный элемент, 10 - его родитель.
На данный момент 10 не содержит оба дочерних элемента, поэтому 21 добавился к 10. 22 добавляется в следующий уровень.)
1->3->7->15->22
       ->16
    ->8->17
 ->4->10->19
        ->21

Во внутренней реализации элементы должны добавляться по 2 на каждый уровень
Метод getParent должен возвращать элемент, который на него ссылается.
Например, 3 ссылается на 7 и на 8, т.е.  getParent("8")=="3", а getParent("13")=="6"
Строки могут быть любыми.
При удалении элемента должна удаляться вся ветка. Например, list.remove("5") должен удалить "5", "11", "12"
Итерироваться элементы должны в порядке добавления
Доступ по индексу запрещен, воспользуйтесь при необходимости UnsupportedOperationException
Должно быть наследование AbstractList<String>, List<String>, Cloneable, Serializable
Метод main в тестировании не участвует
*/
public class Solution extends AbstractList<String> implements List<String>, Cloneable, Serializable {
    private int size = 0;
    private Node root = null;

    private Node first;
    private Node current;
    private Node last;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Solution() {
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node x = first; x != null; x = x.next) {
                if (x.value == null) {
                    unlink(x);
                }
            }
        }
        for (Node x = first; x != null; x = x.next) {
            if (x.value.equals(o)) {
                unlink(x);
            }
        }
        return false;
    }

    void unlink(Node x) {
        x.value = null;

        if (x.leftLeaf != null) unlink(x.leftLeaf);
        if (x.rightLeaf != null) unlink(x.rightLeaf);

        if (x.parent != null) {
            if (x.parent.leftLeaf == x) x.parent.leftLeaf = null;
            else if (x.parent.rightLeaf == x) x.parent.rightLeaf = null;
        }

        if (x == current) {
            current = x.next;
        }

        if (x == last) {
                last = x.prev;
                if (x.prev != null) x.prev.next = null;
        }
        if (x == first) {
            first = x.next;
            if (x.next != null) x.next.prev = null;
        }

        if (x.prev != null && x.next != null) {
            x.next.prev = x.prev;
            x.prev.next = x.next;
        }
        size--;
        modCount++;
    }

    @Override
    public boolean add(String s) {
        linkLast(s);
        return true;
    }

    void linkLast(String s) {
        Node newOne;
        if (current == null) {
            newOne = new Node(s, root);
            if (first == null) {
                first = newOne;
            } else {
                first.next = newOne;
                newOne.prev = first;
                current = first;
            }
        }
        else {
            newOne = new Node(s, current);
            if (current.leftLeaf == null) current.leftLeaf = newOne;
            else if (current.rightLeaf == null) {
                current.rightLeaf = newOne;
            }
            else {
                current = current.next;
                newOne.parent = current;
                current.leftLeaf = newOne;
            }
            last.next = newOne;
            newOne.prev = last;
        }
        last = newOne;
        size++;
        modCount++;
    }

    @Override
    public void clear() {
        for (Node x = first; x != null;) {
            Node next = x.next;
            x.value = null;
            x.parent = null;
            x.prev = null;
            x.next = null;
            x.leftLeaf = null;
            x.rightLeaf = null;
            x = next;
        }
        first = null;
        last = null;
        current = null;
        size = 0;
        modCount++;
    }

    @Override
    public int size() {
        return size;
    }



    @Override
    public Iterator<String> iterator() {
        return new Itr();
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    public String getParent(String value) {
        if (value == null) {
            for (Node x = first; x != null; x = x.next) {
                if (x.value == null) {
                    if (x.parent != null) return x.parent.value;
                }
            }
        }
        else {
            for (Node x = first; x != null; x = x.next) {
                if (value.equals(x.value)) {
                    if (x.parent != null) return x.parent.value;
                }
            }
        }
        return null;
    }

    private class Itr implements Iterator<String>{

        Node cursor = first;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public String next() {
            Node cur = cursor;
            cursor = cur.next;
            return cur.value;
        }

        @Override
        public void remove() {
            if (cursor != null) {
                Node cur = cursor;
                cursor = cur.next;
                Solution.this.remove(cur.value);
            }
        }
    }

    private class Node implements Serializable {
        String value;

        Node parent;

        Node leftLeaf;
        Node rightLeaf;

        Node next;
        Node prev;

        public Node(String value, Node parent) {
            this.value = value;
            this.parent = parent;
        }

        public Node(String value) {
            this.value = value;
        }
    }

    public static void main (String[]args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        List<String> list = new Solution();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        System.out.println("Expected 3, actual is " + ((Solution) list).getParent("8"));
        System.out.println(list);
        ((Solution) list).remove("2");
        ((Solution) list).remove("9");
        System.out.println("Удалили 2 и 9:");
        System.out.println(list);
        for (int i = 16; i < 21; i++) {
            list.add(String.valueOf(i));
        }
        System.out.println("Добавили 16,17,18,19,20");
        System.out.println(list);
        ((Solution) list).remove("18");
        ((Solution) list).remove("20");
        System.out.println("Удалили 18 и 20:");
        System.out.println(list);
        list.add("21");
        list.add("22");
        System.out.println("Добавили 21 и 22:");
        System.out.println(list);
        System.out.println("Expected null, actual is " + ((Solution) list).getParent("1"));
        System.out.println("Expected null, actual is " + ((Solution) list).getParent("2"));
        System.out.println("Expected 1, actual is " + ((Solution) list).getParent("3"));
        System.out.println("Expected 1, actual is " + ((Solution) list).getParent("4"));
        System.out.println("Expected null, actual is " + ((Solution) list).getParent("5"));
        System.out.println("Expected null, actual is " + ((Solution) list).getParent("6"));
        System.out.println("Expected 3, actual is " + ((Solution) list).getParent("7"));
        System.out.println("Expected 3, actual is " + ((Solution) list).getParent("8"));
        System.out.println("Expected null, actual is " + ((Solution) list).getParent("9"));
        System.out.println("Expected 4, actual is " + ((Solution) list).getParent("10"));
        System.out.println("Expected null, actual is " + ((Solution) list).getParent("11"));
        System.out.println("Expected null, actual is " + ((Solution) list).getParent("12"));
        System.out.println("Expected null, actual is " + ((Solution) list).getParent("13"));
        System.out.println("Expected null, actual is " + ((Solution) list).getParent("14"));
        System.out.println("Expected 7, actual is " + ((Solution) list).getParent("15"));
        System.out.println("Expected 7, actual is " + ((Solution) list).getParent("16"));
        System.out.println("Expected 8, actual is " + ((Solution) list).getParent("17"));
        System.out.println("Expected null, actual is " + ((Solution) list).getParent("18"));
        System.out.println("Expected 10, actual is " + ((Solution) list).getParent("19"));
        System.out.println("Expected null, actual is " + ((Solution) list).getParent("20"));
        System.out.println("Expected 10, actual is " + ((Solution) list).getParent("21"));
        System.out.println("Expected 15, actual is " + ((Solution) list).getParent("22"));
    }
}
