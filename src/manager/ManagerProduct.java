package manager;


import io.ProductIO;
import model.Product;
import validate.ValidateProduct;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class ManagerProduct {
    List<Product> products = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void add(Product p) {
        products.add(p);
        System.err.println("Đã thêm sản phẩm thành công");
    }

    public void read() {
        products = ProductIO.read();
    }
    public void write() {
        ProductIO.writer(products);
    }


    public Product create() {
        int id = ValidateProduct.id(products);
        String name = ValidateProduct.name(products);
        double price = ValidateProduct.price();
        int quantity = ValidateProduct.quantity();
        System.out.println("Nhập mô tả sản phẩm");
        String content = scanner.nextLine();
        return new Product(id, name, price, quantity, content);
    }

    public void edit() {
        try {
            System.out.println("Nhập mã sản phẩm muốn sửa");
            int id = Integer.parseInt(scanner.nextLine());
            int index = findIndexById(id);
            if (index != -1) {
                products.set(index, create());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.err.println("Đã cập nhật sản phẩm thành công");
    }

    public void delete() {
        try {
            System.out.println("Nhập id muốn xóa");
            int id = Integer.parseInt(scanner.nextLine());
            int index = findIndexById(id);
            System.err.println("Bạn chắc chắn muốn xóa sản phẩm(chọn 0 nếu bạn chắc chắn");
            int check = Integer.parseInt(scanner.nextLine());
            if (index != -1 && check ==0) {
                products.remove(index);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.err.println("Đã xóa sản phẩm thành công");
    }

    public void display() {
        int pageSize = 5;
        int currentPage = 1;
        int start = 0;
        int end;
        while (true) {
            System.out.println(" Them moi");
            System.out.println("ID, Name, Price, Quantity, Content");
            end = Math.min(start + pageSize, products.size());

            for (int i = start; i < end; i++) {
                System.out.println(products.get(i));
                }
            System.out.println("Nhấn Enter để qua trang tiếp theo ");
            String input = scanner.nextLine();

            if (!input.isEmpty()) {
                break;
            }
            currentPage++;
            start = pageSize * (currentPage - 1);
            if (start >= products.size()) {
                break;
            }
        }
    }

    public int findIndexById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void sortProductIncrease() {
        for (int i = 0; i < products.size(); i++) {
            for (int j = 0; j < products.size() - i - 1; j++) {
                if (products.get(j).getPrice() > products.get(j + 1).getPrice()) {
                    Product temp = products.get(j);
                    products.set(j, products.get(j + 1));
                    products.set(j + 1, temp);
                }
            }
        }
    }
    public void sortProductReduce() {
        for (int i = 0; i < products.size(); i++) {
            for (int j = 0; j < products.size() - i - 1; j++) {
                if (products.get(j).getPrice() < products.get(j + 1).getPrice()) {
                    Product temp = products.get(j);
                    products.set(j, products.get(j + 1));
                    products.set(j + 1, temp);
                }
            }
        }
    }

    public Product findProductMax() {
        if (products.size() > 0) {
            Product max = products.get(0);
            for (Product p : products) {
                if (p.getPrice() > max.getPrice()) {
                    max = p;
                }
            }
            return max;

        } else {
            return null;
        }
    }


}
