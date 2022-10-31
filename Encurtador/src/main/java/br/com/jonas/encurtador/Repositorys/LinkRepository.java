package br.com.jonas.encurtador.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jonas.encurtador.model.Link;

@Repository
public interface LinkRepository  extends JpaRepository<Link, Integer> {

}
