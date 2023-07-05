package models;

import java.util.Date;
import java.util.List;

public class Condutor {
    private String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private Date dataNasc;
    private List<Sinistro> listaSinistros;

    public Condutor(String cpf, String nome, String telefone, String endereco, String email, Date dataNasc, List<Sinistro> listaSinistros) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.dataNasc = dataNasc;
        this.listaSinistros = listaSinistros;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public List<Sinistro> getListaSinistros() {
        return listaSinistros;
    }

    public void setListaSinistros(List<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    public boolean adicionarSinistro(Sinistro sinistro) {
        if (listaSinistros.contains(sinistro)) { return false; }

        return listaSinistros.add(sinistro);
    }

    @Override
    public String toString() {
        return "Condutor{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco='" + endereco + '\'' +
                ", email='" + email + '\'' +
                ", dataNasc=" + dataNasc +
                ", listaSinistros=" + listaSinistros +
                '}';
    }
}
