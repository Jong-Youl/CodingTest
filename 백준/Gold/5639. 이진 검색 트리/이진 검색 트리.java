import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        while(true) {
            String input = br.readLine();
            if(input == null || input.equals(""))
                break;
            list.add(Integer.parseInt(input));
        }

        Node root = null;
        for(int value : list)
            root = insert(root, value);

        postOrder(root);
        System.out.println(sb);
    }
    private static void postOrder(Node node) {
        if(node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.value).append("\n");
    }

    private static Node insert(Node node, int value) {
        if(node == null)
            return new Node(value);
        if(value < node.value)
            node.left = insert(node.left, value);
        else
            node.right = insert(node.right, value);
        return node;
    }

    private static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}