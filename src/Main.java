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
                case 2:
                    // cadastro usuario
                case 3:
                    //emprestimo de livro
                case 4:
                    // devolução
                case 5:
                    // listar livros disponiveis
                case 6:
                    //pesquisar usuario
                case 7:
                    //pesquisar livro
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
