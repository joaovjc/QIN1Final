/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.joaovjc.projn1segundo;

/**
 *
 * @author joaovjc
 */
public class Pessoa {
    
    private String nome;
    private String cpf;
    private byte interesse;

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getCpf() {return cpf;}

    public void setCpf(String cpf) {this.cpf = cpf;}

    public byte getInteresse() {return interesse;}

    public void setInteresse(byte interesse) {this.interesse = interesse;}

    @Override
    public String toString() {
        return "nome= " + nome + ", cpf= " + cpf + ", interesse= " + switch(this.interesse){case 1 -> "pagamento de Conta";case 2 -> "Recebimento de Salário";default -> "Outra Operação";};
    }
    
    
    
}
