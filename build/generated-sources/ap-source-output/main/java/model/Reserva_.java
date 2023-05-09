package main.java.model;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Reserva.class)
public abstract class Reserva_ {

	public static volatile SingularAttribute<Reserva, Integer> quarto;
	public static volatile SingularAttribute<Reserva, LocalTime> horaEntrada;
	public static volatile SingularAttribute<Reserva, Double> valorDiaria;
	public static volatile SingularAttribute<Reserva, Integer> cpf_cliente;
	public static volatile SingularAttribute<Reserva, Integer> id;
	public static volatile SingularAttribute<Reserva, LocalDate> dataInicial;
	public static volatile SingularAttribute<Reserva, LocalDate> dataFinal;
	public static volatile SingularAttribute<Reserva, String> status;

	public static final String QUARTO = "quarto";
	public static final String HORA_ENTRADA = "horaEntrada";
	public static final String VALOR_DIARIA = "valorDiaria";
	public static final String CPF_CLIENTE = "cpf_cliente";
	public static final String ID = "id";
	public static final String DATA_INICIAL = "dataInicial";
	public static final String DATA_FINAL = "dataFinal";
	public static final String STATUS = "status";

}

