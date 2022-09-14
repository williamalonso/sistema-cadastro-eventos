package com.eventoapp.eventoapp;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataConfiguration {

	@Bean // esse bean faz a conexão com o banco
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/eventosapp"); // aqui é a url do nosso banco. seu nome vai ser "eventosapp"
        dataSource.setUsername("admin");
        dataSource.setPassword("root");
        return (DataSource) dataSource;
    }
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter(){
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter(); //aqui estamos criando conexão com o Hibernate
		adapter.setDatabase(Database.MYSQL); // aqui estamos definindo nosso banco que será utilizado
		adapter.setShowSql(true); // mostra o sql no console
		adapter.setGenerateDdl(true); // permite que o hibernate crie as tabelas automaticamente
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect"); // esse é o dialeto que será utilizado
		adapter.setPrepareConnection(true); // isso é p/ o hibernate preparar a conexão automaticamente
		return adapter;
	}
}
