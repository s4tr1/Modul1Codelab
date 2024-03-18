import java.util.Scanner;
import java.util.ArrayList;
public class Student {
    String nama;
    String faculty;
    String programStudy;
    String nim;

    // Konstruktor
    public Student() {
        this.nama = nama;
        this.faculty = faculty;
        this.programStudy = programStudy;
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getProgramStudy() {
        return programStudy;
    }

    public String getNim() {
        return nim;
    }
    String[][] bookData = {
            {"388c-e681-9152", "Alvi Bucin", "Tengku", "Romantis", "4"},
            {"ed90-be30-5cdb", "Rayyan Sadboy", "Zeliq", "Nice Try", "2"},
            {"d95e-0c4a-9523", "Nawaf Anis Garis Keras", "Alfito", "Onema Baswedan", "0"}
    };
    void DisplayBook() {
        // Menampilkan header
        System.out.println("==================================================================");
        System.out.println("|| No. || Id Buku || Nama Buku || Author || Category || Stock ||");
        System.out.println("==================================================================");
        // Menampilkan data buku
        for (int i = 0; i < bookData.length; i++) {
            System.out.printf("|| %d || %s || %s || %s || %s || %s Stock ||\n",
                    i + 1, bookData[i][0], bookData[i][1], bookData[i][2], bookData[i][3], bookData[i][4]);
        }
    }

    int Bukuterpinjam(Scanner scanner, ArrayList<String> bukuterpinjam) {
        System.out.println("Buku yang sudah dipinjam:");
        for (String bookId : bukuterpinjam) {
            System.out.println("- " + bookId);
        } return 0;
    }

    int pinjamBuku(Scanner scanner, ArrayList<String> bukuDipinjam) {
        System.out.print("Masukkan ID Buku yang ingin Anda pinjam: ");
        String bookId = scanner.next();

        // Mencari ID buku yang dimasukkan dalam data buku yang tersedia
        boolean isValidBook = false;
        for (String[] book : bookData) {
            if (book[0].equals(bookId)) {
                isValidBook = true;
                break;
            }
        }
        if (isValidBook) {
            if (!bukuDipinjam.contains(bookId)) {
                bukuDipinjam.add(bookId);
                System.out.println("Buku berhasil dipinjam.");
            } else {
                System.out.println("Buku sudah dipinjam sebelumnya.");
            }
        } else {
            System.out.println("ID Buku tidak valid.");
        }return 0;
    }



}

