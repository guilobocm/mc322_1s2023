package models;

import models.clientes.Cliente;

public class Sinistro {
    static Integer sinistros = 0;

    private final Integer ID;
    private String data;
    private String endereco;
    private Seguradora seguradora;
    private Veiculo veiculo;
    private Cliente cliente;

    public Sinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
        this.data = data;
        this.endereco = endereco;
        this.seguradora = seguradora;
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.ID = Sinistro.sinistros++;
    }

    public static Integer getSinistros() {
        return sinistros;
    }

    public static void setSinistros(Integer sinistros) {
        Sinistro.sinistros = sinistros;
    }

    public Integer getID() {
        return ID;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Seguradora getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Sinistro{" +
                "ID=" + ID +
                ", data='" + data + '\'' +
                ", endereco='" + endereco + '\'' +
                ", seguradora=" + seguradora +
                ", veiculo=" + veiculo +
                ", cliente=" + cliente +
                '}';
    }
}
