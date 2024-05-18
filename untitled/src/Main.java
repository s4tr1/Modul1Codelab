import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int i = 1;
        while (true) {
            System.out.println("Masukkan nama ke-" + i + ": ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("selesai")) {
                break;
            }
            try {
                if (name.isEmpty()) {
                    throw new IllegalArgumentException("Nama tidak boleh kosong");
                }
                students.add(name);
                i++;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                i--;
            }
        }
        System.out.println("Daftar mahasiswa yang diinputkan:");
        for (String student : students) {
            System.out.println("- " + student);
        }
    }
}