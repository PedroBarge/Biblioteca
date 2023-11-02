import java.util.ArrayList;

public class Library {
   /* private final ArrayList<Book> books;
    private final ArrayList<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void loanBook(User user, Book book) {
        if (books.contains(book) && book.getStock() > 0) {
            book.decreaseStock();
            user.borrowBook(book);
            System.out.println(book.getTitle() + " emprestado para " + user.getName());
        } else {
            System.out.println("O livro não está disponível no momento.");
        }
    }

    public void returnBook(User user, Book book) {
        if (user.hasBorrowedBook(book)) {
            book.increaseStock();
            user.returnBook(book);
            System.out.println(book.getTitle() + " devolvido por " + user.getName());
        } else {
            System.out.println(user.getName() + " não possui este livro emprestado.");
        }
    }*/
}
