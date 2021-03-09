package isi.WorldCup.WorldCup.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="User")
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class User implements Serializable {
	
	public User() 
	{
	super();}
	
	
	
	@Id
    @GeneratedValue
    @Column(name="idUser", nullable = false)
    private int _idUser;
    private String _nom;
    private String _prenom;
    private int _numTel;

	
	
	public int get_id() {
		return _idUser;
	}
	public void set_id(int _idUser) {
		this._idUser = _idUser;
	}
	public String get_nom() {
		return _nom;
	}
	public void set_nom(String _nom) {
		this._nom = _nom;
	}
	public String get_prenom() {
		return _prenom;
	}
	public void set_prenom(String _prenom) {
		this._prenom = _prenom;
	}
	public int get_numTel() {
		return _numTel;
	}
	public void set_numTel(int _numTel) {
		this._numTel = _numTel;
	}


	public User(String _nom, String _prenom, int _numTel) {
		super();
		this._nom = _nom;
		this._prenom = _prenom;
		this._numTel = _numTel;
	}
	@Override
	public String toString() {
		return "User [_idUser=" + _idUser + ", _nom=" + _nom + ", _prenom=" + _prenom + ", _numTel=" + _numTel
				+"]";
	}
	
	  
	  

}
