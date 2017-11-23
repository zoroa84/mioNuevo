package com.ipartek.formacion.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.domain.Artista;
import com.ipartek.formacion.repository.DAOArtista;
import com.ipartek.formacion.repository.mapper.ArtistaMapper;

@Repository("daoArtista")
public class DAOArtistaImpl implements DAOArtista {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;

	@Autowired
	@Override
	public void setDatasource(DataSource ds) {
		this.dataSource = ds;
		this.jdbctemplate = new JdbcTemplate(this.dataSource);
	}

	// Sentencias SQL
	private static final String SQL_GET_ALL = "SELECT `id`, `nombre` FROM `artista` ORDER BY `id` DESC LIMIT 1000;";

	@Override
	public List<Artista> getAll() {
		ArrayList<Artista> lista = new ArrayList<Artista>();
		try {
			lista = (ArrayList<Artista>) this.jdbctemplate.query(SQL_GET_ALL, new ArtistaMapper());
		} catch (EmptyResultDataAccessException e) {
			System.out.println("No existen ingredientes todavia");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return lista;
	}

}
