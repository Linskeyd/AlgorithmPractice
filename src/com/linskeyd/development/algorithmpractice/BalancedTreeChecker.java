package com.linskeyd.development.algorithmpractice;

import lombok.NonNull;

/**
 * Created by linskeyd on 8/23/15.
 */
public class BalancedTreeChecker {

    public BalancedTreeChecker() {
    }

    public static boolean isTreeBalanced(@NonNull final Node root) {
        final int leftHeight = getHeight(root.left, 1);

        if(leftHeight == -1) {
            return false;
        }

        final int rightHeight = getHeight(root.right, 1);

        if(rightHeight == -1) {
            return false;
        }

        return Math.abs(leftHeight - rightHeight) <= 1;
    }

    private static int getHeight(final Node node, int curHeight) {
        if(node == null) {
            return curHeight;
        }

        // We are at a non-null node, so increase our overall height by 1
        curHeight++;

        final int leftHeight = getHeight(node.left, curHeight);

        // Propagate on the unbalanced lower left sub-tree case
        if(leftHeight == -1) {
            return -1;
        }

        final int rightHeight = getHeight(node.right, curHeight);

        // Propagate on the unbalanced lower right sub-tree case
        if(rightHeight == -1) {
            return -1;
        }

        final int diff = Math.abs(leftHeight - rightHeight);

        if(diff > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight);
    }

    public static class Node {
        private final String val;
        private Node left;
        private Node right;

        @java.beans.ConstructorProperties({"val", "left", "right"})
        public Node(String val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static Node generateUnbalancedTestNodes() {

        final Node l1lrl = new Node("l1lrl", null, null);

        final Node l1lr = new Node("l1lr", l1lrl, null);

        final Node l1l = new Node("l1l", null, l1lr);

        final Node l1rr = new Node("l1rr", null, null);

        final Node l1rl = new Node("l1rl", null, null);

        final Node l1r = new Node("l1r", l1rl, l1rr);

        final Node l1 = new Node("l1", l1l, l1r);

        final Node r1rr = new Node("r1rr", null, null);

        final Node r1rl = new Node("r1rl", null, null);

        final Node r1r = new Node("r1r", r1rl, r1rr);

        final Node r1lr = new Node("r1lr", null, null);

        final Node r1ll = new Node("r1ll", null, null);

        final Node r1l = new Node("r1l", r1ll, r1lr);

        final Node r1 = new Node("r1", r1l, r1r);

        final Node root = new Node("root", l1, r1);

        return root;
    }

    public static Node generateBalancedTestNodes() {

        final Node l1lr = new Node("l1lr", null, null);

        final Node l1l = new Node("l1l", null, l1lr);

        final Node l1rr = new Node("l1rr", null, null);

        final Node l1rl = new Node("l1rl", null, null);

        final Node l1r = new Node("l1r", l1rl, l1rr);

        final Node l1 = new Node("l1", l1l, l1r);

        final Node r1rr = new Node("r1rr", null, null);

        final Node r1rl = new Node("r1rl", null, null);

        final Node r1r = new Node("r1r", r1rl, r1rr);

        final Node r1lr = new Node("r1lr", null, null);

        final Node r1ll = new Node("r1ll", null, null);

        final Node r1l = new Node("r1l", r1ll, r1lr);

        final Node r1 = new Node("r1", r1l, r1r);

        final Node root = new Node("root", l1, r1);

        return root;
    }
}
