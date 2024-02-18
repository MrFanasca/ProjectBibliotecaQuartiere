package org.generation.italy.bibliotecaQuartiere.servlet.model.dao;

import java.sql.Connection;

import org.springframework.stereotype.Component;

@Component
public abstract class  ADao {
	protected Connection jdbcConnectionToDatabase;

	public ADao(Connection jdbcConnectionToDatabase) {
		this.jdbcConnectionToDatabase = jdbcConnectionToDatabase;
	}
}
