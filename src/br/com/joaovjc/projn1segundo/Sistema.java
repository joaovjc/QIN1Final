/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.joaovjc.projn1segundo;

import java.util.Scanner;

/**
 *
 * @author joaovjc
 */
public class Sistema {
    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        FilaDeAtendimento f1 = new FilaDeAtendimento();
        byte escolha = 0;
        
        do {            
            System.out.println("Digite sua Opção: ");
            System.out.println("1 - Adicionar Cliente na Fila");
            System.out.println("2 - Ver Cliente da fila");
            System.out.println("3 - Ver quantidade de clientes que estão na fila");
            System.out.println("4 - Atender um cliente");
            System.out.println("5 - Pesquisar clientes pelo CPF");
            System.out.println("6 - Pesquisar clientes pelo Interesse");
            System.out.println("7 - Retirar todos os clientes da fila");
            System.out.println("0 - Sair");
            escolha = r.nextByte();
            
            switch(escolha){
                case 1 -> {
                    Pessoa p1 = new Pessoa();
                    System.out.println("informe o nome do cliente: ");
                    p1.setNome(r.next());
                    do {                        
                        System.out.println("Informe o CPF do cliente: ");
                        p1.setCpf(r.next());
                        if(p1.getCpf().length() != 11)System.out.println("Erro cpf Invalido");
                    } while (p1.getCpf().length() != 11);
                    do {
                        System.out.println("Informe o interesse do cliente\n" + "1 - Pagamento de Conta\n" + "2 - Recebimento de Salário\n" + "3 - Outras Opções");
                        p1.setInteresse(r.nextByte());
                        if(p1.getInteresse() < 1 | p1.getInteresse() > 3)System.out.println("Erro, Inválido");
                    } while (p1.getInteresse() < 1 | p1.getInteresse() > 3);
                    f1.adicionarPessoa(p1);
                    System.out.println("Pessoa adicionada na fila com sucesso");
                }
                
                case 2 -> System.out.println((f1.getFila().isEmpty())? "Não há clientes na fila": f1);
                case 3 -> System.out.println("Total de Clientes na Fila");
                case 4 -> System.out.println((f1.getFila().isEmpty())? "Não há clientes para atender": "Cliente: "+ f1.atenderPesoa());
                
                case 5 -> {
                    System.out.println("Informe o cpf do Cliente para efetuar a pesquisa: ");
                    Pessoa resultado = f1.pesquisarPeloCpf(r.next());
                    System.out.println((resultado==null)? "não há este cliente na fila": resultado);
                }
                
                case 6 -> {
                    System.out.println("Informe o interesse para listar os clientes\n" + "1 - Pagamento de Conta\n" + "2 - Recebimento de Salário\n" + "3 - Outras Opções");
                    byte pesquisa = r.nextByte();
                    System.out.println((f1.getFila().isEmpty())?"não a clientes com esse interesse": f1.pesquisarPessoaPeloInteresse(pesquisa));
                }
                
                case 7 -> {
                    if(f1.getFila().isEmpty()){System.out.println("Não há clientes na fila");}else{ System.out.println("Clientes removidos da fila"); f1.apagarTodos();}
                }
                
                case 0 -> System.out.println("Sistema Encerrado");
                default -> System.out.println("opção invalida");
                
            }
        } while (escolha != 0);
        
        
    }
}
