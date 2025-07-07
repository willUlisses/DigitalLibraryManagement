import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();

        String login = "admin";
        String senha = "admin123";

        System.out.println("Informe seu login e senha para liberar o acesso:\n");
        Scanner scanner = new Scanner(System.in);
        String loginIn;
        String senhaIn;
        do {
            System.out.println("Login:");
            loginIn = scanner.next();
            System.out.println("Senha:");
            senhaIn = scanner.next();
            if (!loginIn.equals(login) || !senhaIn.equals(senha)){
                System.out.println(" Login ou senha incorretos, tente novamente.\n");
            } else {
                System.out.println("Login bem sucedido!\n");
                scanner.close();
            }
        } while (!loginIn.equals(login) || !senhaIn.equals(senha));

        Scanner scannerMenu = new Scanner(System.in);
        int repetir = 0;
        int opt;
        do {
            System.out.println("=== Menu Bilbioteca ===\n" +
                    "[1] Cadastrar Livro" +
                    "[2] Cadastrar Usuario" +
                    "[3] Locar um Livro" +
                    "[4] Devolver Livro" +
                    "[5] Ver Livros Disponíveis" +
                    "[6] Pesquisar Usuario" +
                    "[7] Pesquisar um Livro");
            opt = scannerMenu.nextInt();
            switch (opt) {
                case 1:
                    System.out.println("Informe o Título do livro:");
                    String titulo = scannerMenu.next();
                    System.out.println("Informe o Autor do livro:");
                    String autor = scannerMenu.next();
                    library.addBook(new Book(titulo, autor));
                    break;
                case 2:
                    System.out.println("Informe o Nome do Usuário:");
                    String nome = scannerMenu.next();
                    System.out.println("Agora Informe o Email do Usuário:");
                    String email = scannerMenu.next();
                    library.registrateUser(new User(nome, email));
                    break;
                case 3:
                    System.out.println("Abaixo estão os livros disponíveis para serem locados:");
                    library.showAllBooks();
                    System.out.println("\n\nInforme o ISBN do livro que você deseja locar:");
                    String isbn = scannerMenu.next();
                    System.out.println("Agora informe o id do usuário que está locando (existem usuários com id até "
                    + library.getIdCounter());
                    Integer id = scannerMenu.nextInt();
                    library.makeLoan(isbn, id);
                    System.out.println("\nO usuário " + library.findUserById(id) + " locou o livro " + library.findByISBN(isbn) + ".");
                    break;
                case 4:
                    System.out.println("Abaixo estão os empréstimos ainda ativos:\n");
                    for (Lending emprestimo : library.getActiveLendings()) {
                        System.out.println("========================================================" + "\n" +
                                "Livro: " + emprestimo.getBook().getTitle() + "\n" +
                                "Nome do Usuário: " + emprestimo.getUser().getName() + "\n" +
                                "ID do Usuário: " + emprestimo.getUser().getUserId() + "\n" +
                                "========================================================\n");
                    }

                    System.out.println("\n\nInforme o ISBN do livro que será retornado:");
                    String isbnRetorno = scannerMenu.next();
                    System.out.println("Informe o id do usuário que locou o livro:");
                    Integer idRetorno = scannerMenu.nextInt();
                    library.returnBook(isbnRetorno,idRetorno);
                    System.out.println("\nO usuário " + library.findUserById(idRetorno) + " devolveu o livro "
                            + library.findByISBN(isbnRetorno) + ".");
                case 5:
                    System.out.println("Abaixo estão todos os livros disponíveis:\n");
                    library.showAllBooks();
                case 6:
                    System.out.println("Existem usuários com o id de 1 até " + library.getIdCounter() + ", informe" +
                            " o ID do usuário que você deseja encontrar:");
                    Integer searchID = scannerMenu.nextInt();
                    System.out.println("O Usuário encontrado foi: " + library.findUserById(searchID));
                case 7:
                    System.out.println("Escolha qual maneira você irá utilizar para encontrar o livro:\n");
                    int repeat = 1;
                    do {
                        System.out.println("[1] - Usar ISBN.\n" +
                                "[2] - Usar Título do Livro.");
                        int escolha = scannerMenu.nextInt();
                        if (escolha == 1) {
                            System.out.println("Qual o ISBN do livro que você quer encontrar?");
                            String isbnSearch = scannerMenu.next();
                            System.out.println(library.findByISBN(isbnSearch));
                            repeat = 0;
                        } else if (escolha == 2) {
                            System.out.println("Qual o Título do livro que você deseja encontrar?");
                            String titleSearch = scannerMenu.next();
                            System.out.println("O Livro encontrado foi: " + library.findByTitle(titleSearch));
                            repeat = 0;
                        } else {
                            System.out.println("Opção inválida tente novamente.\n");
                            return;
                        }
                    } while (repeat == 1);
                    break;
                case 0:
                    System.out.println("Encerrando o Programa...");
                    repetir = 1;
                    break;
                default:
                    System.out.println("Opção invalida, tente novamente");
                    break;
            }
        } while(repetir == 0);



    }
}
