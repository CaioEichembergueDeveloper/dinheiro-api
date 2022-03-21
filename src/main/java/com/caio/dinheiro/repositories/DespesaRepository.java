package com.caio.dinheiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caio.dinheiro.domain.Despesa;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Integer>{

}