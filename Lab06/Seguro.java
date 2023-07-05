package models.seguros;

import models.Condutor;
import models.Veiculo;
import models.Seguradora;
import models.Sinistro;
import models.clientes.Cliente;

import java.util.Date;
import java.util.List;

public abstract class Seguro {
    private static Integer numeroSeguros = 0;

    private final Integer ID;
    private Date dataInicio;
    private Date dataFim;
    private Seguradora seguradora;
    private List<Sinistro> listaSinistros;
    private List<Condutor> listaCondutores;
    private int valorMensal;

    public Seguro(Date dataInicio, Date dataFim, Seguradora seguradora, List<Sinistro> listaSinistros, List<Condutor> listaCondutores, int valorMensal) {
        this.ID = numeroSeguros++;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        this.listaSinistros = listaSinistros;
        this.listaCondutores = listaCondutores;
        this.valorMensal = valorMensal;
    }

    public static Integer getNumeroSeguros() {
        return numeroSeguros;
    }

    public static void setNumeroSeguros(Integer numeroSeguros) {
        Seguro.numeroSeguros = numeroSeguros;
    }

    public Integer getID() {
        return ID;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Seguradora getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public List<Sinistro> getListaSinistros() {
        return listaSinistros;
    }

    public void setListaSinistros(List<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    public List<Condutor> getListaCondutores() {
        return listaCondutores;
    }

    public void setListaCondutores(List<Condutor> listaCondutores) {
        this.listaCondutores = listaCondutores;
    }

    public int getValorMensal() {
        return valorMensal;
    }

    public abstract boolean desautorizarCondutor(Condutor condutor);
    public abstract boolean autorizarCondutor(Condutor condutor);
    public abstract Double calcularValor();
    public abstract boolean gerarSinistro(Sinistro sinistro);
    public abstract Cliente getCliente();

    public void setValorMensal(int valorMensal) {
        this.valorMensal = valorMensal;
    }

    @Override
    public String toString() {
        return "Seguro{" +
                "ID=" + ID +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", seguradora=" + seguradora +
                ", listaSinistros=" + listaSinistros +
                ", listaCondutores=" + listaCondutores +
                ", valorMensal=" + valorMensal +
                '}';
    }
}
