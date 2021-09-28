/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.joaovjc.projn1segundo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joaovjc
 */
public class FilaDeAtendimento {
    private ArrayList<Pessoa> fila;
    
    public FilaDeAtendimento() {this.fila = new ArrayList<>();}
    
    public ArrayList<Pessoa> getFila() {return fila;}

    public void setFila(ArrayList<Pessoa> fila) {this.fila = fila;}
    
    public Pessoa atenderPesoa() {return this.fila.remove(0);}
    
    public void adicionarPessoa(Pessoa p) {this.fila.add(p);}
    
    public int obterQuantidadeDePessoas() {return this.fila.size();}
    
    public void apagarTodos() {this.fila.clear();}
    
    
    public Pessoa pesquisarPeloCpf(String cpf){
        Pessoa p1 = null;
        for (Pessoa pessoa: this.fila) {
            if(pessoa.getCpf().equals(cpf))p1 = pessoa;
        }
        
        return p1;
    }
    
    public List<Pessoa> pesquisarPessoaPeloInteresse(byte interesse){
        return this.fila.stream().filter(p -> p.getInteresse() == interesse).toList(); 
    }
    
    @Override
    public String toString() {return "Fila De Atendimento " + this.fila;}
    
}
