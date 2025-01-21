
package beans;

public class Telefone {
    private String telefone;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

  @Override
  public String toString(){
      return telefone;
  }
    
}
