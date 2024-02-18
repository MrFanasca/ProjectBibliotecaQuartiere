package org.generation.italy.bibliotecaQuartiere.servlet.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.generation.italy.bibliotecaQuartiere.servlet.model.BibliotecaModelException;
import org.generation.italy.bibliotecaQuartiere.servlet.model.entity.Libro;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class LibroDao extends ADao{

	public LibroDao(Connection jdbcConnectionToDatabase) {
		super(jdbcConnectionToDatabase);
		// TODO Auto-generated constructor stub
	}


	private List<Libro> loadLibroByQuery(PreparedStatement preparedStatement) throws BibliotecaModelException {

		List<Libro> elencoLibri = new ArrayList<>();

		try {

			ResultSet rsSelect = preparedStatement.executeQuery();

			while (rsSelect.next()) {

				String codiceLibro = rsSelect.getString("codice_libro");
				if (rsSelect.wasNull()) {
					codiceLibro = "";
				}

				String titolo = rsSelect.getString("titolo");
				if (rsSelect.wasNull()) {
					titolo = "";
				}

				String autore = rsSelect.getString("autore");
				if (rsSelect.wasNull()) {
					autore = "";
				}

				String editore = rsSelect.getString("editore");
				if (rsSelect.wasNull()) {
					editore = "";
				}

				String genere = rsSelect.getString("genere");
				if (rsSelect.wasNull()) {
					genere = "";
				}

				String stato = rsSelect.getString("stato");
				if (rsSelect.wasNull()) {
					stato = "";
				}

				String descrizione = rsSelect.getString("descrizione");
				if (rsSelect.wasNull()) {
					descrizione = "";
				}

				String anno = rsSelect.getString("anno_edizione");
				if (rsSelect.wasNull()) {
					anno = "";
				}

				int nrPagine = rsSelect.getInt("nr_pagine");
				if (rsSelect.wasNull()) {
					nrPagine = 0;
				}

				Libro libro = new Libro(codiceLibro, titolo, autore, editore, genere, stato, anno, descrizione,
						nrPagine);
				elencoLibri.add(libro);
			}

		} catch (SQLException e) {
			throw new BibliotecaModelException("Libro Dao --> loadMetodoByQuery" + e.getMessage());
		}

		return elencoLibri;
	}
	
	
// **********************************************************************************************************************	

	

	public List<Libro> loadAllLibro() throws BibliotecaModelException {

		List<Libro> libri = new ArrayList<>();

		try {
			
			PreparedStatement preparedStatement = this.jdbcConnectionToDatabase
					.prepareStatement(QueryCatalog.loadAllLibri);
			libri = loadLibroByQuery(preparedStatement);

		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
			throw new BibliotecaModelException("LibroDao -> loadLibroByQuery" + sqlException.getMessage());
		}

		return libri;

	}
	
	
	// **********************************************************************************************************************	

	

	public List<Libro> loadLibriLiberi() throws BibliotecaModelException {

		List<Libro> libri = new ArrayList<>();

		try {
			
			PreparedStatement preparedStatement = this.jdbcConnectionToDatabase
					.prepareStatement(QueryCatalog.loadLibriLiberi);
			libri = loadLibroByQuery(preparedStatement);

		} catch (SQLException sqlException) {
			throw new BibliotecaModelException("LibroDao -> loadLibroByQuery" + sqlException.getMessage());
		}

		return libri;

	}
	
	
// **********************************************************************************************************************	

	public void updateStato(Libro libro) throws BibliotecaModelException {

		try {
			
			PreparedStatement preparedStatement = this.jdbcConnectionToDatabase
					.prepareStatement(QueryCatalog.UpdateStato);

			preparedStatement.setString(1, libro.getStato());
			preparedStatement.setString(2, libro.getCodiceLibro());

			preparedStatement.executeUpdate();

		} catch (SQLException sqlException) {
			throw new BibliotecaModelException("AssegnazioneDao --> updateStato ->" + sqlException.getMessage());
		}
	}

	
// **********************************************************************************************************************	
	
	
	
	public Libro loadLibroByPrimaryKey(String codiceLibro) throws BibliotecaModelException {

		Libro libro = null;

		try {

			List<Libro> elencoLibri = new ArrayList<Libro>();

			PreparedStatement preparedStatement = this.jdbcConnectionToDatabase
					.prepareStatement(QueryCatalog.loadLibriByPrimaryKey);

			preparedStatement.setString(1, codiceLibro);

			elencoLibri = loadLibroByQuery(preparedStatement);

			if (elencoLibri.size() == 1) {
				libro = elencoLibri.get(0);
			}

		} catch (SQLException sqlException) {

			throw new BibliotecaModelException("LibroDao -> loadLibroByPrimaryKey -> " + sqlException.getMessage());
		}

		return libro;

	}

}
