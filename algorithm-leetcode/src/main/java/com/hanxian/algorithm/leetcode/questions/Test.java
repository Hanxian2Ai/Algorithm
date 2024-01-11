package com.hanxian.algorithm.leetcode.questions;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static class MyList {
        public List<List<Integer>> doubleList;

        public List<List<Integer>> getDoubleList() {
            return doubleList;
        }

        public void setDoubleList(List<List<Integer>> doubleList) {
            this.doubleList = doubleList;
        }
    }

    public static void main(String[] args) {
        MyList myList = new MyList();
        ArrayList<Integer> inList = new ArrayList<>();
        inList.add(1);
        inList.add(2);
        ArrayList<Integer> inList2 = new ArrayList<>();
        inList.add(4);
        inList.add(1);
        ArrayList<List<Integer>> outList = new ArrayList<>();
        outList.add(inList);
        outList.add(inList2);
        myList.setDoubleList(outList);

        myList.getDoubleList().forEach(item -> {
            item.forEach(System.out::println);
        });
    }
}
