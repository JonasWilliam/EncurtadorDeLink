package br.com.jonas.encurtador.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="link")
public class Link implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="urlCurta")
	private String urlCurta;
	@Column(name="url")
	private String url;

	public String getUrlCurta() {
		return urlCurta;
	}
	public void setUrlCurta(String urlCurta) {
		this.urlCurta = urlCurta;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Link other = (Link) obj;
		return id == other.id;
	}
	
	public Link(String urlCurta, String url) {
		super();
		this.urlCurta = urlCurta;
		this.url = url;
	}
	
	public Link() {
		super();
	}
	
	@Override
	public String toString() {
		return "Link [id=" + id + ", urlCurta=" + urlCurta + ", url=" + url + "]";
	}
	
}
