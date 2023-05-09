package main.java.model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cliente.class)
public abstract class Cliente_ {

	public static volatile SingularAttribute<Cliente, String> telefone;
	public static volatile SingularAttribute<Cliente, Integer> cpf;
	public static volatile SingularAttribute<Cliente, String> nome;
	public static volatile SingularAttribute<Cliente, String> email;

	public static final String TELEFONE = "telefone";
	public static final String CPF = "cpf";
	public static final String NOME = "nome";
	public static final String EMAIL = "email";

}

