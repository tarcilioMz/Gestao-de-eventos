package modell;

import java.text.SimpleDateFormat;

import java.sql.Date;

public class Eventos {

    // Declaração de variáveis
    private String nomeEvento;
    private java.sql.Date dataEvento;
    private String localEvento;
    private String organizadores;

    // Criação de getters e setters
    public String getNomeEvento() {
        return nomeEvento;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public String getLocalEvento() {
        return localEvento;
    }

    public String getOrganizadores() {
        return organizadores;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;

    }

    public void setDataEvento(Date dataEvento) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.dataEvento = dataEvento;

    }

    public void setLocalEvento(String localEvento) {
        this.localEvento = localEvento;
    }

    public void setOrganizadores(String organizadores) {
        this.organizadores = organizadores;
    }
}
