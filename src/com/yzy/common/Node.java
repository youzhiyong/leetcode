package com.yzy.common;

import java.util.List;

/**
 * Description: N叉树
 * Date: 2019-10-24
 *
 * @author youzhiyong
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val,List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
