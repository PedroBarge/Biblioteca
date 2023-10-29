import java.util.ArrayList;

class Book {
    private String title;
    private int stock;
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

    public ArrayList<String> getUserWithBook() {
        return this.userWithBook;
    }

    public void loanBook(String user) {
        if (stock > 0) {
            userWithBook.add(user);
            stock--;
            System.out.println("Livro " + title + " emprestado para " + user);
        } else {
            System.out.println("Estoque do livro " + title + " esgotado.");
        }
    }

    public void returnBook(String user) {
        if (userWithBook.contains(user)) {
            userWithBook.remove(user);
            stock++;
            System.out.println("Livro " + title + " devolvido por " + user);
        } else {
            System.out.println("Este usuário não requisitou o livro " + title);
        }
    }
}
