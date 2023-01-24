/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> hm = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        hm.put(node, new Node(node.val));
        while(q.isEmpty() == false)
        {
            Node first = q.remove();
            Node firstClone = hm.get(first);
            for(Node cur : first.neighbors)
            {
                Node curClone;
                if(hm.containsKey(cur))
                {
                    curClone = hm.get(cur);
                }
                else
                {
                    q.add(cur);
                    curClone = new Node(cur.val);
                    hm.put(cur, curClone);
                }
                firstClone.neighbors.add(curClone);
            }
        }
        return hm.get(node);
    }
}