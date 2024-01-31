package validate;

import model.Product;
import java.util.List;
import java.util.Scanner;

public class ValidateProduct {
    static Scanner scanner = new Scanner(System.in);

    public static int quantity() {
        while (true) {
            try {
                System.out.println("Nhập số lượng sản phẩm");
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.err.println("Nhập sai rồi vui lòng nhập lại.");
            }
        }
    }

    public static double price() {
        while (true) {
            try{
                System.out.println("Nhập giá sản phẩm");
                return Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                System.err.println("Nhập sai rồi vui lòng nhâoj lại.");
            }
        }
    }

    public static int id(List<Product> products) {
        int idMax = 0;
        for (Product p : products) {
            if(p.getId() > idMax) {
                idMax = p.getId();
            }
        }
        return idMax +1;
    }

    public static String name(List<Product> products) {
        while (true) {
            System.out.println("Nhập tên sản phẩm");
            String name = scanner.nextLine();
            boolean check = true;
            for (Product p: products) {
                if (p.getName().equals(name)) {
                    System.err.println("Trùng tên rồi vui lòng nhập lại");
                    check = false;
                    break;
                }
            }
            if (check) {
                return name;
            }
        }
    }
}
