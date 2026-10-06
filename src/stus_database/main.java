package stus_database;

import java.util.Scanner;

public class main {
    // 类级静态成员变量：学生数组，所有静态方法可直接访问
    static Student[] arr;

    public static void main(String[] args) {
        arr = new Student[3];
        arr[0] = new Student(1, "zhangsan", 18);
        arr[1] = new Student(2, "chenyifei", 19);
        arr[2] = new Student(3, "xxh", 100);
        Student stu4 = new Student(4, "huxujian", 45);

        // 插入新同学
        if (judge(stu4.getNumber())) {
            int cnt = contain(stu4);
            if (cnt == 0) {
                Student[] arr1 = new Student[arr.length + 1];
                int i = 0;
                for (; i < arr.length; i++) arr1[i] = arr[i];
                arr1[i] = stu4;
                arr = arr1;  // 将新数组赋给全局 arr
                print_stu();
            } else {
                arr[arr.length - cnt] = stu4;
                print_stu();
            }
        } else {
            System.out.println("重复了");
        }

        // 删除学生
        Scanner s = new Scanner(System.in);
        System.out.println("如果想删人输入1");
        int flag = s.nextInt();
        if (flag == 1) {
            System.out.println("cin his id");
            int idd = s.nextInt();
            delect(idd);
            print_stu();
        }
    }

    // 删除学生信息
    public static void delect(int id) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getNumber() == id) {
                arr[i].setAge(0);
                return;
            }
        }
        System.out.println("cant delect");
    }

    // 打印学生信息
    public static void print_stu() {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getAge() == 0) {
                continue;
            }
            System.out.println(arr[i].getNumber() + " " + arr[i].getName() + " " + arr[i].getAge());
        }
    }

    // 统计空位数量
    public static int contain(Student stu4) {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getAge() == 0) cnt++;
        }
        return cnt;
    }

    // 判断是否重复
    public static boolean judge(int id) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getAge() == 0) return true;
            if (id == arr[i].getNumber()) return false;
        }
        return true;
    }
}