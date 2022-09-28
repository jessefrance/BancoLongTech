package model;

import helper.Utils;

public class Conta
{
    private static int codigo = 0001;

    private int numero;
    private Cliente cliente;
    private Double saldo = 0.0;
    private Double limite = 0.0;
    private Double saldoTotal;

    public Conta(Cliente cliente) {
        this.numero = Conta.codigo;
        this.cliente = cliente;
        Conta.codigo += 1;
        //this.atualizaSaldoTotal();
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getLimite() {
        return limite;
    }
    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public Double getSaldoTotal() {
        return saldoTotal;
    }
    private void atualizaSaldoTota(){
        this.saldoTotal = this.getSaldo() + this.getLimite();
    }

    public String toString () {
        return "Número de conta: " + this.getNumero() +
                "\nCliente: " + this.cliente.getNome() +
                "\nSaldo Total: " + Utils.doublePAraString(this.getSaldoTotal());
    }

    public void depositar (Double valor) {
       if (valor > 0 ){
            this.saldo = this.getSaldo() + valor;
            this.atualizaSaldoTota();
            System.out.println("Depósito efetuado com sucesso.");
       }else {
           System.out.println("Erro ao Efetuar Depósito. Tente Novamente!");
       }
    }

    public void sacar (Double valor) {
        if (valor > 0 && this.getSaldoTotal() >= valor){
            if (this.getSaldo() >= valor) {
                this.saldo = this.getSaldo() - valor;
                this.atualizaSaldoTota();
                System.out.println("Saque efetuado com sucesso.");
            }else {
                Double restante = this.getSaldo() - valor;
                this.limite = this.getLimite() - restante;
                this.saldo = 0.0;
                System.out.println("Saque efetuado com sucesso! Atenção você usou o limite da sua conta.");
            }
        }else {
            System.out.println("Saque não realizado. Tente novamente!");
        }
    }

    //public void transferir (Conta destino, double valor);


}
