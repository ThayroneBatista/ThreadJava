/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciriaco.contathread;

/**
 *
 * @author Thayr
 */
public class ProcessadorSaques implements Runnable {

    private final Conta conta;
    private final int quantidadeSaques;
    private final double valorSaque;

    public ProcessadorSaques(Conta conta, int quantidadeSaques, double valorSaque) {
        this.conta = conta;
        this.quantidadeSaques = quantidadeSaques;
        this.valorSaque = valorSaque;
    }

    @Override
    public void run() {
        for (int i = 1; i < quantidadeSaques; i++) {
            realizaSaque(valorSaque);
            System.out.println(Thread.currentThread().getName() + "- " + conta.getSaldo());
        }
    }

    private void realizaSaque(double valorSaque) {
        if (conta.getSaldo() >= valorSaque) {
            atrasaUmPouquinho();
            conta.sacar(valorSaque);
        }
    }

    private void atrasaUmPouquinho() {
        try {
            Thread.sleep(0x2710);
        } catch (InterruptedException ex) {
        }
    }
}
