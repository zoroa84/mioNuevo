package com.ipartek.formacion.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.domain.Artista;

public class ArtistaMapper implements RowMapper<Artista> {

	@Override
	public Artista mapRow(ResultSet rs, int numRow) throws SQLException {
		Artista a = new Artista();
		a.setId(rs.getInt("id"));
		a.setNombre(rs.getString("nombre"));
		return a;
	}

}
