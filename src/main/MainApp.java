package main;

import java.util.Scanner;

public class MainApp {

    public static String [] model = new String [10];

    //Make Method Scanner
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static void main(String[] args) {
        testRemoveTodoList();

    }

    /**
     * Menampilkan Todo List
     */
    public static void showTodoList (){
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

    /**
     * Menampilkan view Todo List
     */
    public static void viewShowTodoList(){

    }

    /**
     * Menampilkan view menambah Todo List
     */
    public static void viewAddTodoList (){

    }

    /**
     * Menampilkan view menghapus Todo List
     */
    public static void viewRemoveTodoList (){

    }
}
