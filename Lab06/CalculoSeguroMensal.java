package models.enums;

public enum CalculoSeguroMensal {

    VALOR_BASE(10.0),
    FATOR_30(1.25),
    FATOR_30_60(1.0),
    FATOR_60(1.5);
    public final Double valor;

    CalculoSeguroMensal(Double valor) {
        this.valor = valor;
    }
}
