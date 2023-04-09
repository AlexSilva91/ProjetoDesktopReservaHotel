/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
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
    private LocalDate dataInicial;
    @Column
    private LocalDate dataFinal;
    @Column
    private LocalTime horaEntrada;
    @Column
    private String duracao;
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

    public Reserva(LocalDate dataInicial, LocalDate dataFinal, LocalTime horaEntrada, String status, String duracao, Cliente cliente) {
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.horaEntrada = horaEntrada;
        this.status = status;
        this.duracao = duracao;
        this.cliente = cliente;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
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
