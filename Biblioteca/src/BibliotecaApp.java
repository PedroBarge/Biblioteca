import java.util.Scanner;
import java.util.ArrayList;

public class BibliotecaApp {
    //------------------------------------------------------------------//
    static Scanner scnInput = new Scanner(System.in);
    //------------------------------------------------------------------//
    static ArrayList<Book> livros = new ArrayList<>();
    static ArrayList<User> utilizadores = new ArrayList<>();
    //static Library library = new Library();

    //------------------------------------------------------------------//
    public static void main(String[] args) {
        int menuLoop = 1;
        //------------------------------------------------------------------//
        int userInput;
        //------------------------------------------------------------------//
        livros.add(new Book("Os Lusiadas", 5));
        livros.add(new Book("Harry Potter", 3));
        utilizadores.add(new User("Pedro Barge", 21));
        utilizadores.add(new User("Maria Paula", 30));
        //------------------------------------------------------------------//
        while (menuLoop != 0) {
            System.out.println("Hello");
            System.out.println("\nAPP NA VISTA DE ADM");
            try {
                showMenu();
                userInput = scnInput.nextInt();
                switch (userInput) {
                    case 1:
                        cleanConsole();
                        showMenuBook();
                        userInput = scnInput.nextInt();
                        switch (userInput) {
                            case 1:
                                cleanConsole();
                                addBookToArray();
                                break;
                            case 2:
                                cleanConsole();
                                removeBookFromArray();
                                break;
                            case 3:
                                cleanConsole();
                                loanBook();
                                break;
                            case 4:
                                cleanConsole();
                                returnBook();
                                break;
                            case 5:
                                cleanConsole();
                                showBooksArray();
                                break;
                        }
                        break;
                    case 2:
                        cleanConsole();
                        showMenuUsers();
                        userInput = scnInput.nextInt();
                        switch (userInput) {
                            case 1:
                                cleanConsole();
                                addUserToArray();
                                break;
                            case 2:
                                cleanConsole();
                                removeUserFromArray();
                                break;
                            case 3:
                                cleanConsole();
                                showAllUsers();
                                break;
                            case 4:
                                cleanConsole();
                                showAllUsersWithBook();
                                break;
                        }
                        break;
                    case 0:
                        menuLoop = 0;
                        System.out.println("A fechar ...");
                        cleanConsole();
                        break;
                    default:
                        cleanConsole();
                        break;
                }
            } catch (Exception e) {
                cleanConsole();
                scnInput.next();
                System.out.println("Ocorreu um erro...");
                System.out.println("A voltar ao menu principal...");
            }
        }
    }

