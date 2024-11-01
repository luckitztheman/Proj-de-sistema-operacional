package simuladorDeSubstituicaoDePaginas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SimuladorDeSubstituicaoDePaginas {
	public static void main(String[] args) {
        int[] paginas = {1, 2, 3, 2, 1, 4, 5, 1, 2, 3, 4, 5};  // Exemplo de sequência de páginas
        int numeroQuadros = 3;  // Número de quadros na memória

        // Instanciando e executando cada algoritmo
        System.out.println("Método FIFO - " + fifo(paginas, numeroQuadros) + " faltas de página");
        System.out.println("Método LRU - " + lru(paginas, numeroQuadros) + " faltas de página");
        System.out.println("Método Clock - " + clock(paginas, numeroQuadros) + " faltas de página");
        System.out.println("Método Ótimo - " + otimo(paginas, numeroQuadros) + " faltas de página");
    }

 
	// Exemplo de implementação para o FIFO (First In, First Out )
    public static int fifo(int[] paginas, int numeroQuadros) {
        Queue<Integer> quadros = new LinkedList<>();
        int faltasDePagina = 0;

        for (int pagina : paginas) {
            if (!quadros.contains(pagina)) {
                if (quadros.size() == numeroQuadros) {
                    quadros.poll(); // Remove a página mais antiga
                }
                quadros.add(pagina);
                faltasDePagina++;
            }
        }
        return faltasDePagina;
    }
    
 // Algoritmo LRU (Least Recently Used)
    public static int lru(int[] paginas, int numeroQuadros) {
        LinkedHashMap<Integer, Integer> quadros = new LinkedHashMap<>(numeroQuadros, 0.75f, true);
        int faltasDePagina = 0;

        for (int pagina : paginas) {
            if (!quadros.containsKey(pagina)) {
                if (quadros.size() == numeroQuadros) {
                    Integer lru = quadros.keySet().iterator().next(); // Pega o mais antigo (menos recentemente usado)
                    quadros.remove(lru);
                }
                faltasDePagina++;
            }
            quadros.put(pagina, pagina);
        }
        return faltasDePagina;
    }
    
 // Algoritmo Clock (Segunda Chance)
    public static int clock(int[] paginas, int numeroQuadros) {
        int[] quadros = new int[numeroQuadros];
        boolean[] segundaChance = new boolean[numeroQuadros];
        int ponteiro = 0;
        int faltasDePagina = 0;

        Arrays.fill(quadros, -1); // Inicializa os quadros como vazios

        for (int pagina : paginas) {
            boolean encontrou = false;
            for (int i = 0; i < numeroQuadros; i++) {
                if (quadros[i] == pagina) {
                    segundaChance[i] = true;
                    encontrou = true;
                    break;
                }
            }

            if (!encontrou) {
                while (segundaChance[ponteiro]) {
                    segundaChance[ponteiro] = false;
                    ponteiro = (ponteiro + 1) % numeroQuadros;
                }
                quadros[ponteiro] = pagina;
                segundaChance[ponteiro] = true;
                ponteiro = (ponteiro + 1) % numeroQuadros;
                faltasDePagina++;
            }
        }
        return faltasDePagina;
    }
    
 // Algoritmo Ótimo
    public static int otimo(int[] paginas, int numeroQuadros) {
        List<Integer> quadros = new ArrayList<>(numeroQuadros);
        int faltasDePagina = 0;

        for (int i = 0; i < paginas.length; i++) {
            int pagina = paginas[i];
            if (!quadros.contains(pagina)) {
                if (quadros.size() == numeroQuadros) {
                    int indiceParaSubstituir = -1;
                    int maisDistante = -1;

                    for (int j = 0; j < quadros.size(); j++) {
                        int proximoUso = Integer.MAX_VALUE;
                        for (int k = i + 1; k < paginas.length; k++) {
                            if (paginas[k] == quadros.get(j)) {
                                proximoUso = k;
                                break;
                            }
                        }
                        if (proximoUso > maisDistante) {
                            maisDistante = proximoUso;
                            indiceParaSubstituir = j;
                        }
                    }
                    quadros.remove(indiceParaSubstituir);
                }
                quadros.add(pagina);
                faltasDePagina++;
            }
        }
        return faltasDePagina;
    }

}
