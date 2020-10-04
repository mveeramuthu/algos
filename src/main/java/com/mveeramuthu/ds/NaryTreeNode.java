package com.mveeramuthu.ds;

import java.util.ArrayList;
import java.util.List;

public class NaryTreeNode {
    public int value;
    public List<NaryTreeNode> children;

    public NaryTreeNode(int value) {
        this.value = value;
        this.children = new ArrayList<>();
    }
    
    public NaryTreeNode(int value, List<NaryTreeNode> children) {
        this.value = value;
        this.children = children;
    }
}
