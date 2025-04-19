
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        KedaiKulinerManager manager = new KedaiKulinerManager();
        boolean running = true;

        while (running) {
            System.out.println("\n======= Kedai Kuliner =======");
            System.out.println("1. Lihat Menu");
            System.out.println("2. Pesan Makanan/Minuman");
            System.out.println("3. Cari Menu");
            System.out.println("4. Lihat Struk Pembelian");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Pilih metode sorting:");
                    System.out.println("1. Berdasarkan Nama");
                    System.out.println("2. Berdasarkan Harga");
                    System.out.print("Pilihan: ");
                    int sortBy = scanner.nextInt();
                    manager.displayMenu(sortBy);
                    break;
                case 2:
                    System.out.print("Masukkan nama menu: ");
                    String name = scanner.nextLine();
                    System.out.print("Masukkan jumlah: ");
                    int amount = scanner.nextInt();
                    scanner.nextLine();
                    manager.orderItem(name, amount);
                    break;
                case 3:
                    System.out.print("Masukkan nama menu yang dicari: ");
                    String searchName = scanner.nextLine();
                    manager.linearSearch(searchName);
                    break;
                case 4:
                    manager.displayReceipt();
                    break;
                case 5:
                    manager.keluar();
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
        scanner.close();
    }
}
