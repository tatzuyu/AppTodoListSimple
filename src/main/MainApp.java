package main;

import java.util.Scanner;

public class MainApp {

    public static String [] model = new String [10];

    //Make Method Scanner
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static void main(String[] args) {
        testViewRemoveShowTodoList();

    }

    /**
     * Menampilkan Todo List
     */
    public static void showTodoList (){
        System.out.println("TODOLIST TIRTA");
        for (var i = 0; i < model.length; i++){
            var todo = model[i];
            var no = i + 1;

            if (todo != null){
                System.out.println(no + ". "+ todo);
            }
        }

    }

    /**
     * Membuat Method untuk menguji show Todo List
     */
    public static void testShowTodoList (){
        model [0] = "Belajar Java Dasar";
        model [1] = "Studi Kasus Java Dasar : Membuat Aplikasi TodoList";
        showTodoList();
    }

    /**
     * Menambah Todo Ke List
     */
    public static void addTodoList (String todo) {
        //Cek apakah penuh
        var isFull = true;
        for (int i = 0; i < model.length; i ++){
            if(model [i] == null){
                //model masih ada yg kosong
                isFull = false;
                break;
            }
        }

        //Jika Penuh, di resize ukuran arraynya 2x lipat
        if (isFull){
            //menyimpan data array ke dalam variable temporary agar tidak terdelete
            var temp = model;
            //Meresize data array menjadi 2x lipat
            model = new String[model.length * 2];

            //memindahkan data array temp ke dalam model baru
            for (int i = 0; i < temp.length; i++){
                model[i] = temp[i];
            }
        }

        //tambahkan posisi ke data arraynya yang NULL
        for (var i = 0; i < model.length; i++){
            if (model[i] == null){
                model[i] = todo;
                break;
            }
        }
    }

    /**
     * Membuat Method untuk test AddTodoList
     */
    public static void testAddTodoList(){
        for (int i = 0; i < 30 ; i++) {
            addTodoList("Contoh Tambah Todo Ke. " +i);
        }
        showTodoList();
    }

    /**
     * Menghapus Todo dari List
     */
    public static boolean removeTodoList (Integer number){
        if ((number -1) >= model.length){
            return false;
        }
        else if (model[number - 1] == null){
            return false;
        }
        else {
            for (int i = (number - 1) ; i < model.length ; i++) {
                if (i == ( model.length - 1 )){
                    model [i] = null;
                }
                else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    /**
     * Membuat test menghapus TodoList
     */
    public static void testRemoveTodoList (){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");

        var result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(7);
        System.out.println(result);

        result = removeTodoList(2);
        System.out.println(result);

        showTodoList();

    }

    /**
     *
     * Add Method input
     */
    public static String input (String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput() {
        var name = input("Nama");
        System.out.println("Hi " + name);

        var birthDate = input("Tanggal Lahir");
        System.out.println(birthDate);
    }

    /**
     * Menampilkan view Todo List
     */
    public static void viewShowTodoList(){
        while (true){
            showTodoList();

            System.out.println("===MENU===");
            System.out.println("1. Tambah ");
            System.out.println("2. Hapus ");
            System.out.println("3. Keluar");

            var input = input("Masukkan Pilihan");
            if (input.equals("1")){
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("3")) {
                break;
            }
            else {
                System.out.println("Pilihan Tidak Ada");
            }
        }
    }

    /**
     * Make Method Test View Show Todo List
     */

    public static void testViewShowTodoList (){
        addTodoList("Belajar Java Dasar");
        addTodoList("Belajar Bahasa Inggris");
        addTodoList("Membaca Al - Qur'an");
        addTodoList("Mengerjakan Task Hungry");
        addTodoList("Latihan Ngoding");
        viewShowTodoList();
    }

    /**
     * Menampilkan view menambah Todo List
     */
    public static void viewAddTodoList (){
        System.out.println("===TAMBAH TODOLIST===");

        var todo = input("todo (x Jika Batal)");
        if(todo.equals("x")){
            //batal
        }
        else {
            addTodoList(todo);
        }

    }

    public static void testViewAddTodoList () {
        addTodoList("Study Java Programming");
        addTodoList("Learn English Language");
        addTodoList("Read Al - Qur'an");
        addTodoList("Practice Coding");

        showTodoList();
        viewAddTodoList();
        showTodoList();
    }

    /**
     * Menampilkan view menghapus Todo List
     */
    public static void viewRemoveTodoList (){
        System.out.println("MENGHAPUS TODOLIST");

        var number = input("Nomor yg ingin di Hapus (x Jika Batal)");

        if(number.equals("x")){
            //batal
        }else {
            boolean succes = removeTodoList(Integer.valueOf(number));
            if(!succes){
                System.out.println("Gagal menghapus todolist " + number);
            }
        }
    }

    public static void testViewRemoveShowTodoList (){
        addTodoList("Learn Love Allah SWT");
        addTodoList("Learn Know Rasullullah SAW");
        addTodoList("Read Al-Qur'an");
        addTodoList("Learn Java Programming");

        showTodoList();
        viewRemoveTodoList();
        showTodoList();
    }
}
