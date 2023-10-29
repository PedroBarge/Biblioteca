import java.util.Scanner;
import java.util.ArrayList;

public class BibliotecaApp {
    //------------------------------------------------------------------//
    static Scanner scnInput = new Scanner(System.in);
    //------------------------------------------------------------------//
    static ArrayList<Book> livros = new ArrayList<>();
    static ArrayList<User> usuarios = new ArrayList<>();

    //------------------------------------------------------------------//
    public static void main(String[] args) {
        boolean menuLoop = false;
        //------------------------------------------------------------------//
        String userInput;
        int choiceBook;
        //------------------------------------------------------------------//
        int numUser;
        //Pre add
        livros.add(new Book("Os Lusiadas", 5));
        livros.add(new Book("Los Pollos Locos", 3));
        //System.out.println(livros.get(0).getTitle());
        usuarios.add(new User("Joao", 25));
        usuarios.add(new User("Maria", 30));
        //------------------------------------------------------------------//
        while (!menuLoop) {
            showMenu();
            userInput = scnInput.next();
            switch (userInput) {
                case "1":
                    showMenuBook();
                    userInput = scnInput.next();
                    switch (userInput) {
                        case "1":
                            addBookToArray();
                            break;
                        case "2":
                            loanBook();
                            break;
                        case "3":
                            returnBook();
                            break;
                        case "4":
                            showBooksArray();
                            break;

                    }
                    break;

                case "2":
                    showMenuUsers();
                    userInput = scnInput.next();
                    switch (userInput) {
                        case "1":
                            addUserToArray();
                            break;
                        case "2":
                            showAllUsers();
                            break;
                        case "3":

                            break;
                    }
                    break;

                default:
                    if (userInput.equals("0")) {
                        System.out.println("A fechar ...");
                    }
                    menuLoop = true;
                    break;

            }
        }
    }

    //------------------------------------------------------------------//
    public static void showMenu() {
        System.out.println("\n  Biblioteca");
        System.out.println("    Menu");
        System.out.println("+----------+");
        System.out.println("1- Menu Livros");
        System.out.println("2- Menu Utilizadores");
        System.out.println("0- Sair");
        System.out.println("+----------+");
        System.out.print("-> ");
    }

    //------------------------------------------------------------------//
    public static void showMenuBook() {
        System.out.println("    Menu Livros");
        System.out.println("+----------+");
        System.out.println("1- Adicionar livros");
        System.out.println("2- Emprestar livros");
        System.out.println("3- Devolver livros");
        System.out.println("4- Ver livros");
        System.out.println("+----------+");
        System.out.print("-> ");
    }

    public static void addBookToArray() {
        System.out.print("Insira o nome do livro: ");
        scnInput.nextLine();
        String bookName = scnInput.nextLine();
        System.out.print("Insira a quantidade em stock: ");
        int bookStock = scnInput.nextInt();
        livros.add(new Book(bookName, bookStock));
        System.out.print("Adicionado com sucesso: " + livros.get(livros.size() - 1).getTitle() + ", ");
        System.out.println(livros.get(livros.size() - 1).getStock());
    }

    public static void showBooksArray() {
        for (int i = 0; i < livros.size(); i++) {
            System.out.print(i + "-" + livros.get(i).getTitle() + ", ");
            System.out.println(livros.get(i).getStock());
        }
    }

    public static void loanBook() {
        System.out.println("Emprestar Livros");
        showBooksArray();
        System.out.println("Inserir numero do livro: ");
        System.out.print("->");
        int choiceBook = scnInput.nextInt();
        Book selectBook = livros.get(choiceBook);

        System.out.println("+----------+");
        showAllUsers();
        System.out.println("Inserir numero do usuario: ");
        System.out.print("->");
        int numUser = scnInput.nextInt();

        selectBook.loanBook(usuarios.get(numUser).getName());
    }
    public static void returnBook(){
        System.out.println("Devolver Livros");
        showAllUsers();
        System.out.println("Inserir numero do usuario: ");
        System.out.print("->");
        int numUser = scnInput.nextInt();
        System.out.println("+----------+");
        showBooksArray();
        System.out.println("Inserir numero do livro: ");
        System.out.print("->");
        int choiceBook = scnInput.nextInt();
        Book selectBook = livros.get(choiceBook);
        System.out.println("+----------+");

        selectBook.returnBook(usuarios.get(numUser).getName());
    }

    //------------------------------------------------------------------//
    public static void showMenuUsers() {
        System.out.println("    Menu Utilizadores");
        System.out.println("+----------+");
        System.out.println("1- Adicionar utilizador");
        System.out.println("2- Consultar utilizadores");
        System.out.println("3- Consultar utilizadores com livros");
        System.out.println("+----------+");
        System.out.print("-> ");
    }

    public static void addUserToArray() {
        System.out.print("Insira o primeiro nome do utilizador: ");
        scnInput.nextLine();
        String nameUser = scnInput.nextLine();
        System.out.print("Insira a idade do utilizador: ");
        int ageUser = scnInput.nextInt();
        usuarios.add(new User(nameUser, ageUser));
        System.out.print("Adicionado com sucesso: " + usuarios.get(usuarios.size() - 1).getName() + ", ");
        System.out.println(usuarios.get(usuarios.size() - 1).getAge());
    }

    public static void showAllUsers() {
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.print(i + "-" + usuarios.get(i).getName() + ", ");
            System.out.println(usuarios.get(i).getAge());
        }
    }
}