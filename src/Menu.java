import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static ArrayList<Vendedor> vendedores = new ArrayList<>();
    public static ArrayList<Venda> vendas = new ArrayList<>();
    public static ArrayList<Produto> produtos = new ArrayList<>();
    public static Scanner leitor;

    public static void menu() {
        leitor = new Scanner(System.in);
        int opcao = 0;
        System.out.println("1 - Cadastrar um vendedor.");
        System.out.println("2 - Cadastrar um produto.");
        System.out.println("3 - Cadastrar uma venda.");
        System.out.println("4 - Exibir resulmo de uma venda.");
        System.out.println("100 - Sair.");
        try{
            opcao = leitor.nextInt();

        }catch (InputMismatchException i){
            System.out.println("Ocorreu um erro..." +
                    "Escolha uma opção válida!");
            menu();



        }


        switch (opcao) {
            case 1:
                cadastrarVendedor();
                break;
            case 2:
                cadastrarProduto();
                break;
            case 3:
                cadastrarVenda();
                break;
            case 4:
                vendas();
                break;
            case 100:
                System.exit(0);
                break;
            default:
                System.out.println("Opção invalida.");
                menu();
                break;
        }

        }




    public static void cadastrarVendedor() {

        leitor = new Scanner(System.in);

        System.out.println("Informe o nome do vendedor:");
        String vNome = leitor.nextLine();
        System.out.println("Informe o código do vendedor:");
        String vCodigo = leitor.nextLine();
        System.out.println("Informe o endereco do vendedor:");
        String vEndereco = leitor.nextLine();
        Vendedor vendedor = new Vendedor(vNome, vCodigo, vEndereco);
        System.out.println("Deseja cadastrar o vendedor: " + vNome + ", codigo: " + vCodigo + ", endereço: " + vEndereco + "?" +
                "\ns-Sim/n-Não");
        String confirmar = leitor.next();
        if (confirmar.toLowerCase().equalsIgnoreCase("s")) {
            System.out.println("..." +
                    "Vendedor cadastrado com sucesso.");
            vendedores.add(vendedor);
            System.out.println("1- Menu principal." +
                    "\n2- Cadastrar novo vendedor." +
                    "\n3- Sair.");
            int opcaoFim = leitor.nextInt();
            switch(opcaoFim){
                case 1:
                    menu();
                    break;
                case 2:
                    cadastrarVendedor();
                    break;
                case 3:
                    System.exit(0);
                    break;

            }
        } else {
            if(confirmar.toLowerCase().equalsIgnoreCase("n")){
                System.out.println("Vendedor não cadastrado.");
                System.out.println("1- Menu principal." +
                        "\n2- Cadastrar vendedor." +
                        "\n3- Sair.");
                int opcaoErro = leitor.nextInt();
                switch(opcaoErro){
                    case 1:
                        menu();
                        break;
                    case 2:
                        cadastrarVendedor();
                        break;
                    case 3:
                        System.exit(0);
                        break;

                }
            }
            else{
                System.out.println("Error...");
                System.out.println("1- Menu principal." +
                        "\n2- Cadastrar vendedor." +
                        "\n3- Sair.");
                int opcaoErro = leitor.nextInt();
                switch(opcaoErro){
                    case 1:
                        menu();
                        break;
                    case 2:
                        cadastrarVendedor();
                        break;
                    case 3:
                        System.exit(0);
                        break;

                }

            }


        }


    }

    public static void cadastrarProduto() {

        leitor = new Scanner(System.in);
        try{
            System.out.println("Informe o código do produto:");
            String pCode = leitor.nextLine();
            System.out.println("Descrição do produto:");
            String pDescription = leitor.nextLine();
            System.out.println("Informe o valor venda do produto:");
            Double pValorVenda = leitor.nextDouble();
            System.out.println("Informe o valor custo do produto:");
            Double pValorCusto = leitor.nextDouble();
            System.out.println("Produto em promoção? true-sim/false-não");
            Boolean pPromocao = leitor.nextBoolean();
            Produto produto = new Produto(pCode, pDescription, pValorVenda, pValorCusto, pPromocao);
            System.out.println("Deseja cadastrar o produto código: " + pCode + ", descrição: " + pDescription +
                    ", valor venda: " + pValorVenda + ", valor custo: " + pValorCusto + " e promoção: " + pPromocao + "?" +
                    "\ns-Sim/n-Não");
            String confirmar = leitor.next();
            if (confirmar.toLowerCase().equalsIgnoreCase("s")) {
                System.out.println("..." +
                        "Produto cadastrado com sucesso.");
                produtos.add(produto);
                System.out.println("1- Menu principal." +
                        "\n2- Cadastrar novo produto." +
                        "\n3- Sair.");
                int opcaoFim = leitor.nextInt();
                switch(opcaoFim){
                    case 1:
                        menu();
                        break;
                    case 2:
                        cadastrarProduto();
                        break;
                    case 3:
                        System.exit(0);
                        break;

                }
            } else {
                if(confirmar.toLowerCase().equalsIgnoreCase("n")){
                    System.out.println("Produto não cadastrado.");
                    System.out.println("1- Menu principal." +
                            "\n2- Cadastrar produto." +
                            "\n3- Sair.");
                    int opcaoErro = leitor.nextInt();
                    switch(opcaoErro){
                        case 1:
                            menu();
                            break;
                        case 2:
                            cadastrarProduto();
                            break;
                        case 3:
                            System.exit(0);
                            break;

                    }
                }
                else{
                    System.out.println("Error...");
                    System.out.println("1- Menu principal." +
                            "\n2- Cadastrar Produto." +
                            "\n3- Sair.");
                    int opcaoErro = leitor.nextInt();
                    switch(opcaoErro){
                        case 1:
                            menu();
                            break;
                        case 2:
                            cadastrarProduto();
                            break;
                        case 3:
                            System.exit(0);
                            break;

                    }

                }


            }


        } catch (InputMismatchException i){
            System.out.println("Ocorreu um erro...");
            System.out.println("Voltando para o menu.");
            menu();
        }


    }

    public static void cadastrarVenda() {

        Venda venda = new Venda();
        leitor = new Scanner(System.in);
        if(vendedores.size()==0){
            System.out.println("Para fazer uma venda precisa ter pelo menos um vendedor cadastrado.");
            menu();
        } else if (produtos.size()==0) {
            System.out.println("Para fazer uma venda precisa ter pelo menos um produto cadastrado.");
            menu();

        }

        try {
            System.out.println("Informe o código do vendedor:");
            String vVendedor = leitor.nextLine();
            for (int i = 0; i < vendedores.size(); i++) {
                Vendedor v = vendedores.get(i);

                if (v.getCodigo().equalsIgnoreCase(vVendedor)) {
                    venda.setVendedor(v);
                    System.out.println("Informe a porcentagem do vendedor:");
                    Double vPorcentagem = leitor.nextDouble();
                    v.setPorcetagem(vPorcentagem);
                }
            }
            leitor.nextLine();
            System.out.println("Informe o código do produto:");
            String vProduto = leitor.nextLine();
            for (int i = 0; i < produtos.size(); i++) {
                Produto p = produtos.get(i);

                if (p.getCodigo().equalsIgnoreCase(vProduto)) {
                    venda.setProduto(p);
                    if (p.getPromocao()) {
                        System.out.println("Informe a porcetagem do desconto:");
                        Double vDesconto = leitor.nextDouble();
                        venda.setDesconto(vDesconto);
                    } else {
                        continue;
                    }
                }
            }
            System.out.println("Informe a quantidade de itens:");
            int vQuatidade = leitor.nextInt();
            venda.setQuantidadeItens(vQuatidade);


            System.out.println("Deseja cadastrar a venda no valor: R$" + venda.calcularValor() + ", do produto codigo:" +
                    " " + venda.getProduto().getCodigo() + ", do vendedor do código: " +
                    "" + venda.getVendedor().getCodigo() + "?" +
                    "\ns-Sim/n-Não");
            String confirmar = leitor.next();
            if (confirmar.equalsIgnoreCase("s")) {

                vendas.add(venda);

                System.out.println("Venda código: " +(vendas.size()-1)+" cadastrada com sucesso.");
                System.out.println("1- Menu principal." +
                        "\n2- Nova venda." +
                        "\n3- Sair.");
                int opcaoVenda = leitor.nextInt();
                switch(opcaoVenda){
                    case 1:
                        menu();
                        break;
                    case 2:
                        cadastrarVenda();
                        break;
                    case 3:
                        System.exit(0);
                        break;

                }

            } else {
                if(confirmar.toLowerCase().equalsIgnoreCase("n")){
                    System.out.println("Venda não confirmada.");
                    System.out.println("1- Menu principal." +
                            "\n2- Venda." +
                            "\n3- Sair.");
                    int opcaoErro = leitor.nextInt();
                    switch(opcaoErro){
                        case 1:
                            menu();
                            break;
                        case 2:
                            cadastrarVenda();
                            break;
                        case 3:
                            System.exit(0);
                            break;

                    }
                }
                else {
                    System.out.println("Error...");
                    System.out.println("1- Menu principal." +
                            "\n2- Venda." +
                            "\n3- Sair.");
                    int opcaoErro = leitor.nextInt();
                    switch (opcaoErro) {
                        case 1:
                            menu();
                            break;
                        case 2:
                            cadastrarVenda();
                            break;
                        case 3:
                            System.exit(0);
                            break;

                    }
                }

            }
        } catch (InputMismatchException i){
            System.out.println("Ocorreu um erro...");
            System.out.println("Voltando para o menu");
            menu();

        } catch (NullPointerException n){
            System.out.println("Ocorreu um erro...");
            System.out.println("Algum dado informado é invalido.");
            System.out.println("1- Menu principal." +
                    "\n2- Venda." +
                    "\n3- Sair.");

            int a = leitor.nextInt();
            switch (a){
                case 1:
                    menu();
                    break;
                case 2:
                    cadastrarVenda();
                case 3:
                    System.exit(0);
                    break;

            }
        }
    }



    public static void vendas(){

        System.out.println("Informe o código da venda: ");
        try{
            int nVenda = leitor.nextInt();
            Venda n = vendas.get(nVenda);
            n.imprimir();

            System.out.println("1- Menu principal." +
                    "\n2- Resulmo de venda." +
                    "\n3- Sair.");
            int opcaoErro = leitor.nextInt();
            switch (opcaoErro) {
                case 1:
                    menu();
                    break;
                case 2:
                    vendas();
                    break;
                case 3:
                    System.exit(0);
                    break;

            }

        }
        catch(InputMismatchException i){
            System.out.println("Ocorreu um erro...");
            System.out.println("Voltando para o menu");
            menu();

        }
        catch (IndexOutOfBoundsException o){
            System.out.println("Venda não encontrada...");
            System.out.println("1- Menu principal." +
                    "\n2- Resulmo de venda." +
                    "\n3- Sair.");
            int opcaoErro = leitor.nextInt();
            switch (opcaoErro) {
                case 1:
                    menu();
                    break;
                case 2:
                    vendas();
                    break;
                case 3:
                    System.exit(0);
                    break;

            }

        }

    }
}
