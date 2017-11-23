package com.ipartek.formacion.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ipartek.formacion.domain.Artista;
import com.ipartek.formacion.repository.DAOArtista;
import com.ipartek.formacion.service.ArtistaService;

@Controller
@RequestMapping(value = "/api/artistas/")
public class ArtistasController {

	@Autowired
	ArtistaService artistaService;

	@Autowired
	DAOArtista artistaDAO;

	ArrayList<Artista> artistas_memoria;
	int indice;

	ArtistasController() {
		indice = 0;
		artistas_memoria = new ArrayList<Artista>();
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody List<Artista> listar(HttpServletResponse response) {

		ArrayList<Artista> artistas = (ArrayList<Artista>) artistaService.listar();

		if (artistas.isEmpty()) {
			response.setStatus(HttpStatus.NO_CONTENT.value());
		}
		return artistas;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public @ResponseBody Artista detalle(@PathVariable("id") int id, HttpServletResponse response) {

		Artista a = null;
		boolean encontrado = false;

		for (Artista it : artistas_memoria) {

			if (it.getId() == id) {
				a = new Artista();
				a.setId(id);
				encontrado = true;
				break;
			}
		}

		if (!encontrado) {
			response.setStatus(HttpStatus.NO_CONTENT.value());
		}

		return a;
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public @ResponseBody Artista crear(@RequestBody Artista inputData, HttpServletResponse response) {

		if (inputData != null) {
			artistas_memoria.add(inputData);
			indice++;
			inputData.setId(indice);
			response.setStatus(HttpStatus.CREATED.value());
		} else {
			response.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		}

		return inputData;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public @ResponseBody Artista modificar(@RequestBody Artista inputData, @PathVariable("id") int id,
			HttpServletResponse response) {

		Artista a = null;
		boolean encontrado = false;

		for (int i = 0; i < artistas_memoria.size(); i++) {

			if (artistas_memoria.get(i).getId() == id) {
				encontrado = true;
				artistas_memoria.set(i, inputData);
				break;
			}
		}

		if (!encontrado) {
			response.setStatus(HttpStatus.NO_CONTENT.value());
		}

		return a;

	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public @ResponseBody Artista eliminar(@PathVariable("id") int id, HttpServletResponse response) {

		boolean encontrado = false;

		for (int i = 0; i < artistas_memoria.size(); i++) {

			if (artistas_memoria.get(i).getId() == id) {
				encontrado = true;
				artistas_memoria.remove(i);
				break;
			}
		}

		if (!encontrado) {
			response.setStatus(HttpStatus.NO_CONTENT.value());
		}

		return null;
	}

}
