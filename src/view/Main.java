package view;

import java.util.*;

//Parte 1: Classe Nó para a Árvore Binária
class No {
 int pid;
 No esquerdo, direito;
 int altura; // Para uso na AVL

 public No(int pid) {
     this.pid = pid;
     this.esquerdo = this.direito = null;
     this.altura = 1; // Para AVL
 }
}

//Parte 1 e 2: Árvore Binária e AVL
class ArvoreProcessos {
 private No raiz;

 // Método para calcular a altura de um nó
 private int altura(No no) {
     return (no == null) ? 0 : no.altura;
 }

 // Fator de balanceamento
 private int fatorBalanceamento(No no) {
     return (no == null) ? 0 : altura(no.esquerdo) - altura(no.direito);
 }

 // Rotação à direita
 private No rotacaoDireita(No y) {
     No x = y.esquerdo;
     No T2 = x.direito;

     x.direito = y;
     y.esquerdo = T2;

     y.altura = Math.max(altura(y.esquerdo), altura(y.direito)) + 1;
     x.altura = Math.max(altura(x.esquerdo), altura(x.direito)) + 1;

     return x;
 }

 // Rotação à esquerda
 private No rotacaoEsquerda(No x) {
     No y = x.direito;
     No T2 = y.esquerdo;

     y.esquerdo = x;
     x.direito = T2;

     x.altura = Math.max(altura(x.esquerdo), altura(x.direito)) + 1;
     y.altura = Math.max(altura(y.esquerdo), altura(y.direito)) + 1;

     return y;
 }

 // Inserção de um nó na árvore
 public No inserir(No no, int pid) {
     if (no == null)
         return new No(pid);

     if (pid < no.pid)
         no.esquerdo = inserir(no.esquerdo, pid);
     else if (pid > no.pid)
         no.direito = inserir(no.direito, pid);
     else
         return no;

     no.altura = 1 + Math.max(altura(no.esquerdo), altura(no.direito));

     int balance = fatorBalanceamento(no);

     // Rotação LL
     if (balance > 1 && pid < no.esquerdo.pid)
         return rotacaoDireita(no);

     // Rotação RR
     if (balance < -1 && pid > no.direito.pid)
         return rotacaoEsquerda(no);

     // Rotação LR
     if (balance > 1 && pid > no.esquerdo.pid) {
         no.esquerdo = rotacaoEsquerda(no.esquerdo);
         return rotacaoDireita(no);
     }

     // Rotação RL
     if (balance < -1 && pid < no.direito.pid) {
         no.direito = rotacaoDireita(no.direito);
         return rotacaoEsquerda(no);
     }

     return no;
 }

 public void inserir(int pid) {
     this.raiz = inserir(this.raiz, pid);
 }

 // Busca em ordem crescente
 public void imprimirEmOrdem(No no) {
     if (no != null) {
         imprimirEmOrdem(no.esquerdo);
         System.out.print(no.pid + " ");
         imprimirEmOrdem(no.direito);
     }
 }

 public void imprimir() {
     imprimirEmOrdem(this.raiz);
 }
}

//Parte 3: Grafo de Dependências
class GrafoProcessos {
 private Map<Integer, List<Integer>> adjacencia;

 public GrafoProcessos() {
     adjacencia = new HashMap<>();
 }

 // Adicionar um processo
 public void adicionarProcesso(int pid) {
     adjacencia.putIfAbsent(pid, new ArrayList<>());
 }

 // Remover um processo
 public void removerProcesso(int pid) {
     adjacencia.remove(pid);
     for (List<Integer> dependentes : adjacencia.values()) {
         dependentes.remove(Integer.valueOf(pid));
     }
 }

 // Adicionar dependência
 public void adicionarDependencia(int pid1, int pid2) {
     adjacencia.putIfAbsent(pid1, new ArrayList<>());
     adjacencia.putIfAbsent(pid2, new ArrayList<>());
     adjacencia.get(pid1).add(pid2);
 }

 // Remover dependência
 public void removerDependencia(int pid1, int pid2) {
     List<Integer> dependentes = adjacencia.get(pid1);
     if (dependentes != null)
         dependentes.remove(Integer.valueOf(pid2));
 }

 // Imprimir o grafo
 public void imprimirGrafo() {
     for (var entry : adjacencia.entrySet()) {
         System.out.print(entry.getKey() + " -> " + entry.getValue() + "\n");
     }
 }
}

//Classe principal para teste
public class Main {
 public static void main(String[] args) {
     // Parte 1 e 2: Testando a árvore AVL
     ArvoreProcessos arvore = new ArvoreProcessos();
     arvore.inserir(10);
     arvore.inserir(20);
     arvore.inserir(5);
     arvore.inserir(15);
     arvore.inserir(25);
     System.out.println("Árvore AVL em ordem:");
     arvore.imprimir();

     // Parte 3: Testando o grafo de dependências
     GrafoProcessos grafo = new GrafoProcessos();
     grafo.adicionarProcesso(1);
     grafo.adicionarProcesso(2);
     grafo.adicionarProcesso(3);

     grafo.adicionarDependencia(1, 2);
     grafo.adicionarDependencia(1, 3);
     grafo.adicionarDependencia(2, 3);

     System.out.println("\n\nGrafo de Dependências:");
     grafo.imprimirGrafo();

     // Remoção de processo
     grafo.removerProcesso(2);
     System.out.println("\nApós remover o processo 2:");
     grafo.imprimirGrafo();
 }
}
