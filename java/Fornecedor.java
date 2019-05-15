import java.text.DecimalFormat;

public class Fornecedor {

    private int precoLitro;
    private int producao;
    private int numLitros;

    public Fornecedor(int precoLitro, int producao) {
        this.precoLitro = precoLitro;
        this.producao = producao;
        this.numLitros = producao;
    }

    public double getRazao() {
        DecimalFormat df = new DecimalFormat("#.##");
        double razao = Double.parseDouble(df.format((double) producao/precoLitro).replace(',', '.'));
        return razao;
    }

    public int getPrecoLitro() {
        return precoLitro;
    }

    public int getProducao() {
        return producao;
    }

    public int getNumLitros() {
        return numLitros;
    }

    public void setNumLitros(int numLitros) {
        this.numLitros = numLitros;
    }

}