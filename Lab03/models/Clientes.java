package models.clientes;

import models.Veiculo;
import models.enums.CalculoSeguro;

import java.time.Period;
import java.util.List;

public abstract class Cliente {
    private String nome;
    private String endereco;
    private List<Veiculo> veiculos;

    public Cliente(String nome, String endereco, List<Veiculo> veiculos) {
        this.nome = nome;
        this.endereco = endereco;
        this.veiculos = veiculos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public abstract Double calculaScore();

    public abstract Integer calculaIdade();


    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", veiculos=" + veiculos +
                '}';
    }
}