# Exercício: Implementação de uma Árvore Binária de Processos e Grafos de Dependências

## Parte 1: Implementação de uma Árvore Binária de Processos
#### Objetivo: Implementar uma árvore binária para gerenciar processos em um sistema operacional.

#### Descrição: Cada nó da árvore representa um processo, identificado por um número de processo (PID). A árvore deve ser balanceada para garantir eficiência nas operações de inserção, remoção e busca.

### Passos:

- Crie uma classe No que tenha um atributo pid (número do processo) e referências para os filhos esquerdo e direito.

- Crie uma classe ArvoreProcessos que tenha um atributo raiz e métodos para inserir, remover e buscar processos.

- Implemente o método de inserção de forma recursiva, verificando se o pid deve ir para a esquerda ou direita.

- Implemente o método de busca em ordem para imprimir os processos em ordem crescente de pid.

## Parte 2: Balanceamento da Árvore
#### Objetivo: Implementar uma árvore AVL para garantir que a árvore de processos esteja balanceada.

#### Descrição: Modifique a classe ArvoreProcessos para que ela use uma árvore AVL.

### Passos:

- Adicione um atributo altura na classe Processo.

- Implemente métodos para calcular a altura de um nó e o fator de balanceamento.

- Implemente as rotações necessárias (rotação à direita, rotação à esquerda, rotação dupla à direita, rotação dupla à esquerda).

- Modifique o método de inserção para incluir as rotações e manter a árvore balanceada.

## Parte 3: Representação de Dependências de Processos com Grafos
#### Objetivo: Implementar um grafo para representar dependências entre processos.

#### Descrição: Cada nó do grafo representa um processo, e cada aresta representa uma dependência entre dois processos.

### Passos:

- Crie uma classe GrafoProcessos que tenha um mapa de adjacência para representar as dependências.

- Implemente métodos para adicionar e remover processos e dependências.

- Implemente um método para imprimir o grafo, mostrando as dependências entre os processos.

### Tarefas
- Implementar as classes Processo, ArvoreProcessos, ArvoreAVL e GrafoProcessos.

- Testar a inserção, remoção e balanceamento de processos na árvore.

- Adicionar dependências entre processos no grafo e testar a remoção de processos.
