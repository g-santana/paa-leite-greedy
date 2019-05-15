import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        compraLeite();
    }

    private static void compraLeite() {
        List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
        fornecedores.add(new Fornecedor(5, 20));
        fornecedores.add(new Fornecedor(9, 40));
        fornecedores.add(new Fornecedor(3, 10));
        fornecedores.add(new Fornecedor(8, 80));
        fornecedores.add(new Fornecedor(6, 30));
        int desejado = 100;
        guloso(fornecedores, desejado);
    }

    private static void guloso(List<Fornecedor> fornecedores, int desejado) {
        List<Fornecedor> fornecedoresOrdenados = (List<Fornecedor>) fornecedores.stream().sorted(Comparator.comparing(Fornecedor::getPrecoLitro)).collect(Collectors.toList());
        int[] litrosCF = new int[fornecedoresOrdenados.size()];
        int i = 0;
        int litrosComprados = 0;
        int totalGasto = 0;
        while(litrosComprados < desejado) {
            if(fornecedoresOrdenados.get(i).getNumLitros() > 0) {
                litrosComprados += 1;
                litrosCF[i] += 1;
                fornecedoresOrdenados.get(i).setNumLitros(fornecedoresOrdenados.get(i).getNumLitros() - 1);
                totalGasto += fornecedoresOrdenados.get(i).getPrecoLitro();
            } else {
                if(i < fornecedoresOrdenados.size()) {
                    i += 1;
                }
            }
        }
        System.out.println("Litros comprados: " + litrosComprados);
        System.out.println("Quantia gasta: " + totalGasto);
    }

}