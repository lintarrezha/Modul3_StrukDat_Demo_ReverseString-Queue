package Kegiatan1;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan sebuah string: ");
        String inputString = scanner.nextLine();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < inputString.length(); i++) {
            stack.push(inputString.charAt(i));
        }

        String reversedString = "";
        while (!stack.isEmpty()) {
            reversedString += stack.pop();
        }

        System.out.println("String terbalik: " + reversedString);
    }
}

class Stack<T> {
    private int size;
    private Node<T> top;

    public Stack() {
        size = 0;
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}


