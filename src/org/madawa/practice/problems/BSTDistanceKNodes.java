package org.madawa.practice.problems;

import org.madawa.util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BSTDistanceKNodes {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        dfs(root, null, parentMap);

        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();

        visited.add(target);
        queue.offer(null);
        queue.offer(target);

        int level = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                if (level == K) {
                    for (TreeNode n: queue) {
                        result.add(n.val);
                    }
                    return result;
                }
                queue.offer(null);
                ++level;
            } else {
                if (node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    queue.offer(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    queue.offer(node.right);
                }
                TreeNode p = parentMap.get(node);
                if (p != null && !visited.contains(p)) {
                    visited.add(p);
                    queue.offer(p);
                }
            }
        }
        return result;
    }

    public void dfs(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (node != null) {
            parentMap.put(node, parent);
            dfs(node.left, node, parentMap);
            dfs(node.right, node, parentMap);
        }
    }
}
