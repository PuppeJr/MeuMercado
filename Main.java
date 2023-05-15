import java.util.Scanner;
import java.util.ArrayList;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



class Produto {

    public Produto(String nomeCadastro, String tipoCadastro, double valorCadastro, int estoqueCadastro) {
    }
    // Definição da classe Produto (mesmo código anterior)

    // ...
}


class Supermercado {
    private ArrayList<Produto> produtos;

    public Supermercado() {
        produtos = new ArrayList<Produto>();
    }

    public void listarProdutos() {
        for (Produto p : produtos) {
            System.out.println(p);
        }
    }

    public void buscarProdutoPorNome(String nomeBusca) {
        // busca produto por nome
    }

    public void buscarProdutoPorTipo(String tipoBusca) {
        // busca produto por tipo
    }

    public void cadastrarProduto(String nomeCadastro, String tipoCadastro, double valorCadastro, int estoqueCadastro) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermercado", "username", "password");
            String sql = "INSERT INTO produtos (nome, tipo, valor, estoque) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nomeCadastro);
            stmt.setString(2, tipoCadastro);
            stmt.setDouble(3, valorCadastro);
            stmt.setInt(4, estoqueCadastro);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar produto: " + e.getMessage());
           // Onde "username" e "password" devem ser substituídos pelas credenciais de acesso ao banco de dados MySql.
        }
    }

    // ...
}

    public void excluirProduto(String nomeExclusao) {
        // exclui produto pelo nome
    }

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
                    extracted(supermercado, nomeExclusao);
                    break;
            }
        }
    }

    private static void extracted(Supermercado supermercado, String nomeExclusao) {
        supermercado.excluirProduto(nomeExclusao);
    }
}