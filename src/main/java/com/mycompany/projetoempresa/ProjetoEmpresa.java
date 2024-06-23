/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projetoempresa;

import java.time.LocalDate;
import java.time.Period;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
        
 *
 * @author Mateus
 */
public class ProjetoEmpresa {

    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));

        for (Funcionario funcionario : funcionarios) {
            BigDecimal aumento = funcionario.getSalario().multiply(new BigDecimal("0.10"));
            funcionario.setSalario(funcionario.getSalario().add(aumento));
        }

        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        System.out.println("Funcionários agrupados por função:");
        for (String funcao : funcionariosPorFuncao.keySet()) {
            System.out.println("Função: " + funcao);
            for (Funcionario funcionario : funcionariosPorFuncao.get(funcao)) {
                System.out.println(funcionario);
            }
        }
        System.out.println();

        System.out.println("Funcionários que fazem aniversário em outubro e dezembro:");
        for (Funcionario funcionario : funcionarios) {
            int mes = funcionario.getDataNascimento().getMonthValue();
            if (mes == 10 || mes == 12) {
                System.out.println(funcionario);
            }
        }
        System.out.println();

        Funcionario funcionarioMaisVelho = funcionarios.get(0);
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getDataNascimento().isBefore(funcionarioMaisVelho.getDataNascimento())) {
                funcionarioMaisVelho = funcionario;
            }
        }
        int idadeMaisVelho = Period.between(funcionarioMaisVelho.getDataNascimento(), LocalDate.now()).getYears();
        System.out.println("Funcionário com a maior idade: " + funcionarioMaisVelho.getNome() + ", tem " + idadeMaisVelho +" anos");
        System.out.println();

        System.out.println("Funcionários em ordem alfabética:");
        List<Funcionario> funcionariosOrdenados = new ArrayList<>(funcionarios);
        funcionariosOrdenados.sort(Comparator.comparing(Funcionario::getNome));
        for (Funcionario funcionario : funcionariosOrdenados) {
            System.out.println(funcionario);
        }
        System.out.println();

        BigDecimal totalSalarios = BigDecimal.ZERO;
        for (Funcionario funcionario : funcionarios) {
            totalSalarios = totalSalarios.add(funcionario.getSalario());
        }
        System.out.println("Total dos salários: " + totalSalarios.toString().replace(".", ","));
        System.out.println();

        System.out.println("Salários mínimos por funcionário (considerando salário mínimo de R$1212,00):");
        //tive uma dificuldade em desenvolver essa etapa, dado que as funções não eram aceitas e os parametrs sempre pareciam errados.
    }

 }
