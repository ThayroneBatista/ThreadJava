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
public class Processo {

    public static void main(String[] args) throws InterruptedException {
        final int TOTAL_THREADS = 10;
        Conta conta = new Conta();
        conta.depositar(1000);
        ProcessadorSaques processadorSaques = new ProcessadorSaques(conta, 20, 50);
        Thread[] todas = new Thread[TOTAL_THREADS];
        for (int i = 0; i < TOTAL_THREADS; i++) {
            todas[i] = new Thread(processadorSaques, "thread" + i);
        }
        for (int i = 0; i < TOTAL_THREADS; i++) {
            todas[i].start();
        }
        for (int i = 0; i < TOTAL_THREADS; i++) {
            todas[i].join();
        }
        System.out.println("Saldo Final = " + conta.getSaldo());
    }
}
