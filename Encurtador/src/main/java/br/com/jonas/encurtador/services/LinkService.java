package br.com.jonas.encurtador.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jonas.encurtador.Exception.LinkException;
import br.com.jonas.encurtador.Repositorys.LinkRepository;
import br.com.jonas.encurtador.model.Link;

@Service
public class LinkService {
	
	@Autowired
	LinkRepository linkRepository;
	
	public Link salvar(Link link) {
		return linkRepository.save(link);
	}
	public List<Link> listarTodos(){
		return linkRepository.findAll();
	}
	public String buscarPorId(int id) {
		Link LinkCompleto = linkRepository.findById(id).orElseThrow( () -> new LinkException(id));
		String link = LinkCompleto.getUrl();	
		return link;
	}
	public String buscarPorUrlCurta(String urlCurta) {
		ArrayList<Link> lista = new ArrayList<Link>();
		lista = (ArrayList<Link>) linkRepository.findAll();
		for(int i = 0; i < lista.size();i++) {
			
			if(lista.get(i).getUrlCurta().equals(urlCurta)) {
				return lista.get(i).getUrl();
			}
		}
		return urlCurta + " a UrlCurta digitada não foi localizada.";
	}
	public Link buscarPorIdCompleto(int id) {
		return linkRepository.findById(id).orElseThrow( () -> new LinkException(id));
	}
	public void excluir(int id) {
		linkRepository.deleteById(id);
	}
}
