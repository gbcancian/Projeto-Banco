public class ContaBanco {
    //Atributos
    public int numConta;
    protected String tipo;
    private String dono;
    private double saldo;
    private boolean status;

    //Métodos
    public void estadoConta(){
        System.out.println("---------------------------------");
        System.out.println("Conta: " + this.getNumConta());
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Dono: " + this.getDono());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Status: " + this.isStatus());
    }

    public void abrirConta(String t){
        if(!status){
            setTipo(t);
            setStatus(true);
            if (t.equals("CC")) {
                setSaldo(50f);
                System.out.println("A CC foi aberta no nome de " + getDono());
            } else if (t.equals("CP")) {
                setSaldo(150f);
                System.out.println("A CP foi aberta no nome de " + getDono());
            } else {
                System.out.println("ERROR: Tipo de conta Inválido");
            }
        }else{
            System.out.println("ERROR: A conta já está aberta");
        }
    }

    public void fecharConta(){
        if (this.getSaldo() == 0f){
            if (this.isStatus()) {
                setStatus(false);
                System.out.println("A conta foi fechada");
            } else {
                System.out.println("ERROR: A conta já está fechada");
            }
        }else if(this.getSaldo() < 0f){
            System.out.println("ERROR: A conta está em débito");
        }else {
            System.out.println("ERROR: Ainda tem dinheiro na conta");
        }
    }

    public void depositar(float v){
        if (this.isStatus()){
            setSaldo(getSaldo() + v);
            System.out.println("Valor de R$" + v +  " foi depositado com sucesso");
        }else{
            System.out.println("A conta está fechada");
        }
    }

    public void sacar(float v){
        if (this.isStatus()){
            if (this.getSaldo() >= v){
                setSaldo(getSaldo() - v);
                System.out.println("Saque realizado na conta de " + getDono());
            }else{
                System.out.println("A conta está sem dinheiro suficiente");
            }
        }else{
            System.out.println("A conta está fechada");
        }
    }

    public void pagamentoMensal(float v){
        if (this.getTipo().equals("CC")){
                v = 12f;
        }else if (this.getTipo().equals("CP")){
                v = 20f;
        }else{
            System.out.println("ERRO: A conta não é CC nem CP");
        }
        if (this.isStatus()){
           if (this.getSaldo() >= v){
               setSaldo(getSaldo() - v);
               System.out.println("A mensalidade de R$" + v + " foi paga");
           } else{
               System.out.println("ERRO: A conta não tem dinheiro suficiente");
           }
        }else{
            System.out.println("A conta está fechada");
        }
    }

    //Método Construtor
    public ContaBanco() {
        saldo = 0f;
        status = false;
    }

    //Método GET e SET

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
