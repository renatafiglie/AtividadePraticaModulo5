package br.org.com.recode.clientes.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, name = "data_nascimento")
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    private String destino;
    
    @Column(nullable = false, name = "data_ida")
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataIda;
    
    @Column(nullable = false, name = "data_volta")
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataVolta;
    
    @Column(nullable = false)
    private String aerea;
    
	
    public Cliente() {
    }

    public Cliente(Long id, String nome, LocalDate dataNascimento, String destino, String aerea, LocalDate dataIda, LocalDate dataVolta) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.destino = destino;
        this.dataIda = dataIda;
        this.dataVolta = dataVolta;
        this.aerea = aerea;
    }

    public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public LocalDate getDataIda() {
		return dataIda;
	}

	public void setDataIda(LocalDate dataIda) {
		this.dataIda = dataIda;
	}

	public LocalDate getDataVolta() {
		return dataVolta;
	}

	public void setDataVolta(LocalDate dataVolta) {
		this.dataVolta = dataVolta;
	}

	public String getAerea() {
		return aerea;
	}

	public void setAerea(String aerea) {
		this.aerea = aerea;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    
    
	

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
        result = prime * result + ((destino == null) ? 0 : destino.hashCode());
        result = prime * result + ((aerea == null) ? 0 : aerea.hashCode());
        result = prime * result + ((dataIda == null) ? 0 : dataIda.hashCode());
        result = prime * result + ((dataVolta == null) ? 0 : dataVolta.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (dataNascimento == null) {
            if (other.dataNascimento != null)
                return false;
        } else if (!dataNascimento.equals(other.dataNascimento))
            return false;
        
        
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        
        
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        
        
        
        if (aerea == null) {
            if (other.aerea != null)
                return false;
        } else if (!aerea.equals(other.aerea))
            return false;
        
        
        if (dataIda == null) {
            if (other.dataIda != null)
                return false;
        } else if (!dataIda.equals(other.dataIda))
            return false;
        
        if (dataVolta == null) {
            if (other.dataVolta != null)
                return false;
        } else if (!dataVolta.equals(other.dataVolta))
            return false;
        
        
        if (destino == null) {
            if (other.destino != null)
                return false;
        } else if (!destino.equals(other.destino))
            return false;
        return true;
    }

  //  @Override
  //  public String toString() {
   //     return "Cliente [dataNascimento=" + dataNascimento + ", id=" + id + ", nome=" + nome + ", destino="
    //            + destino + "]";
   // }

    
}

