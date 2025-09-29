package algorytms.tree.horisontalTree;

import java.util.List;

public class Main {

	public static void main(String[] args) {

		TreeNode node6 = new TreeNode("6", List.of());

		TreeNode node5 = new TreeNode("5", List.of());

		TreeNode node4 = new TreeNode("4", List.of());

		TreeNode node3 = new TreeNode("3", List.of(node4, node5));

		TreeNode node2 = new TreeNode("2", List.of());

		TreeNode node1 = new TreeNode("1", List.of(node2, node3, node6));

		System.out.println(node1.toString());
	}
}
