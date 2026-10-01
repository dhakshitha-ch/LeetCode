class Solution {

    class Tuple {
        TreeNode node;
        int row;
        int col;

        Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();

        Queue<Tuple> q = new LinkedList<>();

        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {

            Tuple current = q.poll();

            TreeNode node = current.node;
            int row = current.row;
            int col = current.col;

            map.putIfAbsent(col, new TreeMap<>());

            map.get(col).putIfAbsent(row, new ArrayList<>());

            map.get(col).get(row).add(node.val);

            if (node.left != null) {
                q.offer(new Tuple(node.left, row + 1, col - 1));
            }

            if (node.right != null) {
                q.offer(new Tuple(node.right, row + 1, col + 1));
            }
        }

        for (Map<Integer, List<Integer>> rows : map.values()) {

            List<Integer> column = new ArrayList<>();

            for (List<Integer> values : rows.values()) {

                Collections.sort(values);

                column.addAll(values);
            }

            ans.add(column);
        }

        return ans;
    }
}