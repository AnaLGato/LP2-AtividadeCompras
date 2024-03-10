/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio3;
import java.util.Scanner;
/**
 *
 * @author aluno
 */
public class Exercicio3 
{
    //Menu de ações
    static void Menu(String[][] Celulas)
    {
        int funcao;
        
        Faz_Linha();
        System.out.println();
        System.out.println("Digite o número da função que deseja executar: ");
        System.out.println("1. Agendar ");
        System.out.println("2. Listar Agenda ");
        System.out.println("3. Fim ");
        
        Scanner teclado = new Scanner(System.in);
        funcao = teclado.nextInt();
        
        if(funcao == 1)
        {
            //Celulas = 
            Agendar(Celulas, teclado);
        }
        else
        {
            if(funcao == 2)
            {
                Listar_Agenda(Celulas);
            }
            else
            {
                if(funcao != 3)
                {
                    System.out.println("ERRO! Por favor tente novamente.");
                    Menu(Celulas);
                }
            }
        }
    }
    
    //Função Agendar
    static void Agendar(String[][] celulas, Scanner teclado)
    {
        String nome;
        int dia, hora, celvaz = 0;
        
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                if(celulas[i][j] == null)
                {
                    ++celvaz;
                    //celvaz faz a contagem de quantas celulas(horários) estão disponíveis. 
                    //Caso todas estejam ocupadas, será informado que não há horários disponíveis.
                }
            }
        }
        
        if(celvaz == 0)
        {
            System.out.println("Desculpe, todos os horários já foram preenchidos.");
            Faz_Linha();
            Menu(celulas);
        }
        else
        {
            System.out.println("Informe as informações abaixo para realizar o agendamento: ");
            System.out.print("Seu nome: ");
            nome = teclado.next();
            System.out.print("Dia da semana (Favor informar com numerais: 2 = segunda; 3 = terça; 4 = quarta; 5 = quinta; 6 = sexta): ");
            dia = teclado.nextInt();
            System.out.print("Horário da consulta (8; 9; 10; 11): ");
            hora = teclado.nextInt();
            System.out.println();
            
            
            if(celulas[dia - 2][hora-8] == null)
            {
                celulas[dia - 2][hora-8] = nome;
                System.out.println("Agendamento realizado com sucesso!");
                Faz_Linha();
                //return (celulas);
                Menu(celulas);
            }
            else
            {
                System.out.println("Infelizmente, o horário e dia informados não estão disponíveis para esta semana. Por favor tente marcar em outro horário. ");
                Faz_Linha();
                Menu(celulas);
            }
        }
        
    }
    
    static void Listar_Agenda(String [][] celulas)
    {
        Faz_Linha();
        
        System.out.println("|               |          8h          |          9h          |          10h          |          11h          |");
        System.out.println("| Segunda-feira | " + celulas[0][0] + " | " + celulas[0][1] + " | " + celulas[0][2] + " | " + celulas[0][3] + " | ");
        System.out.println("| Terça-feira   | " + celulas[1][0] + " | " + celulas[1][1] + " | " + celulas[1][2] + " | " + celulas[1][3] + " | ");
        System.out.println("| Quarta-feira  | " + celulas[2][0] + " | " + celulas[2][1] + " | " + celulas[2][2] + " | " + celulas[2][3] + " | ");
        System.out.println("| Quinta-feira  | " + celulas[3][0] + " | " + celulas[3][1] + " | " + celulas[3][2] + " | " + celulas[3][3] + " | ");
        System.out.println("| Sexta-feira   | " + celulas[4][0] + " | " + celulas[4][1] + " | " + celulas[4][2] + " | " + celulas[4][3] + " | ");
        Faz_Linha();
        
        Menu(celulas);
    }
    
    static void Faz_Linha()
    {
        for(int i = 0; i < 112; i++)
        {
            System.out.print("-");
        }
        System.out.println("-");
    }
    
    public static void main(String[] args) 
    {
        // TODO code application logic here
        String [][] Celulas = new String[5][4];
        Menu(Celulas);        
    }
    
}
