package isi.WorldCup.WorldCup.entities;

import java.sql.Date;
import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Table;



@Entity
@Table(name="spectateur")
public class Spectateur extends User {
	
 
    private Date _dateNaissance;
   
	
    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Billet",
		joinColumns = { @JoinColumn(name = "spectateur_id")},
		inverseJoinColumns = { @JoinColumn (name = "match_id")})
    private Set<Match> _matchs;
    

	public Date get_dateNaissance() {
		return _dateNaissance;
	}
	public void set_dateNaissance(Date _dateNaissance) {
		this._dateNaissance = _dateNaissance;
	}
	
	
	
	
	public Set<Match> get_matchs() {
		return _matchs;
	}
	public void set_matchs(Set<Match> _matchs) {
		this._matchs = _matchs;
	}
	public Spectateur(String _nom, String _prenom, int _numTel, String username, String password, Set<Role> roles, Date _dateNaissance, Set<Match> _matchs) {
		super(_nom,_prenom,_numTel,username,password,roles);
		this._dateNaissance = _dateNaissance;
		this._matchs = _matchs;
	}
	public Spectateur() {
		super();
	
	}





}

