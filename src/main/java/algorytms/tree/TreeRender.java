package algorytms.tree;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TreeRender {

	static class Node {
		int value;
		List<Node> children = new ArrayList<>();

		Node(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
//		if (args.length != 2) {
//			System.err.println("Usage: java TreeRender <inputFile> <outputFile>");
//			System.exit(1);
//		}

		try {
//			String input = Files.readString(Path.of(args[0])).trim();
			String input = "(1 (2 (4 5 6 (7) 108 (9)) 3))";
			List<String> tokens = tokenize(input);
			Node root = parseTree(tokens);
			String output = render(root);
			Files.write(Path.of(args[1]), output.getBytes());
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
			System.exit(1);
		} catch (RuntimeException e) {
			System.err.println("Error parsing input: " + e.getMessage());
			System.exit(1);
		}
	}

	private static List<String> tokenize(String input) {
		List<String> tokens = new ArrayList<>();
		int i = 0;
		while (i < input.length()) {
			char c = input.charAt(i);
			if (c == '(' || c == ')') {
				tokens.add(String.valueOf(c));
				i++;
			} else if (Character.isDigit(c)) {
				StringBuilder num = new StringBuilder();
				while (i < input.length() && Character.isDigit(input.charAt(i))) {
					num.append(input.charAt(i));
					i++;
				}
				tokens.add(num.toString());
			} else if (Character.isWhitespace(c)) {
				i++;
			} else {
				throw new RuntimeException("Invalid character: " + c);
			}
		}
		return tokens;
	}

	private static Node parseTree(List<String> tokens) {
		if (tokens.isEmpty() || !tokens.get(0).equals("(")) {
			throw new RuntimeException("Invalid format");
		}
		return parseNode(tokens, 0).node;
	}

	private static ParseResult parseNode(List<String> tokens, int index) {
		index++; // Skip '('
		int value = Integer.parseInt(tokens.get(index++));
		Node node = new Node(value);
		List<Node> children = new ArrayList<>();
		while (index < tokens.size() && !tokens.get(index).equals(")")) {
			if (tokens.get(index).equals("(")) {
				ParseResult result = parseNode(tokens, index);
				children.add(result.node);
				index = result.index;
			} else {
				Node child = new Node(Integer.parseInt(tokens.get(index++)));
				children.add(child);
			}
		}
		index++; // Skip ')'
		node.children = children;
		return new ParseResult(node, index);
	}

	private static class ParseResult {
		Node node;
		int index;

		ParseResult(Node node, int index) {
			this.node = node;
			this.index = index;
		}
	}

	private static String render(Node root) {
		StringBuilder sb = new StringBuilder();
		render(root, sb, new ArrayList<>(), true);
		return sb.toString();
	}

	private static void render(Node node, StringBuilder sb, List<Boolean> levels, boolean isLast) {
		if (!levels.isEmpty()) {
			for (int i = 0; i < levels.size() - 1; i++) {
				sb.append(levels.get(i) ? "    " : "│   ");
			}
			sb.append(isLast ? "└── " : "├── ");
		}
		sb.append(node.value);
		if (node.children.isEmpty()) {
			sb.append("\n");
		} else {
			sb.append("---+\n");
			for (int i = 0; i < node.children.size(); i++) {
				boolean childIsLast = i == node.children.size() - 1;
				List<Boolean> childLevels = new ArrayList<>(levels);
				childLevels.add(childIsLast);
				render(node.children.get(i), sb, childLevels, childIsLast);
			}
		}
	}
}
