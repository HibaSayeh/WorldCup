package isi.WorldCup.WorldCup.entities;



import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="lematch")
public class Match implements Serializable {
	@Id
    @GeneratedValue
    @Column(name="idMatch", nullable = false)
	private int  _idMatch;
	
	private Date _dateMatch;
	private String _premiereEquipe;
	private String _deuxiemeEquipe;
	private String _stade;
	private int _nbSpectateur;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "_matchs")
  	 private Set<Spectateur> _spectateurs = new HashSet<>();


	public int get_idMatch() {
		return _idMatch;
	}


	public void set_idMatch(int _idMatch) {
		this._idMatch = _idMatch;
	}


	


	public Date get_dateMatch() {
		return _dateMatch;
	}


	public void set_dateMatch(Date _dateMatch) {
		this._dateMatch = _dateMatch;
	}


	public String get_premiereEquipe() {
		return _premiereEquipe;
	}


	public void set_premiereEquipe(String _premiereEquipe) {
		this._premiereEquipe = _premiereEquipe;
	}


	public String get_deuxiemeEquipe() {
		return _deuxiemeEquipe;
	}


	public void set_deuxiemeEquipe(String _deuxiemeEquipe) {
		this._deuxiemeEquipe = _deuxiemeEquipe;
	}


	public String get_stade() {
		return _stade;
	}


	public void set_stade(String _stade) {
		this._stade = _stade;
	}


	public int get_nbSpectateur() {
		return _nbSpectateur;
	}


	public void set_nbSpectateur(int _nbSpectateur) {
		this._nbSpectateur = _nbSpectateur;
	}




	public Set<Spectateur> get_spectateurs() {
		return _spectateurs;
	}


	public void set_spectateurs(Set<Spectateur> _spectateurs) {
		this._spectateurs = _spectateurs;
	}

	
	public Match(int _idMatch, Date _dateMatch, String _premiereEquipe, String _deuxiemeEquipe,
			String _stade, int _nbSpectateur, Set<Spectateur> _spectateurs) {
		super();
		this._idMatch = _idMatch;
		
		this._dateMatch = _dateMatch;
		this._premiereEquipe = _premiereEquipe;
		this._deuxiemeEquipe = _deuxiemeEquipe;
		this._stade = _stade;
		this._nbSpectateur = _nbSpectateur;
		this._spectateurs = _spectateurs;
	}


	@Override
	public String toString() {
		return "Match [_idMatch=" + _idMatch + ", _dateMatch=" + _dateMatch
				+ ", _premiereEquipe=" + _premiereEquipe + ", _deuxiemeEquipe=" + _deuxiemeEquipe + ", _stade=" + _stade
				+ ", _nbSpectateur=" + _nbSpectateur + ", _spectateurs=" + _spectateurs + "]";
	}


	public Match() {
		super();
	}
	
	


}
