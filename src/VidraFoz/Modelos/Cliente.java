package VidraFoz.Modelos;

public class Cliente {
    private int idCliente;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String cnpj_Cpf;

    public Cliente(int idCliente, String nome, String endereco, String telefone, String email, String cnpj_Cpf){
        this.idCliente = idCliente;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cnpj_Cpf = cnpj_Cpf;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getCnpj_Cpf() {
        return cnpj_Cpf;
    }
}

