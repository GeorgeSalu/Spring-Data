package br.com.devmedia.blog.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.devmedia.blog.entity.Comentario;
import br.com.devmedia.blog.entity.Postagem;
import br.com.devmedia.blog.service.PostagemService;

@Controller
public class HomeController {

	@Autowired
	private PostagemService postagemService;
	
	@RequestMapping(value="/{permalink}",method=RequestMethod.GET)
	public ModelAndView openPostagem(
			@ModelAttribute("comentario") Comentario comentario,
			@PathVariable("permalink") String permalink,ModelMap model){
		
		Postagem postagem = postagemService.findByPermalink(permalink);
		
		model.addAttribute("postagem", postagem);
		
		return new ModelAndView("post",model);
	}
	
	@RequestMapping(value="/autor/{nome}",method=RequestMethod.GET)
	public ModelAndView postsByAutor(@PathVariable("nome") String nome,ModelMap model){
		
		List<Postagem> postagens = postagemService.findByAutor(nome);
		
		model.addAttribute("postagens",postagens);
		
		return new ModelAndView("posts",model);
	}
	
	@RequestMapping(value="/categoria/{link}/page/{page}",method=RequestMethod.GET)
	public ModelAndView postByCategoria(@PathVariable("page") Integer pagina,
			@PathVariable("link") String link,ModelMap model){
		
		//List<Postagem> postagens = postagemService.findByCategoria(link);
		
		//model.addAttribute("postagens", postagens);
		Page<Postagem> page = postagemService.findByPaginationByCategoria(pagina-1, 5,link);
		
		model.addAttribute("page", page);
		
		
		return new ModelAndView("posts",model);
	}
	
	@RequestMapping(value="/page/{page}",method=RequestMethod.GET)
	public ModelAndView pageHome(@PathVariable("pagina") Integer pagina,ModelMap model) {
		
		Page<Postagem> page = postagemService.findByPagination(pagina-1, 5);
		
		model.addAttribute("page", page);
		
		return new ModelAndView("posts",model);
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView home(ModelMap model){
		
		//List<Postagem> postagens = postagemService.findAll();
		
		//model.addAttribute("postagens", postagens);
		Page<Postagem> page = postagemService.findByPagination(0, 5);
		
		model.addAttribute("page", page);
		
		return new ModelAndView("posts",model);
	}
	
}
