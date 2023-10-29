import java.util.*;
import java.util.ArrayList;

class Book {
    static Scanner scnInput = new Scanner(System.in);
    static String userInput;

    static String name;
    static int stockAge;
    private  String title;
    private  int stock;
    private ArrayList<String> userWithBook;

    public Book(String title, int stock) {
        this.title = title;
        this.stock = stock;
        this.userWithBook = new ArrayList<>();
    }

    public String getTitle() {
        return this.title;
    }

    public int getStock() {
        return this.stock;
    }

    public ArrayList<String> getuserWithBook() {
        return userWithBook;
    }

    public void loanBook(String usuario) {
        if (stock > 0) {
            userWithBook.add(usuario);
            stock--;
            System.out.println("Livro " + title + " emprestado para " + usuario);
        } else {
            System.out.println("Estoque do livro " + title + " esgotado.");
        }
    }

    public void returnBook(String usuario) {
        if (userWithBook.contains(usuario)) {
            userWithBook.remove(usuario);
            stock++;
            System.out.println("Livro " + title + " devolvido por " + usuario);
        } else {
            System.out.println("Este usuário não requisitou o livro " + title);
        }
    }
}
