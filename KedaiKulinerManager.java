
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class KedaiKulinerManager {
    private List<MenuItem> menu;
    private List<MenuItem> orders;

    public KedaiKulinerManager() {
        menu = new ArrayList<>();
        orders = new ArrayList<>();

        menu.add(new Makanan("Nasi Liwet", 25000, 10, 0.1));
        menu.add(new Makanan("Sop Iga", 50000, 6, 0.1));
        menu.add(new Makanan("Gurame Bakar", 60000, 5, 0.15));
        menu.add(new Makanan("Ayam Geprek", 30000, 12, 0.1));
        menu.add(new Makanan("Tongseng Kambing", 45000, 8, 0.1));
        menu.add(new Minuman("Es Kelapa Muda", 15000, 10, 0.05));
        menu.add(new Minuman("Wedang Uwuh", 18000, 15, 0.1));
        menu.add(new Minuman("Es Jeruk", 12000, 14, 0.05));
        menu.add(new Minuman("Bandrek Susu", 17000, 13, 0.1));
    }

    public void displayMenu(int sortBy) {
        if (sortBy == 1) {
            quickSortByName(menu, 0, menu.size() - 1);
        } else if (sortBy == 2) {
            quickSortByPrice(menu, 0, menu.size() - 1);
        }

        System.out.println("+------------------+--------------+-------+-----------+");
        System.out.printf("| %-16s | %-12s | %-5s | %-9s |%n", "Nama", "Harga", "Stok", "Kategori");
        System.out.println("+------------------+--------------+-------+-----------+");
        for (MenuItem item : menu) {
            System.out.printf("| %-16s | Rp %,-6.2f | %-5d | %-9s |%n",
                    item.getName(), item.getPrice(), item.getQuantity(), item.getCategory());
        }
        System.out.println("+------------------+--------------+-------+-----------+");
    }

    public boolean orderItem(String name, int amount) {
        for (MenuItem item : menu) {
            if (item.getName().equalsIgnoreCase(name)) {
                if (item.reduceStock(amount)) {
                    if (item instanceof Makanan) {
                        orders.add(new Makanan(item.getName(), item.getPrice(), amount, item.getDiscountRate()));
                    } else if (item instanceof Minuman) {
                        orders.add(new Minuman(item.getName(), item.getPrice(), amount, item.getDiscountRate()));
                    } else {
                        orders.add(new MenuItem(item.getName(), item.getPrice(), amount, item.getDiscountRate(), item.getCategory()));
                    }
                    return true;
                } else {
                    System.out.println("Stok tidak cukup!");
                    return false;
                }
            }
        }
        System.out.println("Menu tidak ditemukan!");
        return false;
    }

    public void displayReceipt() {
        if (orders.isEmpty()) {
            System.out.println("Belum ada pesanan!");
            return;
        }

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║               Struk Pembelian              ║");
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.printf("║ Tanggal & Waktu : %-24s ║%n", formattedDateTime);
        System.out.println("╠════════════════════════════════════════════╣");

        double totalPrice = 0;
        for (MenuItem item : orders) {
            double itemTotal = item.calculateTotalPrice(item.getQuantity());
            totalPrice += itemTotal;
            System.out.printf("║ %-24s x%-2d  Rp %,-8.2f ║%n", item.getName(), item.getQuantity(), itemTotal);
        }

        System.out.println("╠────────────────────────────────────────────╣");

        double discount = 0;
        if (totalPrice > 20000) {
            discount = totalPrice * 0.1;
            totalPrice -= discount;
        }

        System.out.printf("║ %-28s: Rp %,-8.2f ║%n", "Subtotal", totalPrice + discount);
        if (discount > 0) {
            System.out.printf("║ %-28s: Rp  %,-8.2f ║%n", "Diskon (10%)", discount);
        }
        System.out.printf("║ %-28s: Rp %,-8.2f ║%n", "Total Bayar", totalPrice);

        System.out.println("╚════════════════════════════════════════════╝");

        orders.clear();
    }

    public void linearSearch(String name) {
        for (MenuItem item : menu) {
            if (item.getName().equalsIgnoreCase(name)) {
                System.out.println("Menu ditemukan: " + item.getName() + " - Rp " + item.getPrice());
                return;
            }
        }
        System.out.println("Menu tidak ditemukan!");
    }

    private void quickSortByName(List<MenuItem> list, int low, int high) {
        if (low < high) {
            int pi = partitionByName(list, low, high);
            quickSortByName(list, low, pi - 1);
            quickSortByName(list, pi + 1, high);
        }
    }

    private int partitionByName(List<MenuItem> list, int low, int high) {
        String pivot = list.get(high).getName();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j).getName().compareToIgnoreCase(pivot) < 0) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }

    private void quickSortByPrice(List<MenuItem> list, int low, int high) {
        if (low < high) {
            int pi = partitionByPrice(list, low, high);
            quickSortByPrice(list, low, pi - 1);
            quickSortByPrice(list, pi + 1, high);
        }
    }

    private int partitionByPrice(List<MenuItem> list, int low, int high) {
        double pivot = list.get(high).getPrice();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j).getPrice() < pivot) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }

    private void swap(List<MenuItem> list, int i, int j) {
        MenuItem temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public void keluar() {
        System.out.println("\n╔═════════════════════════════════════════╗");
        System.out.println("║                THANK YOU !              ║");
        System.out.println("║    Telah berbelanja di Kedai Kuliner    ║");
        System.out.println("║           Sampai jumpa kembali!         ║");
        System.out.println("║           Gilang Kelvin Saputra         ║");
        System.out.println("║                24111814096              ║");
        System.out.println("╚═════════════════════════════════════════╝");
    }
}
