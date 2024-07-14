import model.*;
import repository.*;
import Enums.*;

import java.util.Scanner;
import java.util.List;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static AbrigoRepository abrigoRepository = new AbrigoRepository();
    private static CentroDistribuicaoRepository centroDistribuicaoRepository = new CentroDistribuicaoRepository();
    private static DoacaoRepository doacaoRepository = new DoacaoRepository();
    private static OrdemPedidoRepository ordemPedidoRepository = new OrdemPedidoRepository();
    private static TransferenciaRepository transferenciaRepository = new TransferenciaRepository();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Criar Abrigo");
            System.out.println("2. Listar Abrigos");
            System.out.println("3. Deletar Abrigo");
            System.out.println("4. Listar Centros de Distribuição");
            System.out.println("5. Criar Doação");
            System.out.println("6. Listar Doações");
            System.out.println("7. Deletar Doações");
            System.out.println("8. Adicionar Ordem de Pedido");
            System.out.println("9. Listar Ordens de Pedido");
            System.out.println("10. Adicionar Transferência");
            System.out.println("11. Listar Transferências");
            System.out.println("12. Importar Dados CSV");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (opcao) {
                case 1:
                    criarAbrigo();
                    break;
                case 2:
                    listarAbrigos();
                    break;
                case 3:
                    deletarAbrigo();
                    break;
                case 4:
                    listarCentrosDistribuicao();
                    break;
                case 5:
                    criarDoacao();
                    break;
                case 6:
                    listarDoacoes();
                    break;
                case 7:
                    deletarDoacoes();
                    break;
                case 8:
                    adicionarOrdemPedido();
                    break;
                case 9:
                    listarOrdemPedidos();
                    break;
//                case 10:
//                    adicionarTransferencia();
//                    break;
                case 11:
                    listarTransferencias();
                    break;
                case 12:
                    importarDadosCSV();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void criarAbrigo() {
        System.out.println("\n--- Criar Abrigo ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Responsável: ");
        String responsavel = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Capacidade: ");
        int capacidade = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Abrigo abrigo = new Abrigo();
        abrigo.setNome(nome);
        abrigo.setEndereco(endereco);
        abrigo.setResponsavel(responsavel);
        abrigo.setTelefone(telefone);
        abrigo.setEmail(email);
        abrigoRepository.save(abrigo);
        System.out.println("Abrigo criado com sucesso!");
    }

    private static void listarAbrigos() {
        System.out.println("\n--- Listar Abrigos ---");
        List<Abrigo> abrigos = abrigoRepository.findAll();
        for (Abrigo abrigo : abrigos) {
            System.out.println(abrigo);
        }
    }

    private static void deletarAbrigo() {
        System.out.println("\n--- Deletar Abrigo ---");
        System.out.print("ID do Abrigo: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        abrigoRepository.delete(id);
        System.out.println("Abrigo deletado com sucesso!");
    }

    private static void listarCentrosDistribuicao() {
        System.out.println("\n--- Listar Centros de Distribuição ---");
        List<CentroDistribuicao> centros = centroDistribuicaoRepository.findAll();
        for (CentroDistribuicao centro : centros) {
            System.out.println(centro);
        }
    }

    private static void criarDoacao() {
        System.out.println("\n--- Criar Doação ---");
        System.out.print("Tipo (ROUPA, PRODUTO_HIGIENE, ALIMENTO): ");
        Tipo tipo = Tipo.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        Genero genero = null;
        Tamanho tamanho = null;
        UnidadeMedida unidadeMedida = null;
        String validade = null;

        if (tipo == Tipo.ROUPA) {
            System.out.print("Gênero (MASCULINO, FEMININO): ");
            genero = Genero.valueOf(scanner.nextLine().toUpperCase());
            System.out.print("Tamanho (INFANTIL, PP, P, M, G, GG): ");
            tamanho = Tamanho.valueOf(scanner.nextLine().toUpperCase());
        } else if (tipo == Tipo.PRODUTO_HIGIENE || tipo == Tipo.ALIMENTO) {
            System.out.print("Unidade de Medida (QUILO, GRAMAS, LITRO): ");
            unidadeMedida = UnidadeMedida.valueOf(scanner.nextLine().toUpperCase());
            System.out.print("Validade: ");
            validade = scanner.nextLine();
        }

        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("ID do Centro de Distribuição: ");
        int centroId = scanner.nextInt();
        scanner.nextLine();
        CentroDistribuicao centro = centroDistribuicaoRepository.findById(centroId);

        if (centro == null) {
            System.out.println("Centro de distribuição não encontrado.");
            return;
        }

        Doacao doacao = new Doacao(tipo, descricao, genero, tamanho, unidadeMedida, quantidade, validade);
        doacao.setCentroDistribuicaoId(centroId);

        if (!centroDistribuicaoRepository.podeAdicionarDoacao(centro, doacao)) {
            System.out.println("Capacidade do centro de distribuição excedida para este tipo de item.");
            return;
        }

        centroDistribuicaoRepository.adicionarDoacao(centro, doacao);
        doacaoRepository.save(doacao);
        System.out.println("Doação criada com sucesso!");
    }
    private static void listarDoacoes() {
        System.out.println("\n--- Listar Doações ---");
        List<Doacao> doacoes = doacaoRepository.findAll();
        for (Doacao doacao : doacoes) {
            System.out.println(doacao);
        }
    }

    private static void deletarDoacoes() {
        System.out.println("\n--- Deletar Doações ---");
        System.out.print("ID da Doação: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        doacaoRepository.delete(id);
        System.out.println("Doação deletada com sucesso!");
    }

    private static void adicionarOrdemPedido() {
        System.out.println("\n--- Adicionar Ordem de Pedido ---");
        System.out.print("ID do Abrigo: ");
        int abrigoId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Itens Necessários (separados por vírgula): ");
        String itens = scanner.nextLine();
        List<String> itensNecessarios = List.of(itens.split(","));

        OrdemPedido ordemPedido = new OrdemPedido();
        ordemPedido.setItensNecessarios(itensNecessarios);
        ordemPedidoRepository.save(ordemPedido);
        System.out.println("Ordem de Pedido adicionada com sucesso!");
    }

    private static void listarOrdemPedidos() {
        System.out.println("\n--- Listar Ordens de Pedido ---");
        List<OrdemPedido> ordens = ordemPedidoRepository.findAll();
        for (OrdemPedido ordem : ordens) {
            System.out.println(ordem);
        }
    }

    private static void adicionarTransferencia() {
        System.out.println("\n--- Adicionar Transferência ---");
        System.out.print("ID de Origem: ");
        int origemId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("ID de Destino: ");
        int destinoId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Descrição dos Itens: ");
        String descricaoItens = scanner.nextLine();

        Transferencia transferencia = new Transferencia();
        transferencia.setOrigemId(origemId);
        transferencia.setDestinoId(destinoId);
        transferencia.setDescricaoItens(descricaoItens);
        transferenciaRepository.save(transferencia);
        System.out.println("Transferência adicionada com sucesso!");
    }

    private static void listarTransferencias() {
        System.out.println("\n--- Listar Transferências ---");
        List<Transferencia> transferencias = transferenciaRepository.findAll();
        for (Transferencia transferencia : transferencias) {
            System.out.println(transferencia);
        }
    }

    private static void importarDadosCSV() {
        System.out.println("\n--- Importar Dados CSV ---");
        System.out.print("Caminho do Arquivo CSV: ");
        String filePath = scanner.nextLine();
        doacaoRepository.importFromCsv(filePath);
        System.out.println("Dados importados com sucesso!");
    }
}
