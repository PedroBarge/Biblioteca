import java.util.*;
import java.util.ArrayList;

class Livro {
    static Scanner scnInput = new Scanner(System.in);
    static String userInput;

    static String name;
    static int stockAge;
    private static String title;
    private static int stock;
    private ArrayList<String> userWithBook;

    public Livro(String titulo, int estoque) {
        this.title = titulo;
        this.stock = estoque;
        this.userWithBook = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public int getStock() {
        return stock;
    }

    public ArrayList<String> getuserWithBook() {
        return userWithBook;
    }

    public void emprestarLivro(String usuario) {
        if (stock > 0) {
            userWithBook.add(usuario);
            stock--;
            System.out.println("Livro " + title + " emprestado para " + usuario);
        } else {
            System.out.println("Estoque do livro " + title + " esgotado.");
        }
    }

    public void devolverLivro(String usuario) {
        if (userWithBook.contains(usuario)) {
            userWithBook.remove(usuario);
            stock++;
            System.out.println("Livro " + title + " devolvido por " + usuario);
        } else {
            System.out.println("Este usuário não requisitou o livro " + title);
        }
    }
}


