package practice;

import java.util.Scanner;

public class Price {
    public static void main(String[] args) {
        System.out.println("请输入系统的密码：");
        Scanner sc = new Scanner(System.in);
        int pwd = sc.nextInt();
        String encoded = process(pwd);  // 调用加密函数
        System.out.println("加密后的密码是：" + encoded);
        System.out.print('\n');
        System.out.println("请输入要解密的密码：");
        String encodedPwd = sc.next();
        System.out.println("解密后的密码是：" + decode(encodedPwd));
    }

    // 返回加密后的字符串
    public static String process(int pwd) {
        int temp = pwd;
        int n = 0;
        while (temp != 0) {
            temp /= 10;
            n++;
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (pwd % 10 + 5) % 10;
            pwd /= 10;
        }
        // 拼接加密后反转的结果
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
    public static String decode(String encodedPwd) {
        int n = encodedPwd.length();
        int[] arr = new int[n];
        // 1. 先把字符串里的每一位转成数字
        for (int i = 0; i < n; i++) {
            arr[i] = encodedPwd.charAt(i) - '0';
        }
        // 2. 解密公式还原每一位
        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] + 5) % 10;
        }
        // 3. 反转数组顺序（因为加密是反着来的）
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
