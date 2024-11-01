# Proj-de-sistema-operacional
## Simulador de Algoritmos de Substituição de Páginas


### Descrição
Este projeto implementa um simulador de substituição de páginas, que permite comparar o desempenho de diferentes algoritmos de gerenciamento de memória virtual. Os algoritmos incluídos são FIFO (First In, First Out), LRU (Least Recently Used), Clock (Segunda Chance) e Ótimo. O simulador calcula as faltas de página para cada algoritmo dado um conjunto de páginas e um número de quadros de memória, ajudando a entender como esses algoritmos se comportam em diferentes cenários.

Pré-requisitos
Java 8 ou superior
IDE de desenvolvimento Java (opcional) ou linha de comando

Como Executar o Projeto

Clone o repositório:
git clone https://github.com/seuusuario/simulador-substituicao-paginas.git
cd simulador-substituicao-paginas

Compile o projeto: No terminal, navegue até a pasta do projeto e execute:
javac SimuladorDeSubstituicaoDePaginas.java

Execute o programa:
java SimuladorDeSubstituicaoDePaginas

Entrada de Dados: No código principal, há uma sequência de páginas já configurada para teste (int[] paginas = {1, 2, 3, 2, 1, 4, 5, 1, 2, 3, 4, 5};) e um número de quadros (int numeroQuadros = 3;). 
Para modificar esses valores, altere essas variáveis diretamente no código e recompile.

Saída: O programa exibe no terminal o número de faltas de página para cada algoritmo, em um formato como este:
Método FIFO - X faltas de página
Método LRU - X faltas de página
Método Clock - X faltas de página
Método Ótimo - X faltas de página
