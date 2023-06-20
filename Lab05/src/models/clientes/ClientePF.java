package models.clientes;

import models.Veiculo;
import models.clientes.Cliente;
import models.enums.CalculoSeguro;
import models.enums.CalculoSeguroMensal;
import models.statics.Validacao;
import models.utils.DateUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientePF extends Cliente {
    private final String CPF;
    private String genero;
    private Date dataLicenca;
    private String educacao;
    private Date dataNascimento;
    private String classeEconomica;

    public ClientePF(
            String nome,
            String endereco,
            List<Veiculo> veiculos,
            String CPF,
            String genero,
            Date dataLicenca,
            String educacao,
            Date dataNascimento,
            String classeEconomica
    ) {
        super(nome, endereco, veiculos);
        this.CPF = CPF;
        this.genero = genero;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        this.classeEconomica = classeEconomica;
    }

    public String getCPF() {
        return CPF;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getDataLicenca() {
        return dataLicenca;
    }

    public void setDataLicenca(Date dataLicenca) {
        this.dataLicenca = dataLicenca;
    }

    public String getEducacao() {
        return educacao;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getClasseEconomica() {
        return classeEconomica;
    }

    public void setClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica;
    }

    public boolean validarCPF(String cpf) {
        return Validacao.validaCPF(cpf);
    }
    public CalculoSeguro calculaTaxaSeguro() {
        if (calculaIdade() >= 60) {
            return CalculoSeguro.FATOR_60_90;
        } else if (calculaIdade() >= 30) {
            return CalculoSeguro.FATOR_30_60;
        }

        return CalculoSeguro.FATOR_18_30;
    }

    public CalculoSeguroMensal calculoSeguroMensal() {
        Integer idade = calculaIdade();

        if (idade < 30) {
            return CalculoSeguroMensal.FATOR_30;
        } else if (idade <= 60) {
            return CalculoSeguroMensal.FATOR_30_60;
        }

        return CalculoSeguroMensal.FATOR_60;
    }

    @Override
    public Double calculaScore() {
        return CalculoSeguro.VALOR_BASE.valor * calculaTaxaSeguro().valor * getVeiculos().size();
    }

    public Integer calculaIdade() {
        Calendar birthCalendar = DateUtils.getCalendar(dataNascimento);
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
        return "ClientePF{" +
                "CPF='" + CPF + '\'' +
                ", genero='" + genero + '\'' +
                ", dataLicenca=" + dataLicenca +
                ", educacao='" + educacao + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", classeEconomica='" + classeEconomica + '\'' +
                '}';
    }
}
