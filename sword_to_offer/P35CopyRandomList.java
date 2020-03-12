package sword_to_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * P35CopyRandomList
 */
public class P35CopyRandomList {
    
    static class Node{
        int val;
        Node next, random;
        Node(int val) {this.val = val;}

    }

    Map<Node, Node> visited;
    public Node copyRandomList(Node head) {
        // 使用深度优先搜索来构造该节点
        visited = new HashMap<>();
        return dfs(head);
    }

    Node dfs(Node node){
        if(node == null) return null;
        if(visited.containsKey(node)){
            return visited.get(node);
        }
        Node newNode = new Node(node.val);
        visited.put(node, newNode);
        newNode.next = dfs(node.next);
        newNode.random = dfs(node.random);
        return newNode;
    }
}