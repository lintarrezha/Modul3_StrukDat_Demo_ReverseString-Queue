package Kegiatan2;

import java.util.Scanner;

public class InventoryBarang {
    private Node head;
    private Node tail;
    private int size;

    private static class Node {
        private String data;
        private Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public InventoryBarang() {
        head = null;
        tail = null;
        size = 0;
    }

    public void enqueue(String data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public String dequeue() {
        if (isEmpty()) {
            return null;
        }
        String data = head.data;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return data;
    }

    public String peek() {
        if (isEmpty()) {
            return null;
        }
        return head.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Barang Kosong.");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryBarang inventory = new InventoryBarang();
        String input = "";
        while (!input.equals("exit")) {
            System.out.println("===========Inventory Barang===========");
            System.out.println("1. Tambah barang");
            System.out.println("2. Hapus barang");
            System.out.println("3. Lihat barang teratas");
            System.out.println("4. Lihat semua ketersediaan barang");
            System.out.println("5. Cek jumlah barang");
            System.out.println("6. Cari barang");
            System.out.println("0. Keluar");
            System.out.println("======================================");
            System.out.print("Masukkan pilihan: ");
            input = scanner.nextLine();
            switch (input) {
                case "0":
                    System.exit(0);
                    break;
                case "1":
                    System.out.print("Masukkan nama barang: ");
                    String barangBaru = scanner.nextLine();
                    inventory.enqueue(barangBaru);
                    System.out.println(barangBaru + " telah ditambahkan ke inventory");
                    break;
                case "2":
                    String barangHapus = inventory.dequeue();
                    if (barangHapus == null) {
                        System.out.println("Inventory kosong");
                    } else {
                        System.out.println(barangHapus + " telah dihapus dari inventory");
                    }
                    break;
                case "3":
                    String barangTeratas = inventory.peek();
                    if (barangTeratas == null) {
                        System.out.println("Inventory kosong");
                    } else {
                        System.out.println("Barang teratas Saat Ini: " + barangTeratas);
                    }
                    break;
                case "4" :
                    System.out.println("Barang yang Tersedia Saat Ini: ");
                    inventory.display();
                    break;
                case "5":
                    int jumlahBarang = inventory.size();
                    System.out.println("Jumlah barang: " + jumlahBarang);
                    break;
                case "6":
                    System.out.print("Masukkan nama barang yang ingin dicari: ");
                    String barangCari = scanner.nextLine();
                    Node current = inventory.head;
                    boolean ditemukan = false;
                    while (current != null) {
                        if (current.data.equals(barangCari)) {
                            System.out.println(barangCari + " ditemukan di inventory");
                            ditemukan = true;
                            break;
                        }
                        current = current.next;
                    }
                    if (!ditemukan) {
                        System.out.println(barangCari + " tidak ditemukan di inventory");
                    }
                    break;
            }
        }
    }
}



