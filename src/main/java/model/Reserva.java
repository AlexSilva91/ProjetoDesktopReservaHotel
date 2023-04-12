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
    private int cod;
    @Column
    private LocalDate dataInicial;
    @Column
    private LocalDate dataFinal;
    @Column
    private LocalTime horaEntrada;
    @Column
    private String status;
    @Column
    private double valorDiaria;
    @Column
    private double valorTotalDiaria;

    public Reserva() {
    }

    public Reserva(LocalDate dataInicial, LocalDate dataFinal, LocalTime horaEntrada, String status, int cod) {
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.horaEntrada = horaEntrada;
        this.status = status;
        this.cod = cod;
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

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
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


    @Override
    public String toString() {
        return "Reserva{" + "id=" + id
                + ", dataInicial=" + dataInicial
                + ", horaEntrada=" + horaEntrada
                + ", status=" + status + ", valorDiaria="
                + valorDiaria + ", valorTotalDiaria="
                + valorTotalDiaria + ", cod=" + cod + '}';
    }

}
