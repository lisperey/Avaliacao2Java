public class Venda {
    private Produto produto;
    private Vendedor vendedor;
    private  Double desconto;
    private Integer quantidadeItens;
    private Double valor;



    //Getters Setters



    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }


    public Vendedor getVendedor() {
        return vendedor;
    }
    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }


    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }


    public Integer getQuantidadeItens() {
        return quantidadeItens;
    }
    public void setQuantidadeItens(Integer quantidadeItens) {
        this.quantidadeItens = quantidadeItens;
    }


    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }



    //End of Getters Setters


    //Methods


    public Double calcularValor(){
        Integer quantidadeItens = getQuantidadeItens();
        Double valorVenda = produto.getValorVenda();
        Double valorTotal = quantidadeItens*valorVenda;

        if(produto.getPromocao()){
            valorTotal = valorTotal-efetuarDesconto();
            if(valorTotal == 0.0 && valorTotal<produto.getValorCusto()){
                System.out.println("Valor total não definido.");
                return 0.0;
            }
            else {
                return valorTotal;
            }
        }

        else{
            if(valorTotal == 0.0 && valorTotal<produto.getValorCusto()){
                System.out.println("Valor total não definido.");
                return 0.0;
            }
            else {
                return valorTotal;
            }
        }

    }

    public Double calcularComissao(){
        Double comissao= calcularValor() * (vendedor.getPorcetagem()/100);
        if(produto.getPromocao()){
            comissao = comissao/2;
            return comissao;
        }
        else {
            return comissao;
        }

    }

    public Double efetuarDesconto(){
        if(getDesconto() == null){
            return  0.0;
        }
        else {
            Double desconto = getDesconto();
            Double porcDes = desconto/100;
            Double calcDes = porcDes*produto.getValorVenda()*quantidadeItens;
            return calcDes;

        }

    }

    public void imprimir(){

        System.out.println("Vendedor: " + vendedor.getNome() +
                ".\nCódigo do Vendedor: " + vendedor.getCodigo() +
                ".\nComissão da venda: R$" + calcularComissao() + ".");

        System.out.println("Quantidade de itens vendidos: " + getQuantidadeItens() + ".");

        System.out.println("Produto: " + produto.getCodigo() +
                ".\nDescrição: " + produto.getDescricao() + ".");

        System.out.println("Valor de venda: R$" + produto.getValorVenda() + ".");

        if(produto.getPromocao()){
            System.out.println("Desconto: Sim. ");
        }
        else {
            System.out.println("Desconto: Não.");
        }

        System.out.println("Valor do desconto: R$" + efetuarDesconto() + ".");

        System.out.println("Valor total da venda: R$" + calcularValor() + ".");

        System.out.println("");

    }
}
