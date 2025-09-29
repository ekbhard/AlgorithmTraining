package algorytms;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class TreeRender {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("The input data size is not correct");
			System.exit(1);
		}

		String inputFileName = args[0];
		String outputFileName = args[1];
		
		try {
			String treeString = readInputFile(inputFileName);
			System.out.println("String was " + treeString);
//			TreeNode root = TreeParser.parseTree("(1 (2 (4 5 6 (7) 108 (9)) 3))");
			TreeNode root = TreeParser.parseTree(treeString);
			String renderedTree = TreeVisualizer.visualizeTree(root);
			writeOutputFile(outputFileName, renderedTree);
			System.out.println("Tree rendered successfully.");
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
			System.exit(1);
		}
	}

	private static String readInputFile(String fileName) throws IOException {
		StringBuilder content = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = reader.readLine()) != null) {
				content.append(line);
			}
		}
		return content.toString();
	}

	private static void writeOutputFile(String fileName, String content) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			writer.write(content);
		}
	}
}

class TreeNode {
	List<String> values;
	List<TreeNode> children;

	TreeNode() {
		this.values = new ArrayList<>();
		this.children = new ArrayList<>();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TreeNode treeNode = (TreeNode) o;
		return Objects.equals(values, treeNode.values) && Objects.equals(children, treeNode.children);
	}

	@Override
	public int hashCode() {
		return Objects.hash(values, children);
	}
}

class TreeParser {
	private static int index = 0;

	public static TreeNode parseTree(String s) {
		index = 0;
		return parseTreeHelper(s);
	}

	private static TreeNode parseTreeHelper(String s) {
		TreeNode node = new TreeNode();
		StringBuilder value = new StringBuilder();

		while (index < s.length() && s.charAt(index) != '(' && s.charAt(index) != ')') {
			if (s.charAt(index) != ' ' || value.length() > 0) {
				value.append(s.charAt(index));
			}
			index++;
			if (index < s.length() && (s.charAt(index) == ' ' || s.charAt(index) == '(' || s.charAt(index) == ')') && value.length() > 0) {
				node.values.add(value.toString().trim());
				value = new StringBuilder();
			}
		}

		if (value.length() > 0) {
			node.values.add(value.toString().trim());
		}

		if (index < s.length() && s.charAt(index) == '(') {
			index++; // skip '('
			while (index < s.length() && s.charAt(index) != ')') {
				node.children.add(parseTreeHelper(s));
			}
			if (index < s.length()) index++; // skip ')'
		}

		return node;
	}
}

class TreeVisualizer {
	public static String visualizeTree(TreeNode root) {
		StringBuilder builder = new StringBuilder();
		visualizeTreeHelper(builder, root, "", true);
		return builder.toString();
	}

	private static void visualizeTreeHelper(StringBuilder builder, TreeNode node, String prefix, boolean isLast) {
		builder.append(prefix);

		for (int i = 0; i < node.values.size(); i++) {
			builder.append(node.values.get(i));
			if (i < node.values.size() - 1) {
				builder.append(System.lineSeparator()).append(prefix);
			}
		}

		if (!node.children.isEmpty()) {
			builder.append("---+").append(System.lineSeparator());
			for (int i = 0; i < node.children.size(); i++) {
				boolean lastChild = (i == node.children.size() - 1);
				visualizeTreeHelper(builder, node.children.get(i),
						prefix + (isLast ? "    " : "|   "),
						lastChild);
			}
		} else {
			builder.append(System.lineSeparator());
		}
	}
}
