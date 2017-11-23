package com.ipartek.formacion.repository;

import java.util.List;

import javax.sql.DataSource;

import com.ipartek.formacion.domain.Artista;

public interface DAOArtista {

	void setDatasource(DataSource ds);

	List<Artista> getAll();

}
