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
    private String _email;
    private String _motdepasse;


	
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Billet",
		joinColumns = { @JoinColumn(name = "spectateur_id")},
		inverseJoinColumns = { @JoinColumn (name = "match_id")})
    private Set<Match> _matchs = new HashSet<>();
    

	public Date get_dateNaissance() {
		return _dateNaissance;
	}
	public void set_dateNaissance(Date _dateNaissance) {
		this._dateNaissance = _dateNaissance;
	}
	public String get_email() {
		return _email;
	}
	public void set_email(String _email) {
		this._email = _email;
	}
	public String get_motdepasse() {
		return _motdepasse;
	}
	public void set_motdepasse(String _motdepasse) {
		this._motdepasse = _motdepasse;
	}
	@Override
	public String toString() {
		return "Spectateur [_dateNaissance=" + _dateNaissance + ", _email=" + _email + ", _motdepasse=" + _motdepasse
				+"]";
	}
	public Spectateur(String _nom, String _prenom, int _numTel, Date _dateNaissance, String _email,
			String _motdepasse, Set<Match> _matchs) {
		super(_nom, _prenom, _numTel);
		this._dateNaissance = _dateNaissance;
		this._email = _email;
		this._motdepasse = _motdepasse;
		this._matchs = _matchs;
	}
	




}

