import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nama : ");
        String name = scanner.nextLine();
        System.out.print("Jenis Kelamin (L/P) : ");
        String genderAbbr = scanner.nextLine().toLowerCase();
        System.out.print("Tanggal Lahir (yyyy-mm-dd) : ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dob = LocalDate.parse(scanner.nextLine(), formatter);

        String gender = "Laki-laki";
        if (genderAbbr.equals("p")) {
            gender = "Perempuan";
        }

        Period period = Period.between(dob, LocalDate.now());
        int years = period.getYears();
        int months = period.getMonths();

        System.out.println("Nama : " + name);
        System.out.println("Jenis Kelamin : " + gender);
        System.out.println("Umur Anda : " + years + " tahun " + months + " bulan");
    }
}