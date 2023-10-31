import java.util.Scanner;
import java.util.ArrayList;

public class BibliotecaApp {
    //------------------------------------------------------------------//
    static Scanner scnInput = new Scanner(System.in);
    //------------------------------------------------------------------//
    static ArrayList<Book> livros = new ArrayList<>();
    static ArrayList<User> utilizadores = new ArrayList<>();

    //------------------------------------------------------------------//
    public static void main(String[] args) {
        boolean menuLoop = false;
        //------------------------------------------------------------------//
        String userInput;
        //------------------------------------------------------------------//
        livros.add(new Book("Os Lusiadas", 5));
        livros.add(new Book("Los Pollos Locos", 3));
        utilizadores.add(new User("Joao", 25));
        utilizadores.add(new User("Maria", 30));
        //------------------------------------------------------------------//
        while (!menuLoop) {
            System.out.println("\nAPP NA VISTA DE ADM");
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
                            removeBookFromArray();
                            break;
                        case "3":
                            loanBook();
                            break;
                        case "4":
                            returnBook();
                            break;
                        case "5":
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
                            removeUserFromArray();
                            break;
                        case "3":
                            showAllUsers();
                            break;
                        case "4":
                            showAllUsersWithBook();
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
        System.out.println("1- Adicionar livro");
        System.out.println("2- Remover Livro");
        System.out.println("3- Emprestar livros");
        System.out.println("4- Devolver livros");
        System.out.println("5- Ver livros");
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

    public static void removeBookFromArray() {
        showBooksArray();
        System.out.println("Inserir o ID do livro");
        int bookToRemove = scnInput.nextInt();
        if (bookToRemove >= 0) {
            livros.remove(bookToRemove);
        } else System.out.println("Escolha invalida");
        showBooksArray();
    }

    public static void showBooksArray() {
        for (int i = 0; i < livros.size(); i++) {
            System.out.print("ID: " + i + "-" + livros.get(i).getTitle() + ", ");
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

        selectBook.loanBook(utilizadores.get(numUser).getName());
    }

    public static void returnBook() {
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

        selectBook.returnBook(utilizadores.get(numUser).getName());
    }

    //------------------------------------------------------------------//
    public static void showMenuUsers() {
        System.out.println("    Menu Utilizadores");
        System.out.println("+----------+");
        System.out.println("1- Adicionar utilizador");
        System.out.println("2- Remover utilizador");
        System.out.println("3- Consultar utilizadores");
        System.out.println("4- Consultar utilizadores com livros");
        System.out.println("+----------+");
        System.out.print("-> ");
    }

    public static void addUserToArray() {
        System.out.print("Insira o primeiro nome do utilizador: ");
        scnInput.nextLine();
        String nameUser = scnInput.nextLine();
        System.out.print("Insira a idade do utilizador: ");
        int ageUser = scnInput.nextInt();
        utilizadores.add(new User(nameUser, ageUser));
        System.out.print("Adicionado com sucesso: " + utilizadores.get(utilizadores.size() - 1).getName() + ", ");
        System.out.println(utilizadores.get(utilizadores.size() - 1).getAge());
    }
    public static void removeUserFromArray() {
        showAllUsers();
        System.out.println("Inserir o ID do utilizador");
        int toRemove = scnInput.nextInt();
        if (toRemove >= 0) {
            utilizadores.remove(toRemove);
        } else System.out.println("Escolha invalida");
        showAllUsers();
    }

    public static void showAllUsers() {
        for (int i = 0; i < utilizadores.size(); i++) {
            System.out.print("ID: "+i + " Nome: " + utilizadores.get(i).getName() + ", ");
            System.out.println(utilizadores.get(i).getAge());
        }
    }

    public static void showAllUsersWithBook() {
        for (int i = 0; i < livros.size(); i++) {
            System.out.print(i + "-" + livros.get(i).getUserWithBook());
        }
    }
}