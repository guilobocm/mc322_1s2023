package models;

import java.util.List;

public class Frota {
    private String code;
    private List<Veiculo> listaVeiculos;

    public Frota(String code, List<Veiculo> listaVeiculos) {
        this.code = code;
        this.listaVeiculos = listaVeiculos;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(List<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public boolean addVeiculo(Veiculo veiculo) {
        if (listaVeiculos.contains(veiculo)) { return false; }

        return listaVeiculos.add(veiculo);
    }

    public boolean removeVeiculo(Veiculo veiculo) {
        return listaVeiculos.remove(veiculo);
    }

    @Override
    public String toString() {
        return "Frota{" +
                "code='" + code + '\'' +
                ", listaVeiculos=" + listaVeiculos +
                '}';
    }
}
