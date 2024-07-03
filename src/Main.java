import java.util.Scanner;

public class Main {
    static String[] list = new String[10];
    static Scanner input = new Scanner(System.in);
    static boolean isRun = true;
    static Scanner model = new Scanner(System.in);
    static String modelTodo = "";
    public static void main(String[] args) {
        viewShowTodoList();
    }

    static void showTodoList(){
        for (int i = 0; i < list.length; i++){
            if (list[0] == null){
                System.out.println("TODO KOSONG");
                break;
            } else if (list[i] != null) {
                System.out.println("[ "+(i+1)+". " + list[i].toUpperCase()+" ]");
            }
        }
    }

    static String inputUserHandle(){
        System.out.print("User : ");
        return input.nextLine();
    }

    static Integer inputNumber(){
        System.out.print("Number Todo : ");
        return input.nextInt();
    }

    static void addTodo(String add){
        boolean isFull = true;
        for (int i = 0; i < list.length; i++){
            if (list[i] == null){
                isFull = false;
            }
        }

        if (isFull){
            String model[] = list;
            list = new String[list.length * 2];
            for (int i = 0; i < list.length; i++){
                list[i] = model[i];
            }
        }
        for (int i = 0; i < list.length; i++){
            if (list[i] == null){
                list[i] = add;
                break;
            }
        }
    }

    static void removeTodo(Integer removeTodo){
        if ((removeTodo -1) >= list.length){
            System.out.println("Melebihi Jumlah Data !");
        } else if (list[removeTodo -1] == null) {
            System.out.println("Data Kosong");
        } else {
            for (int i = (removeTodo - 1); i < list.length; i++){
                if (i == (list.length - 1)){
//                    System.out.print("Menghapus Todo BerModel " + modelTodo + " Nomor " + removeTodo+"\n");
                    list[i] = null;
                } else {
                    list[i] = list[i + 1];
                }
            }
        }
    }

    static void exitTodo(){
        isRun = false;
    }

    static void viewShowTodoList(){
        while (isRun){
            showTodoList();
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            String user = inputUserHandle();

            if (user.equals("1")){
//                if (modelTodo.isEmpty()){
//                    System.out.print("ex. Model\nMobil, Sepeda Motor, Barang ,dll : ");
//                    modelTodo = model.nextLine();
//                }
                System.out.print("X/x untuk keluar\nUser : ");
                String userAdd = input.nextLine();
                if (userAdd.equals("x")){
                    isRun = false;
                } else {
                    addTodo(userAdd);
                }
            } else if (user.equals("2")) {
                Integer userRemove = inputNumber();
                removeTodo(userRemove);
            } else if (user.equals("x")) {
                exitTodo();
            } else {
                System.out.println("Command Not Found");
            }
        }
    }

}