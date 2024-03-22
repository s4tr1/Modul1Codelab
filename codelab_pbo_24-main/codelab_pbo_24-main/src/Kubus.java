import java.util.Scanner;

import static java.lang.System.out;

class Kubus extends BangunRuang {
    Scanner scanner = new Scanner(System.in);
    private double sisi;

    Kubus(String name) {
        super(name);
    }

    @Override
    public void inputNilai() {
        super.inputNilai();
        System.out.print("Input sisi: ");
        sisi = scanner.nextDouble();
    }

    @Override
    public void luasPermukaan() {
        double hasil = 6 * Math.pow(sisi, 2); // Rumus luas permukaan kubus
        super.luasPermukaan();
        System.out.println("Hasil luas permukaan: " + hasil);
    }

    @Override
    public void volume() {
        double hasil = Math.pow(sisi, 3); // Rumus volume kubus
        super.volume();
        System.out.println("Hasil volume: " + hasil);
    }
}
