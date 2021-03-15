package isi.WorldCup.WorldCup.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

public class UserDao {
	
	@Id
    @GeneratedValue
    @Column(name="idUser", nullable = false)
    private int _idUser;
    private String _nom;
    private String _prenom;
    private int _numTel;
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID") })
    private Set<Role> roles;

	public int get_idUser() {
		return _idUser;
	}

	public void set_idUser(int _idUser) {
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public UserDao(String _nom, String _prenom, int _numTel, String username, String password, Set<Role> roles) {
		super();
		this._nom = _nom;
		this._prenom = _prenom;
		this._numTel = _numTel;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	
}
