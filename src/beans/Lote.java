
package beans;

import java.util.Date;

public class Lote {
    private int id;
    private String prioridade;
    private String fragilidade;
    private Date dataLote;
    private String status;
    private int idProcesso;
    private Producao producao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getFragilidade() {
        return fragilidade;
    }

    public void setFragilidade(String fragilidade) {
        this.fragilidade = fragilidade;
    }

    public Date getDataLote() {
        return dataLote;
    }

    public void setDataLote(Date dataLote) {
        this.dataLote = dataLote;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(int idProcesso) {
        this.idProcesso = idProcesso;
    }     

    public Producao getProducao() {
        return producao;
    }

    public void setProducao(Producao producao) {
        this.producao = producao;
    }
    
    
}
