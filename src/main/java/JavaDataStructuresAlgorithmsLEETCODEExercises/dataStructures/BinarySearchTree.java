package JavaDataStructuresAlgorithmsLEETCODEExercises.dataStructures;

import java.util.*;
import java.util.LinkedList;

public class BinarySearchTree {
	private Node root;

	class Node {
		public int value;
		public Node left;
		public Node right;

		Node(int value) {
			this.value = value;
		}
	}

	public static boolean equals(Node n1, Node n2) {
		if (n1 == null && n2 == null) {
			return true;
		}

		if (n1 == null || n2 == null) {
			return false;
		}

		if (n1.value != n2.value) {
			return false;
		}
		return equals(n1.left, n2.left) && equals(n1.right, n2.right);
	}



	public Node getRoot() {
		return root;
	}

	public boolean insert(int value) {
		Node newNode = new Node(value);
		if (root == null) {
			root = newNode;
			return true;
		}
		Node temp = root;
		while (true) {
			if (newNode.value == temp.value) return false;
			if (newNode.value < temp.value) {
				if (temp.left == null) {
					temp.left = newNode;
					return true;
				}
				temp = temp.left;
			} else {
				if (temp.right == null) {
					temp.right = newNode;
					return true;
				}
				temp = temp.right;
			}
		}
	}

	public boolean contains(int value) {
		Node temp = root;
		if (root == null) {
			return false;
		}
		if (root.value == value) {
			return true;
		}

		while (temp != null) {
			if (temp.value > value) {
				if (temp.left == null) {
					return false;
				}
				if (temp.left.value == value) {
					return true;
				} else {
					temp = temp.left;
				}
			} else {
				if (temp.right == null) {
					return false;
				}
				if (temp.right.value == value) {
					return true;
				} else {
					temp = temp.right;
				}
			}
		}
		return false;
	}

	// рекурсивный contains
	private boolean rContains(Node currentNode, int value) {
		if (currentNode == null) return false;

		if (currentNode.value == value) return true;

		if (value < currentNode.value) {
			return rContains(currentNode.left, value);
		} else {
			return rContains(currentNode.right, value);
		}
	}

	public boolean rContains(int value) {
		return rContains(root, value);
	}

	// рекуривный инсерт

	private Node rInsert(Node currentNode, int value) {
		if (currentNode == null) return new Node(value);

		if (value < currentNode.value) {
			currentNode.left = rInsert(currentNode.left, value);
		} else if (value > currentNode.value) {
			currentNode.right = rInsert(currentNode.right, value);
		}

		return currentNode;

	}

	public void rInsert(int value) {
		if (root == null) root = new Node(value);
		rInsert(root, value);
	}

	// рекурсивный делит
	public int minValue(Node currentNode) {
		while (currentNode.left != null) {
			currentNode = currentNode.left;
		}
		return currentNode.value;
	}


	private Node deleteNode(Node currentNode, int value) {
		// Base case, tree is empty
		if (currentNode == null) return null;

		// Recurse down the tree
		if (value < currentNode.value) {
			// If less, go left
			currentNode.left = deleteNode(currentNode.left, value);
		} else if (value > currentNode.value) {
			// If more, go right
			currentNode.right = deleteNode(currentNode.right, value);
		} else {
			// Value is same as current's value, node to delete
			if (currentNode.left == null && currentNode.right == null) {
				// Node is a leaf node
				return null;
			} else if (currentNode.left == null) {
				// Node has only right child
				currentNode = currentNode.right;
			} else if (currentNode.right == null) {
				// Node has only left child
				currentNode = currentNode.left;
			} else {
				// Node has two children
				int subTreeMin = minValue(currentNode.right);
				// Replace with min in right subtree
				currentNode.value = subTreeMin;
				// Delete the minimum in right subtree
				currentNode.right = deleteNode(currentNode.right, subTreeMin);
			}
		}
		// Return the modified tree
		return currentNode;
	}

	public List<Integer> breadthFirstSearch() {
		Node current = root;
		Queue<Node> queue = new LinkedList<>();

		List<Integer> result = new ArrayList<>();
		queue.add(current);

		while (!queue.isEmpty()) {
			current = queue.remove();
			result.add(current.value);
			if (current.left != null) {
				queue.add(current.left);
			}
			if (current.right != null) {
				queue.add(current.right);
			}
		}
		return result;
	}

	public ArrayList<Integer> DFSPreOrder() {
		// Create an ArrayList to store the node values in the traversal order
		ArrayList<Integer> results = new ArrayList<>();

		// Define a local inner class named Traverse for recursive traversal
		class Traverse {
			// Constructor for Traverse class taking a Node as an argument
			Traverse(Node currentNode) {
				// Add the current node's value to the results list
				results.add(currentNode.value);

				// If the current node has a left child, recursively
				// traverse the left subtree
				if (currentNode.left != null) {
					new Traverse(currentNode.left);
				}

				// If the current node has a right child, recursively
				// traverse the right subtree
				if (currentNode.right != null) {
					new Traverse(currentNode.right);
				}
			}
		}

		// Start the pre-order traversal by creating a new
		// instance of Traverse with the root node
		new Traverse(root);

		// Return the results list containing the node values
		// in the pre-order traversal order
		return results;
	}

	public ArrayList<Integer> DFSInOrder() {
		ArrayList<Integer> results = new ArrayList<>();

		class Traverse {
			Traverse(Node currentNode) {
				if (currentNode.left != null) {
					new Traverse(currentNode.left);
				}
				results.add(currentNode.value);
				if (currentNode.right != null) {
					new Traverse(currentNode.right);
				}
			}
		}

		new Traverse(root);
		return results;
	}

	public boolean isValidBST() {
		ArrayList<Integer> nodeValues = DFSInOrder();
		for (int i = 1; i < nodeValues.size(); i++) {
			if (nodeValues.get(i) <= nodeValues.get(i - 1)) {
				return false;
			}
		}
		return true;
	}


	public Integer kthSmallest(int k) {
		// Create an empty stack to keep track of nodes
		Stack<Node> stack = new Stack<>();

		// Start from the root of the BST
		Node node = this.root;

		// Continue as long as there are unprocessed nodes
		while (!stack.isEmpty() || node != null) {

			// Traverse to the leftmost node of the current subtree,
			// pushing all the nodes onto the stack
			while (node != null) {
				stack.push(node);
				node = node.left;
			}

			// Process nodes from the stack when no left children
			node = stack.pop();

			// Decrement k after each processed node
			k -= 1;

			// If k reaches 0, return the current node value
			if (k == 0) {
				return node.value;
			}

			// Move to the right child after a node has been processed
			node = node.right;
		}

		// Return null if fewer than k nodes in the tree
		return null;
	}

}