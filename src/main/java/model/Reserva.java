/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author HP - 4300
 */
@Entity
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String dataInicial;
    @Column
    private String dataFinal;
    @Column
    private String horaEntrada;
    @Column
    private String status;
    @Column
    private double valorDiaria;
    @Column
    private double valorTotalDiaria;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Cliente cliente;

    public Reserva() {
    }

    public Reserva(String dataInicial, String dataFinal, String horaEntrada, String status, double valorDiaria, Cliente cliente) {
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.horaEntrada = horaEntrada;
        this.status = status;
        this.valorDiaria = valorDiaria;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public double getValorTotalDiaria() {
        return valorTotalDiaria;
    }

    public void setValorTotalDiaria(double valorTotalDiaria) {
        this.valorTotalDiaria = valorTotalDiaria;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id
                + ", dataInicial=" + dataInicial
                + ", horaEntrada=" + horaEntrada
                + ", status=" + status + ", valorDiaria="
                + valorDiaria + ", valorTotalDiaria="
                + valorTotalDiaria + ", cliente=" + cliente + '}';
    }

}
