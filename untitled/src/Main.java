import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Admin> daftaradmin = new ArrayList<>();
        ArrayList<Student> daftarStu = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("====Library Sistem====");
            System.out.println("1. Login as Mahasiswa");
            System.out.println("2. Login as Admin");
            System.out.println("3. Keluar");
            System.out.print("Pilihan Anda: ");
            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    menuMahasiswa(daftarStu, scanner);
                    break;
                case "2":
                    menuAdmin(daftaradmin, scanner);
                    break;
                case "3":
                    System.out.println("Terima kasih!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    public static void menuMahasiswa(ArrayList<Student> daftarStu, Scanner scanner) {
        ArrayList<String> arrStu = new ArrayList<>();
        Admin Adm = new Admin();
        Student stu = new Student();
        Adm.setPasStudent();
        stu.DisplayBook();

        boolean keepRunning = true; // Variabel untuk mengontrol pengulangan
        while (keepRunning) {
            System.out.println("\n=====Student menu====");
            System.out.println("1. Buku Terpinjam");
            System.out.println("2. Pinjam Buku");
            System.out.println("3. Pinjam Buku atau Logout");
            System.out.print("Pilihan Anda: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    stu.Bukuterpinjam(scanner, arrStu);
                    break;
                case 2:
                    stu.pinjamBuku(scanner, arrStu);
                    break;
                case 3:
                    System.out.println("System logout");
                    keepRunning = false; // Menghentikan pengulangan
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }


    public static void menuAdmin(ArrayList<Admin> daftaradmin, Scanner scanner) {
        Admin Adm = new Admin();
        Adm.setAdmin();
        while (true) {
            System.out.println("====Menu Admin====");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Tampilkan Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilihan Anda: ");
            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    Adm.setAddStudent();
                    break;
                case "2":
                    Adm.setDisplayStudent();
                    break;
                case "3":
                    System.out.println("Terima kasih!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}

