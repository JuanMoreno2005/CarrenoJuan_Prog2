package co.edu.unbosque.CarrenoJuan_Prog2.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "investigador")
public class Investigador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cedula;
	private String nombre;
	private String correo;
	private Date fecha_nacimiento;
	private boolean estudia;
	private Date fecha_graduacion;
	
	public Investigador() {
		cedula = 0;
	}

	public Investigador(int cedula, String nombre, String correo, Date fecha_nacimiento, boolean estudia,
			Date fecha_graduacion) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.correo = correo;
		this.fecha_nacimiento = fecha_nacimiento;
		this.estudia = estudia;
		this.fecha_graduacion = fecha_graduacion;
	}
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public boolean isEstudia() {
		return estudia;
	}
	public void setEstudia(boolean estudia) {
		this.estudia = estudia;
	}
	public Date getFecha_graduacion() {
		return fecha_graduacion;
	}
	public void setFecha_graduacion(Date fecha_graduacion) {
		this.fecha_graduacion = fecha_graduacion;
	}
}
