import java.io.*;
import java.util.*;
import java.io.IOException;

public class Main {
    static Scanner scn = new Scanner(System.in);
    //------------------------------------------------------------------//
    static String[] arrayBooksName = new String[10];
    static String[] arrayCat = {"Historia","SyFy","Comédia","Romance"};
    static String[] arrayAuthor = new String[10];
    //------------------------------------------------------------------//
    static int counterBD = 0;
    static String inputUSR;
    //------------------------------------------------------------------//

    //------------------------------------------------------------------//
    public static void main(String[] args) {
        System.out.println("Biblioteca\n");
        menuBase();
        System.out.print("Inserir opção: ");
        inputUSR = scn.next();
        switch (inputUSR){
            case "1":
                System.out.println();
                menuLivros();
                inputUSR = scn.next();
                break;
            case "2":
                System.out.println();
                menuUser();
                inputUSR = scn.next();
                break;
            default:
                if (inputUSR.equals("0")) {
                    System.out.println("A fechar aplicação...");
                }
                break;
        }


    }

    public static void menuBase(){
        System.out.println("     Menu     ");
        System.out.println("+-------------+");
        System.out.println("1- Livros");
        System.out.println("2- Leitores");
        System.out.println("0- Sair");
    }

    public static void menuLivros(){
        System.out.println("Menu Livros");
        System.out.println("+-------------+");
        System.out.println("1- Inserir Livros");
        System.out.println("2- Ver livros");
        System.out.println("3- Emprestimos de Livros");
        System.out.println("0- Menu anterior");
    }

    public static void menuUser(){
        System.out.println("Menu Leitores");
        System.out.println("+-------------+");
        System.out.println("1- Ver Leitores");
        System.out.println("2- Criar Leitores");
        System.out.println("3- Emprestimos de Livros");
        System.out.println("0- Menu anterior");
    }


}