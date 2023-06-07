package co.edu.unbosque.CarrenoJuan_Prog2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="animal")
public class Animal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer invest1;
	private Integer invest2;
	private String nombre;
	private String alimentacion;
	private String enlaces;
	private String foto;
	
	public Animal() {
		// TODO Auto-generated constructor stub
	}

	public Animal(Integer id, Integer invest1, Integer invest2, String nombre, String alimentacion, String enlaces,
			String foto) {
		super();
		this.id = id;
		this.invest1 = invest1;
		this.invest2 = invest2;
		this.nombre = nombre;
		this.alimentacion = alimentacion;
		this.enlaces = enlaces;
		this.foto = foto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getInvest1() {
		return invest1;
	}

	public void setInvest1(Integer invest1) {
		this.invest1 = invest1;
	}

	public Integer getInvest2() {
		return invest2;
	}

	public void setInvest2(Integer invest2) {
		this.invest2 = invest2;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAlimentacion() {
		return alimentacion;
	}

	public void setAlimentacion(String alimentacion) {
		this.alimentacion = alimentacion;
	}

	public String getEnlaces() {
		return enlaces;
	}

	public void setEnlaces(String enlaces) {
		this.enlaces = enlaces;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
}