    //------------------------------------------------------------------//
    public static void cleanConsole() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }

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
        try {
            System.out.println("    Menu Livros");
            System.out.println("+----------+");
            System.out.println("1- Adicionar livro");
            System.out.println("2- Remover Livro");
            System.out.println("3- Emprestar livros");
            System.out.println("4- Devolver livros");
            System.out.println("5- Ver livros");
            System.out.println("+----------+");
            System.out.print("-> ");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro...");
            System.out.println("A voltar ao menu principal...");
            showMenu();
        }
    }

    public static void addBookToArray() {
        try {
            System.out.println("Adicionar um livro a Biblioteca");
            System.out.print("Insira o nome do livro: ");
            scnInput.nextLine();
            String bookName = scnInput.nextLine();
            System.out.print("Insira a quantidade em stock: ");
            int bookStock = scnInput.nextInt();

            System.out.println("Tem a certeza que quer adicionar este livero?");
            System.out.println("Sim[S]          Não[N]");
            String choiceYesNo = scnInput.next().toUpperCase();
            if (choiceYesNo.equals("S")) {
                livros.add(new Book(bookName, bookStock));
                System.out.print("Adicionado com sucesso: " + livros.get(livros.size() - 1).getTitle() + ", ");
                System.out.println(livros.get(livros.size() - 1).getStock());
            } else {
                System.out.println("Livro não foi adicionado");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro...");
            System.out.println("A voltar ao menu principal...");
            showMenu();
        }
    }

    public static void removeBookFromArray() {
        try {
            System.out.println("Remover um Livro da Biblioteca");
            showBooksArray();
            System.out.println("Inserir o ID do livro");
            int bookToRemove = scnInput.nextInt();

            System.out.println("Tem a certeza que quer remover este livero?");
            System.out.println("Sim[S]          Não[N]");
            String choiceYesNo = scnInput.next().toUpperCase();
            if (choiceYesNo.equals("S")) {
                if (bookToRemove >= 0) {
                    livros.remove(bookToRemove);
                }
            } else {
                System.out.println("Livro não foi removido");
            }
            showBooksArray();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro...");
            System.out.println("A voltar ao menu principal...");
            showMenu();
        }
    }

    public static void showBooksArray() {
        System.out.println("Consultar todos os livros da Biblioteca");
        for (int i = 0; i < livros.size(); i++) {
            System.out.print("ID:" + i + " \n" + livros.get(i).getTitle() + " -Stock:");
            System.out.println(livros.get(i).getStock());
        }
    }

    public static void loanBook() {
        try {
            System.out.println("Emprestar Livros");
            showBooksArray();
            int choiceBook;
            Book selectBook;

            System.out.println("Inserir numero do livro: ");
            System.out.print("->");
            choiceBook = scnInput.nextInt();
            selectBook = livros.get(choiceBook);

            System.out.println("+----------+");

            showAllUsers();
            System.out.println("Inserir ID do utilizador: ");
            System.out.print("->");
            int numUser = scnInput.nextInt();

            selectBook.loanBook(utilizadores.get(numUser).getName());

        } catch (Exception e) {
            System.out.println("Ocorreu um erro...");
            System.out.println("A voltar ao menu principal...");
        }

    }

    public static void returnBook() {
        try {
            System.out.println("Devolver Livros");
            showAllUsersWithBook();
            showAllUsers();
            System.out.println("\nInserir ID do utilizador: ");
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

        } catch (Exception e) {
            System.out.println("Ocorreu um erro...");
            System.out.println("A voltar ao menu principal...");
        }
    }


    //------------------------------------------------------------------//
    public static void showMenuUsers() {
        try {
            System.out.println("    Menu Utilizadores");
            System.out.println("+----------+");
            System.out.println("1- Adicionar utilizador");
            System.out.println("2- Remover utilizador");
            System.out.println("3- Consultar utilizadores");
            System.out.println("4- Consultar utilizadores com livros");
            System.out.println("+----------+");
            System.out.print("-> ");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro...");
            System.out.println("A voltar ao menu principal...");
            showMenu();
        }
    }

    public static void addUserToArray() {
        try {
            System.out.println("Adicionar Clientes");
            System.out.print("Insira o primeiro nome do cliente: ");
            scnInput.nextLine();
            String nameUser = scnInput.nextLine();
            System.out.print("Insira a idade do cliente: ");
            int ageUser = scnInput.nextInt();

            System.out.println("Tem a certeza que quer adicionar este cliente?");
            System.out.println("Sim[S]          Não[N]");
            String choiceYesNo = scnInput.next().toUpperCase();
            if (choiceYesNo.equals("S")) {
                utilizadores.add(new User(nameUser, ageUser));
                System.out.print("Adicionado com sucesso: " + utilizadores.get(utilizadores.size() - 1).getName() + ", ");
                System.out.println(utilizadores.get(utilizadores.size() - 1).getAge());
            } else {
                System.out.println("Cliente não foi adicionado");
            }
            showAllUsers();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro...");
            System.out.println("A voltar ao menu principal...");
            showMenu();
        }
    }

    public static void removeUserFromArray() {
        try {
            System.out.println("Remover cliente desta Biblioteca");
            showAllUsers();
            System.out.println("Inserir o ID do cliente");
            int toRemove = scnInput.nextInt();

            System.out.println("Tem a certeza que quer adicionar este cliente?");
            System.out.println("Sim[S]          Não[N]");
            String choiceYesNo = scnInput.next().toUpperCase();
            if (choiceYesNo.equals("S")) {
                if (toRemove >= 0) {
                    utilizadores.remove(toRemove);
                } else System.out.println("Escolha invalida");
            } else {
                System.out.println("Cliente não foi removido");
            }
            showAllUsers();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro...");
            System.out.println("A voltar ao menu principal...");
            showMenu();
        }
    }

    public static void showAllUsers() {
        System.out.println("\nConsultar todos os clientes");
        for (int i = 0; i < utilizadores.size(); i++) {
            System.out.print("ID:" + i + "\nNome: " + utilizadores.get(i).getName() + "\nIdade: ");
            System.out.println(utilizadores.get(i).getAge());
        }
    }

    public static void showAllUsersWithBook() {
        System.out.println("Todos os livros que foram emprestados aos clientes");
        for (int i = 0; i < livros.size(); i++) {
            System.out.print(livros.get(i).getUserWithBook());
        }
    }
}