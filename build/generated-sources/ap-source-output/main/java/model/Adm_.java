package main.java.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Adm.class)
public abstract class Adm_ {

	public static volatile SingularAttribute<Adm, Integer> cpf;
	public static volatile SingularAttribute<Adm, String> nome;
	public static volatile SingularAttribute<Adm, String> email;

	public static final String CPF = "cpf";
	public static final String NOME = "nome";
	public static final String EMAIL = "email";

}

