public class Main {
    public static void main(String[] args) {
        ContaBanco p1 = new ContaBanco();
        p1.setNumConta(111111);
        p1.setDono("Gustavo");
        p1.abrirConta("CC");
        p1.depositar(300f);


        ContaBanco p2 = new ContaBanco();
        p2.setNumConta(222222);
        p2.setDono("Kelly");
        p2.abrirConta("CP");
        p2.depositar(500f);
        p2.sacar(100f);


        p1.estadoConta();
        p2.estadoConta();
    }
}