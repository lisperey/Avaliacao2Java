public class Vendedor {
    String nome;
    private String codigo;
    private Double porcetagem;
    private String endereco;

    public Vendedor(String nome, String codigo, String endereco) {
        this.nome = nome;
        this.codigo = codigo;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public Double getPorcetagem() {
        return porcetagem;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setPorcetagem(Double porcetagem) {
        this.porcetagem = porcetagem;
    }
}
