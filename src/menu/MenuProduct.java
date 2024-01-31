package menu;

import manager.ManagerProduct;

import java.util.Scanner;

public class MenuProduct {
    static Scanner  scanner = new Scanner(System.in);
    static ManagerProduct managerProduct = new ManagerProduct();
    public static void menu() {

        while (true) {
            System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM----");
            System.out.println("Chọn chức năng theo số (để tiếp tục)");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Tìm sản phẩm có giá đắt nhât");
            System.out.println("7. Đọc từ file");
            System.out.println("8. Ghi vào file");
            System.out.println("9. Thoát");
            System.out.println("Chọn chức năng: ");

            int choice = choice();

            switch (choice){
                case 1:
                   managerProduct.display();
                    break;
                case 2:
                    managerProduct.add(managerProduct.create());
                    break;
                case 3:
                    managerProduct.edit();
                    break;
                case 4:
                    managerProduct.delete();
                    break;
                case 5:
                    arrange();
                    break;
                case 6:
                    System.out.println(managerProduct.findProductMax());
                    break;
                case 7:
                    managerProduct.read();
                    break;
                case 8:
                    managerProduct.write();
                    break;
                case 9:
                    return;
                default:
                    System.err.println("Nhập số không đúng vui lòng nhập lại");
            }
        }

    }
    public static void arrange() {
        System.out.println("1. Tăng dần");
        System.out.println("2. Giảm dần");
        System.out.println("3. trở về");
        int choice = choice();
        switch (choice) {
            case 1:
                managerProduct.sortProductIncrease();
                managerProduct.display();
                break;
            case 2:
                managerProduct.sortProductReduce();
                managerProduct.display();
                break;
            case 3:
                return;
            default:
                System.out.println("Nhập số không đúng vui lòng nhập lại");
        }
    }

    public static int choice() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());

            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Mù à nhập số");
            }
        }
    }
}