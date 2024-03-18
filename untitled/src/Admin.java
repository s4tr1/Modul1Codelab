import java.util.Scanner;
import java.util.ArrayList;

public class Admin {
    ArrayList<Student> daftarStu = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    String loggedNIM; // Menyimpan NIM mahasiswa yang berhasil login

    void setAdmin() {
        System.out.print("Enter your username (admin): ");
        String userAdmin = scan.next();
        System.out.print("Enter your password (admin): ");
        String passAdmin = scan.next();
        if (userAdmin.equals("admin") && passAdmin.equals("admin")) {
            System.out.println("Successful Login as Admin");
        } else {
            System.out.println("Admin User Not Found!!");
            System.exit(0);
        }
    }

    String setPasStudent() {
        System.out.print("Enter your NIM (masukkan 99 untuk kembali): ");
        String nim = scan.next();
        if (nim.equals("99")) {
            return nim;
        }
        if (nim.length() == 15) {
            System.out.println("Successful Login as Student");
            loggedNIM = nim; // Simpan NIM mahasiswa yang berhasil login
        }
        return nim;
    }

    void setAddStudent() {
        Student stu = new Student();
        scan.nextLine(); // Membuang karakter newline yang tersisa di buffer
        System.out.print("Masukkan nama mahasiswa: ");
        stu.nama = scan.nextLine();
        System.out.print("Masukkan NIM mahasiswa: ");
        stu.nim = scan.nextLine();
        if (stu.nim.length() != 15) {
            System.out.println("Panjang NIM harus 15 angka.");
            return;
        }
        System.out.print("Masukkan Fakultas: ");
        stu.faculty = scan.nextLine();
        System.out.print("Masukkan Program Studi: ");
        stu.programStudy = scan.nextLine();
        System.out.println("Data mahasiswa berhasil ditambahkan.");
        daftarStu.add(stu);
    }

    void setDisplayStudent() {
        System.out.println("\nData Mahasiswa:");
        for (Student mhs : daftarStu) {
            System.out.println("Nama: " + mhs.getNama());
            System.out.println("Fakultas: " + mhs.getFaculty());
            System.out.println("Program Studi: " + mhs.getProgramStudy());
            System.out.println("NIM: " + mhs.getNim());
            System.out.println();
        }
    }
}
