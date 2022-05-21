package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class BonusService {

    public BigDecimal calcularBonus(Funcionario funcionario) {
        BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
        if (valor.compareTo(new BigDecimal("1000")) > 0) {
            throw new IllegalArgumentException("Funcionario com salario maior do que R$10000 não pode receber bônus");
        }

        return valor;
    }

}
