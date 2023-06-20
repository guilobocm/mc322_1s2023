package models.seguros;

import models.Condutor;
import models.Seguradora;
import models.Sinistro;
import models.Veiculo;
import models.clientes.Cliente;
import models.clientes.ClientePF;
import models.enums.CalculoSeguroMensal;

import java.util.Date;
import java.util.List;

public class SeguroPF extends Seguro {
    private Veiculo veiculo;
    private ClientePF cliente;

    public SeguroPF(
            Date dataInicio,
            Date dataFim,
            Seguradora seguradora,
            List<Sinistro> listaSinistros,
            List<Condutor> listaCondutores,
            int valorMensal,
            Veiculo veiculo,
            ClientePF cliente
    ) {
        super(dataInicio, dataFim, seguradora, listaSinistros, listaCondutores, valorMensal);
        this.veiculo = veiculo;
        this.cliente = cliente;
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

    public void setCliente(ClientePF cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean desautorizarCondutor(Condutor condutor) {
        if (getListaCondutores().contains(condutor)) { return false; }

        return getListaCondutores().add(condutor);
    }

    @Override
    public boolean autorizarCondutor(Condutor condutor) {
        return false;
    }

    @Override
    public Double calcularValor() {
        Double fatorQtdVeiculos = Double.valueOf((1 + 1 / (cliente.getVeiculos().size() + 2)));
        Double fatorQtdSinistros = Double.valueOf((2 + getSeguradora().getSinistrosPorCliente(cliente).size() / 10));

        Integer qtdSinistrosCondutor = getListaCondutores().stream()
                .map(condutor -> condutor.getListaSinistros().size())
                .reduce(0, ((totalSinistros, sinistros) -> sinistros + totalSinistros));

        Double fatorQtdSinistrosCondutor = Double.valueOf((5 + qtdSinistrosCondutor / 10));
        return CalculoSeguroMensal.VALOR_BASE.valor * cliente.calculoSeguroMensal().valor * fatorQtdSinistrosCondutor
                * fatorQtdSinistros * fatorQtdSinistrosCondutor;
    }

    @Override
    public boolean gerarSinistro(Sinistro sinistro) {
        return getListaSinistros().add(sinistro);
    }

    @Override
    public String toString() {
        return "SeguroPF{" +
                "veiculo=" + veiculo +
                ", cliente=" + cliente +
                ", seguro=" + super.toString() + "}";
    }
}
