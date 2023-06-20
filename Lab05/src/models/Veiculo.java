package models;

import java.util.Date;
import java.util.List;

public class Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private Integer anoFabricacao;

    public Veiculo(String placa, String marca, String modelo, Integer anoFabricacao) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    @Override
    public String toString() {
        String str = "Modelo: " + getModelo();
        str += "\nMarca: " + getMarca();
        str += "\nAno de Fabricação: " + getAnoFabricacao();
        str += "\nPlaca: " + getPlaca();

        return str;
    }
}
