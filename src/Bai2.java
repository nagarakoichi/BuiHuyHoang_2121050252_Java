package exercise2;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap day so cua mang");
        String line = scanner.nextLine().trim();
        if (line.isEmpty()) {
            System.out.println("Du lieu khong hop le!");
            return;
        }

        String[] tokens = line.split("\\s+");
        int n = tokens.length;
        int[] arr = new int[n];
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
            res[i] = -1;
        }

        // dem so lan xuat hien cua cac phan tu trong mang
        for (int i = 0; i < n; i++) {
            if (res[i] == 0) {
                continue;
            }

            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if(res[j] != 0 && arr[i] == arr[j]){
                    count++;
                    res[j] = 0;
                }
            }
            res[i] = count;
        }

        int max = res[0];
        for (int i = 0; i < n; i++) {
            if(res[i] > max){
                max = res[i];
            }
        }

        // xuat ket qua:
        System.out.print("So lan xuat hien Max: " + max + ", cac phan tu: ");

        boolean isFirst = true;
        for (int i = 0; i < n; i++) {
            if(res[i] == max){
                if (!isFirst) {
                    System.out.print(", ");
                }
                System.out.print(arr[i]);
                isFirst = false;
            }
        }
        System.out.println();

        scanner.close();
    }
}
