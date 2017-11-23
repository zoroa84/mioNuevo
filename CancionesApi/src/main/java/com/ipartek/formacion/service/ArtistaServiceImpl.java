package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.domain.Artista;
import com.ipartek.formacion.repository.DAOArtista;

@Service("artistaService")
public class ArtistaServiceImpl implements ArtistaService {

	@Autowired
	DAOArtista daoArtista;

	@Override
	public List<Artista> listar() {

		return daoArtista.getAll();

	}

}
