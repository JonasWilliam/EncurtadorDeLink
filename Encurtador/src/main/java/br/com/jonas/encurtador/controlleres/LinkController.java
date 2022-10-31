package br.com.jonas.encurtador.controlleres;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import br.com.jonas.encurtador.model.Link;
import br.com.jonas.encurtador.services.LinkService;

@RestController
@RequestMapping("/link")
public class LinkController {

	@Autowired
	LinkService linkService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Link> listarTodos() {
		return linkService.listarTodos();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Link salvar(@RequestBody Link link) {
		return linkService.salvar(link);
	}

	@GetMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String buscarPorId(@PathVariable int id) {
		return linkService.buscarPorId(id);
	}
	
	@GetMapping(path = "/buscarPorUrlCurta")
	@ResponseStatus(HttpStatus.OK)
	public String buscarPorUrlCurta(@RequestBody String urlCurta) {
		return linkService.buscarPorUrlCurta(urlCurta);
	}

	
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarPorId(@PathVariable int id) {
		linkService.excluir(id);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Link atualizar(@PathVariable int id, @RequestBody Link link) {
		Link linkAtual = linkService.buscarPorIdCompleto(id);
		linkAtual.setUrlCurta(link.getUrlCurta());
		linkAtual.setUrl(link.getUrl());
		return linkService.salvar(linkAtual);
	}
	
	
}
