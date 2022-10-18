package contabilidademotoboy;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MotoBoy implements Usuario {

    private final Scanner ler = new Scanner(System.in);
    private final DecimalFormat df = new DecimalFormat("#.##");

    private int kilometragemDoDia;
    private float quantidadeEntregas;
    private float valorEntregas;
    private int prejuizoInesperado = 0; 
    private String respostaConserto;
    private int kilometrosPorLitro = 35;
    private float gastoCombustivel;
    private float litrosNoDia;
    private String respostaImprevisto;
    private float ganhoLiquidoNoDia;
   
    @Override
    public void questionamento() {
        somarValorDasEntregas();
        somarKilometragemDoDia();
        imprevistos();
        mostrarResultados();
    }

    private void somarValorDasEntregas() {
        System.out.print("Quantas entregas foram feitas? ");
        this.quantidadeEntregas = ler.nextInt();
        this.valorEntregas = (this.quantidadeEntregas * 5) + 20;
        System.out.println("Foi feito algum conserto (no valor de R$ 2,50)? ");
        System.out.print("Reposta em [S] ou [N]: ");
        this.respostaConserto = ler.next();
        consertoEntrega(this.respostaConserto);
    }
    
    private void somarKilometragemDoDia() {
        int kilometragemAntiga, kilometragemAtual;
        System.out.print("Qual a kilometragem antiga? ");
        kilometragemAntiga = ler.nextInt();
        System.out.print("Qual a kilometragem atual? ");
        kilometragemAtual = ler.nextInt();
        this.kilometragemDoDia = kilometragemAtual - kilometragemAntiga;
        this.litrosNoDia = (float) this.kilometragemDoDia / this.kilometrosPorLitro;
        this.gastoCombustivel = this.litrosNoDia * 4.89f;                                     // Aqui está o preço do litro do combústível!
    }
    
    private void ganhoLiquidoDoDia() {
       this.ganhoLiquidoNoDia = this.valorEntregas - this.gastoCombustivel - this.prejuizoInesperado;
    }

    private void consertoEntrega(String resposta) {
        if (resposta.equals("S") || resposta.equals("s")) {
            System.out.print("Quantos consertos? ");
            int quantConsertos = ler.nextInt();
            float precoMeiaEntrega = 2.50f;
            float somaMeiaEntrega = 0;
            for (int contador = 0; contador < quantConsertos; contador++) {
                somaMeiaEntrega += precoMeiaEntrega;
            }
            this.valorEntregas += somaMeiaEntrega;
        }
    }
    
    private void imprevistos() {
        System.out.println("Aconteceu algum imprevisto? ");
        System.out.print("Reposta em [S] ou [N]: ");
        this.respostaImprevisto = ler.next();
        if (this.respostaImprevisto.equals("S") || this.respostaImprevisto.equals("s")) {
            System.out.print("Quanto custou o imprevisto? R$ ");
            this.prejuizoInesperado = ler.nextInt();
            ganhoLiquidoDoDia();
        } else {
            ganhoLiquidoDoDia();
        }
    }
    
    private void mostrarResultados() {
        System.out.println("=====================================");
        System.out.println("            RESULTADO ");
        System.out.println("Ganho nas entregas: R$ " + this.valorEntregas);
        System.out.println("Kilometros rodados no dia: " + this.kilometragemDoDia + "Km");
        System.out.println("Quantidade de litros de combustível: " + df.format(this.litrosNoDia) + "L");
        System.out.println("Gasto de combustível: R$ " + df.format(this.gastoCombustivel));
        System.out.println("Gastos com imprevistos: R$ " + this.prejuizoInesperado);
        System.out.println("Ganho líquido do dia: R$ " + df.format(this.ganhoLiquidoNoDia));
    }
    
    public int getKilometragemDoDia() {
        return kilometragemDoDia;
    }

    public void setKilometragemDoDia(int Kilometragem) {
        this.kilometragemDoDia = Kilometragem;
    }

    public float getQuantidadeEntregas() {
        return quantidadeEntregas;
    }

    public void setQuantidadeEntregas(float quantidadeEntregas) {
        this.quantidadeEntregas = quantidadeEntregas;
    }

    public float getValorEntregas() {
        return valorEntregas;
    }

    public void setValorEntregas(float valorEntregas) {
        this.valorEntregas = valorEntregas;
    }

    public int getPrejuizoInesperado() {
        return prejuizoInesperado;
    }

    public void setPrejuizoInesperado(int prejuizoInesperado) {
        this.prejuizoInesperado = prejuizoInesperado;
    }

    public String getRespostaConserto() {
        return respostaConserto;
    }

    public void setRespostaConserto(String respostaConserto) {
        this.respostaConserto = respostaConserto;
    }
    
    public int getKilometrosPorLitro() {
        return kilometrosPorLitro;
    }

    public void setKilometrosPorLitro(int kilometrosPorLitro) {
        this.kilometrosPorLitro = kilometrosPorLitro;
    }

    public float getGastoCombustivel() {
        return gastoCombustivel;
    }

    public void setGastoCombustivel(float gastoCombustivel) {
        this.gastoCombustivel = gastoCombustivel;
    }

    public float getLitrosNoDia() {
        return litrosNoDia;
    }

    public void setLitrosNoDia(float litrosNoDia) {
        this.litrosNoDia = litrosNoDia;
    }

    public String getRespostaImprevisto() {
        return respostaImprevisto;
    }

    public void setRespostaImprevisto(String respostaImprevisto) {
        this.respostaImprevisto = respostaImprevisto;
    }

    public float getGanhoLiquidoNoDia() {
        return ganhoLiquidoNoDia;
    }

    public void setGanhoLiquidoNoDia(float ganhoLiquidoNoDia) {
        this.ganhoLiquidoNoDia = ganhoLiquidoNoDia;
    }
    
}
