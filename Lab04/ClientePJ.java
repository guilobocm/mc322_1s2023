package models.clientes;

import models.Veiculo;
import models.clientes.Cliente;
import models.enums.CalculoSeguro;
import models.statics.Validacao;
import models.utils.DateUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ClientePJ extends Cliente {
    private final String CNPJ;
    private Date dataFundacao;
    private Integer qtdeFuncionarios;

    public ClientePJ(String nome, String endereco, List<Veiculo> veiculos, String CNPJ, Date dataFundacao, Integer qtdeFuncionarios) {
        super(nome, endereco, veiculos);
        this.CNPJ = CNPJ;
        this.dataFundacao = dataFundacao;
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public Integer getQtdeFuncionarios() {
        return qtdeFuncionarios;
    }

    public void setQtdeFuncionarios(Integer qtdeFuncionarios) {
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public boolean validarCNPJ(String cnpj) {
        return Validacao.validaCNPJ(cnpj);
    }

    @Override
    public Double calculaScore() {
        return CalculoSeguro.VALOR_BASE.valor * (1 + (qtdeFuncionarios / 100)) * getVeiculos().size();
    }

    @Override
    public Integer calculaIdade() {
        Calendar birthCalendar = DateUtils.getCalendar(dataFundacao);
        Calendar currentCalendar = DateUtils.getCalendar(new Date());

        int anos = currentCalendar.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR);

        if (
                (birthCalendar.get(Calendar.MONTH) > currentCalendar.get(Calendar.MONTH)) ||
                        (birthCalendar.get(Calendar.MONTH) == currentCalendar.get(Calendar.MONTH) && birthCalendar.get(Calendar.DATE) > currentCalendar.get(Calendar.DATE))
        ) {
            anos--;
        }

        return anos;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}