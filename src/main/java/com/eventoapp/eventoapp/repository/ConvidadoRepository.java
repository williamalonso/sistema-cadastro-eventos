package com.eventoapp.eventoapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.eventoapp.eventoapp.models.Convidado;
import com.eventoapp.eventoapp.models.Evento;

public interface ConvidadoRepository extends CrudRepository<Convidado, String> {
	Iterable<Convidado> findByEvento(Evento evento); // busca lista de convidados de acordo com o Evento passado por parâmetro
	Convidado findByRg(String rg); // vai procurar no banco um convidado pelo seu Rg
}
