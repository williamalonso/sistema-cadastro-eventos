package com.eventoapp.eventoapp.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eventoapp.eventoapp.models.Convidado;
import com.eventoapp.eventoapp.models.Evento;
import com.eventoapp.eventoapp.repository.ConvidadoRepository;
import com.eventoapp.eventoapp.repository.EventoRepository;

@Controller
public class EventoController {
	
	@Autowired // toda vez que precisarmos utilizar a interface 'EventoRepository', vai ser criada uma nova instância dela automaticamente
	private EventoRepository er;
	
	@Autowired
	private ConvidadoRepository cr;
	
	@RequestMapping(value="/cadastrarEvento", method=RequestMethod.GET)
	public String form() {
		return "evento/formEvento";
	}
	
	@RequestMapping(value="/cadastrarEvento", method=RequestMethod.POST)
	public String form(@Valid Evento evento, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) { // Se der erro na validação
			attributes.addFlashAttribute("mensagem", "Verifique os campos!"); // envia uma mensagem para o usuário
			return "redirect:/cadastrarEvento";
		}
		er.save(evento); // vamos persistir esse evento no banco de dados
		attributes.addFlashAttribute("mensagem", "Evento cadastrado com sucesso!"); // se não der erro na validação, exibe essa mensagem
		return "redirect:/cadastrarEvento"; // vamos redirecionar ele para o /cadastrarEvento do método GET
	}
	
	@RequestMapping("/eventos")
	public ModelAndView listaEventos() {
		ModelAndView mv = new ModelAndView("index"); // esse 'index' é a página que ele vai enviar os dados
		Iterable<Evento> eventos = er.findAll(); // faz a busca em todo o banco de dados (e não apenas de um id) 
		mv.addObject("eventos", eventos); // passa os dados para a view. "attributeName" é o mesmo da view que se chama "${eventos}. O segundo "eventos" é a minha lista criada na linha acima
		return mv;
	}
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET) // ele vai receber o id do banco
	public ModelAndView detalhesEvento(@PathVariable("codigo") long codigo) {
		Evento evento = er.findByCodigo(codigo); // aqui como queremos um evento específico, não podemos usar o ".findAll()". Então vamos no Model “EventoRepository” e criamos o método "findByCodigo"
		ModelAndView mv = new ModelAndView("evento/detalhesEvento"); // instanciando um objeto do tipo ModelAndView, e a página html se chamará "detalhesEvento"
		mv.addObject("evento", evento); // passa uma variável chamada "evento" para o "detalhesEvento.html". O segundo parâmetro são os dados retornados do "findByCodigo"
		
		Iterable<Convidado> convidados = cr.findByEvento(evento); // a lista de convidados vai fazer uma busca dos convidados de cada Evento
		mv.addObject("convidados", convidados); // vamos mandar essa lista para a view
		
		return mv;
	}
	
	@RequestMapping("/deletarEvento")
	public String deletarEvento(long codigo) {
		Evento evento = er.findByCodigo(codigo);
		er.delete(evento);
		return "redirect:/eventos";
	}
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.POST) // o {codigo} é o código do evento
	public String detalhesEventoPost(@PathVariable("codigo") long codigo, @Valid Convidado convidado, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) { // Se der erro na validação
			attributes.addFlashAttribute("mensagem", "Verifique os campos!"); // envia uma mensagem para o usuário
			return "redirect:/{codigo}";
		}
		Evento evento = er.findByCodigo(codigo); // busca o evento de acordo com o id do Evento vindo pela Url
		convidado.setEvento(evento); // aqui o convidado vai se relacionar com o evento específico da linha acima
		cr.save( convidado ); // salva o convidado no banco
		attributes.addFlashAttribute("mensagem", "Convidado adicionado com sucesso!"); // se não der erro na validação, exibe essa mensagem
		return "redirect:/{codigo}";
	}
	
	@RequestMapping("/deletarConvidado")
	public String deletarConvidado(String rg) { //vamos receber o id da entidade Convidado
		Convidado convidado = cr.findByRg(rg); // esse método foi criado para buscar o rg do convidado, lá no ConvidadoRepository
		cr.delete(convidado);
		
		Evento evento = convidado.getEvento(); // aqui busca o evento que o convidado está inserido
		long codigoLong = evento.getCodigo(); // busca o id do evento que o convidado está inserido
		String codigo = "" + codigoLong; // passa variável de long para String
		return "redirect:/" + codigo; // chama o método detalhesEventoPost p/ att a lista de convidados
	}
	
}
