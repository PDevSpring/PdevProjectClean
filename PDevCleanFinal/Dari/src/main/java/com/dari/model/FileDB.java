package com.dari.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.Transient;


@Data
@Entity
@Table(name = "files")
public class FileDB {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "imgID")
	  private Long id;

	  private String name;

	  private String type;

	  @Lob
	  private byte[] data;
	  
	  @Transient
		private String dataValue;

	  @JsonIgnore
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn
	    private Fourniture fourniture;
		  //(name = "fourniture_id", referencedColumnName = "FournitureId")
	  	  public FileDB() {
	  }

	  	public FileDB(String name, String type, byte[] data) {
	  	    this.name = name;
	  	    this.type = type;
	  	    this.data = data;
	  	  }

	}

