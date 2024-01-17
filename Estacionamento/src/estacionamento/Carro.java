
package estacionamento;


public class Carro {
    //Add valores null diretos a variavel para que não de erro no método informacaoCliente
    
    String nome = "null";
    String modelo = "null";
    String placa = "null";
    
    public void InformacoesCarro(){
        System.out.println("nome : "+ nome +"\nmodelo : "+ modelo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
}
