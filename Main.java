import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Produto {
    // Definição da classe Produto (mesmo código anterior)

    // ...
}

class Supermercado {
    // Definição da classe Supermercado (mesmo código anterior)

    // ...
}

class Usuario {
    private String username;
    private String password;

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Supermercado supermercado = new Supermercado();

        // Criação de usuário
        Usuario usuario = new Usuario("admin", "senha123");

        // Login
        System.out.println("Digite o nome de usuário:");
        String username = scanner.nextLine();

        System.out.println("Digite a senha:");
        String password = scanner.nextLine();

        if (username.equals(usuario.getUsername()) && password.equals(usuario.getPassword())) {
            System.out.println("Login bem-sucedido!");
        } else {
            System.out.println("Credenciais inválidas. Encerrando o programa.");
            return;
        }

        // Menu do Supermercado
        boolean continuar = true;
        while (continuar) {
            System.out.println("=== MENU ===");
            System.out.println("1. Listar produtos");
            System.out.println("2. Buscar produto por nome");
            System.out.println("3. Buscar produto por tipo");
            System.out.println("4. Cadastrar produto");
            System.out.println("5. Excluir produto");
            System.out.println("6. Alterar valor de produto");
            System.out.println("7. Alterar estoque de produto");
            System.out.println("0. Sair");

            System.out.println("Digite a opção desejada:");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 0:
                    continuar = false;
                    System.out.println("Encerrando o programa.");
                    break;
                case 1:
                    supermercado.listarProdutos();
                    break;
                case 2:
                    System.out.println("Digite o nome do produto:");
                    String nomeBusca = scanner.nextLine();
                    supermercado.buscarProdutoPorNome(nomeBusca);
                    break;
                case 3:
                    System.out.println("Digite o tipo do produto:");
                    String tipoBusca = scanner.nextLine();
                    supermercado.buscarProdutoPorTipo(tipoBusca);
                    break;
                case 4:
                    System.out.println("Digite o nome do produto:");
                    String nomeCadastro = scanner.nextLine();

                    System.out.println("Digite o tipo do produto:");
                    String tipoCadastro = scanner.nextLine();

                    System.out.println("Digite o valor do produto:");
                    double valorCadastro = scanner.nextDouble();

                    System.out.println("Digite o estoque do produto:");
                    int estoqueCadastro = scanner.nextInt();
                    scanner.nextLine();

                    supermercado.cadastrarProduto(nomeCadastro, tipoCadastro, valorCadastro, estoqueCadastro);
                    break;
                case 5:
                    System.out.println("Digite o nome do produto a ser excluído:");
                    String nomeExclusao = scanner.nextLine();
                    supermercado.excluirProduto(nomeExclusao);
                    break;
            }
        }
    }
}