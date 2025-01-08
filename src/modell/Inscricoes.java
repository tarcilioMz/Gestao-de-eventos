/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modell;

/**
 *
 * @author Muzime
 */
public class Inscricoes {
    private int id_Participante, id_Evento;
    private String nomeEvento,nomeParticipante, dataInscricao, tipo_Bilhete, status;

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getNomeParticipante() {
        return nomeParticipante;
    }

    public void setNomeParticipante(String nomeParticipante) {
        this.nomeParticipante = nomeParticipante;
    }
    
    public Inscricoes(){
        
    }

    public int getId_Participante() {
        return id_Participante;
    }

    public void setId_Participante(int id_Participante) {
        this.id_Participante = id_Participante;
    }

    public int getId_Evento() {
        return id_Evento;
    }

    public void setId_Evento(int id_Evento) {
        this.id_Evento = id_Evento;
    }

    public String getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(String dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    public String getTipo_Bilhete() {
        return tipo_Bilhete;
    }

    public void setTipo_Bilhete(String tipo_Bilhete) {
        this.tipo_Bilhete = tipo_Bilhete;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
