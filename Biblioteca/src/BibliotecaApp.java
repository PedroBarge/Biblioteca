import java.awt.print.Book;
import java.util.Scanner;
import java.util.ArrayList;

public class BibliotecaApp {
    static boolean menuLoop = false;

    static Scanner scnInput = new Scanner(System.in);
    static String userInput;

    static String name;
    static int stockAge;

    public static void main(String[] args) {
        //Pre add
        Book addBook = new Book();
        ArrayList<Livro> livros = new ArrayList<>();
        livros.add(new Livro("Dom Casmurro", 5));
        livros.add(new Livro("A Revolução dos Bichos", 3));

        ArrayList<User> usuarios = new ArrayList<>();
        usuarios.add(new User("Joao", 25));
        usuarios.add(new User("Maria", 30));

        while (!menuLoop) {
            showMenu();
            userInput = scnInput.next();
            switch (userInput) {
                case "1":
                    showMenuBook();
                    userInput = scnInput.next();
                    if (userInput.equals("1")) {
                        System.out.print("Insira o nome do livro: ");
                        name = scnInput.next();
                        System.out.print("Insira a quantidade em estoque: ");
                        stockAge = scnInput.nextInt();
                        livros.add(new Livro(name, stockAge));
                    }
                    if (userInput.equals("2")){
                        System.out.println("Emprestar Livros");
                        System.out.println(livros.toString());
                    }

                    break;
                case "2":
                    showMenuUsers();
                    break;
                default:
                    if (userInput.equals("0")) {
                        System.out.println("A fechar ...");
                    }
                    menuLoop = true;
                    break;

            }
        }

        Livro livroSelecionado = livros.get(1);
        livroSelecionado.emprestarLivro(usuarios.get(0).getNome());
        livroSelecionado.emprestarLivro(usuarios.get(1).getNome());
        livroSelecionado.devolverLivro(usuarios.get(0).getNome());
        livroSelecionado.devolverLivro(usuarios.get(0).getNome());
    }

    public static void showMenu(){
        System.out.println("        Biblioteca");
        System.out.println("    Menu");
        System.out.println("+----------+");
        System.out.println("1- Menu Livros");
        System.out.println("2- Menu Utilizadores");
        System.out.println("0- Sair");
        System.out.println("+----------+");
        System.out.print("->");
    }
    public static void showMenuBook(){
        System.out.println("    Menu Livros");
        System.out.println("+----------+");
        System.out.println("1- Adicionar livros");
        System.out.println("2- Emprestar livros");
        System.out.println("3- Devolver livros");
        System.out.println("4- Ver livros");
        System.out.println("+----------+");
        System.out.print("->");
    }
    public static void showMenuUsers(){
        System.out.println("    Menu Utilizadores");
        System.out.println("+----------+");
        System.out.println("1- Adicionar utilizador");
        System.out.println("2- Consultar utilizadores");
        System.out.println("3- Consultar utilizadores com livros");
        System.out.println("+----------+");
        System.out.print("->");
    }
}