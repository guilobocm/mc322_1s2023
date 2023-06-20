package models.seguros;

import models.Condutor;
import models.Frota;
import models.Seguradora;
import models.Sinistro;
import models.clientes.Cliente;
import models.clientes.ClientePJ;
import models.enums.CalculoSeguroMensal;

import java.util.Date;
import java.util.List;

public class SeguroPJ extends Seguro {
    private Frota frota;
    private ClientePJ cliente;

    public SeguroPJ(Date dataInicio, Date dataFim, Seguradora seguradora, List<Sinistro> listaSinistros, List<Condutor> listaCondutores, int valorMensal, Frota frota, ClientePJ cliente) {
        super(dataInicio, dataFim, seguradora, listaSinistros, listaCondutores, valorMensal);
        this.frota = frota;
        this.cliente = cliente;
    }

    public Frota getFrota() {
        return frota;
    }

    public void setFrota(Frota frota) {
        this.frota = frota;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(ClientePJ cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean desautorizarCondutor(Condutor condutor) {
        return getListaCondutores().remove(condutor);
    }

    @Override
    public boolean autorizarCondutor(Condutor condutor) {
        if (getListaCondutores().contains(condutor)) { return false; }

        return getListaCondutores().add(condutor);
    }

    @Override
    public Double calcularValor() {
        Double fatorQtdFuncionarios = Double.valueOf((10 + (cliente.getQtdeFuncionarios() / 10)));
        Double fatorQtdVeiculos = Double.valueOf((1 + 1 / (cliente.getVeiculos().size() + 2)));
        Double fatorIdade = Double.valueOf((1 + 1 / (cliente.calculaIdade() + 2)));
        Double fatorQtdSinistros = Double.valueOf((2 + getListaSinistros().size() / 10));

        Integer qtdSinistrosCondutor = getListaCondutores().stream()
                .map(condutor -> condutor.getListaSinistros().size())
                .reduce(0, ((totalSinistros, sinistros) -> sinistros + totalSinistros));

        Double fatorQtdSinistrosCondutor = Double.valueOf((5 + qtdSinistrosCondutor / 10));

        return CalculoSeguroMensal.VALOR_BASE.valor * fatorQtdSinistrosCondutor * fatorIdade * fatorQtdVeiculos * fatorQtdFuncionarios * fatorQtdSinistros;
    }

    @Override
    public boolean gerarSinistro(Sinistro sinistro) {
        return getListaSinistros().add(sinistro);
    }

    @Override
    public String toString() {
        return "SeguroPJ{" +
                "frota=" + frota +
                ", cliente=" + cliente +
                ", seguro=" + super.toString() + "}";
    }
}
