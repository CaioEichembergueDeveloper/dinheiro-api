package com.caio.dinheiro.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caio.dinheiro.domain.Categoria;
import com.caio.dinheiro.domain.Despesa;
import com.caio.dinheiro.repositories.CategoriaRepository;
import com.caio.dinheiro.repositories.DespesaRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private DespesaRepository despesaRepository;
	
	public void instanciaBaseDeDados() throws ParseException {
		Categoria cat1 = new Categoria(null, "Parcelado", "Despesa com mais de um pagamento e parcelas definidas");
		Categoria cat2 = new Categoria(null, "Fixo", "Despesa com mais de um pagamento e sem quantidade de parcelas");
		Categoria cat3 = new Categoria(null, "Á Vista", "Despesa gasta apenas no mês do primeiro pagamento");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date PP1 = sdf.parse("01/01/2022");
		Despesa D1 = new Despesa(null, "Reserva de emergência", PP1, 150.00, null, cat2);
		Despesa D2 = new Despesa(null, "SmarTV Samsung 4k", PP1, 2999.99, 10, cat1);
		Despesa D3 = new Despesa(null, "Tênis Nike Revolution", PP1, 200.99, 1, cat3);
		Date PP2 = sdf.parse("01/03/2022");
		Despesa D4 = new Despesa(null, "Teclado Gamer Tournament Chroma V2", PP2, 400.89, 2, cat1);

		cat1.getDespesas().addAll(Arrays.asList(D2,D4));
		cat2.getDespesas().addAll(Arrays.asList(D1));
		cat3.getDespesas().addAll(Arrays.asList(D3));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		this.despesaRepository.saveAll(Arrays.asList(D1,D2,D3,D4));
	}

}
