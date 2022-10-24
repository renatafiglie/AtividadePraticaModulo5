package br.org.com.recode.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.com.recode.clientes.model.Cliente;







public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
