package com.example.demo;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class ProduitControler {
@Autowired
private ProduitReposotiroy  produitRepository;


@RequestMapping(value="/user/index")
public String index(Model model,@RequestParam(name="page",defaultValue="0")int p,
		@RequestParam(name="size",defaultValue="5")int s,
		@RequestParam(name="motcle",defaultValue="")String mc
		) {
	Page<Produit>pageProduits=
			produitRepository.chercher("%"+mc+"%",PageRequest.of(p, s));
	model.addAttribute("listProduits",pageProduits.getContent());
	
	int[]pages=new int[pageProduits.getTotalPages()];
	model.addAttribute("pages",pages);
	model.addAttribute("size",s);
	model.addAttribute("pageCourante",p);
	model.addAttribute("motcle",mc);
	
	
	return "produit";//hathi el3ala9a bine html wel controler
	
	
}

@RequestMapping(value="/admin/delete",method=RequestMethod.GET)
public String delete(long  id,int page,int size,String motcle) {
	produitRepository.deleteById(id);
	return "redirect:/admin/index?page="+page+"&size="+size+"&motcle="+motcle
;			
}
@RequestMapping(value="/admin/form",method=RequestMethod.GET)
public String formProduit( Model model ) {
	model.addAttribute("produit",new Produit());
	return "FormProduit";

	
}
@RequestMapping(value="/admin/save",method=RequestMethod.POST)
public String save( Model model, Produit produit ) {
	
	
	
	produitRepository.save(produit);
	return "confirmation";

	
}






/*public ProduitControler() {
}

public public ProduitControler(ProduitReposotiroy  produitRepository) {
	this.produitRepository =produitRepository;
}
	*/




/*@RequestMapping(value="/index")
public String index(Model model,@RequestParam(name="page",defaultValue="0")int p,
		@RequestParam(name="size",defaultValue="5")int s
		) {
	Page<Produit>pageProduits=
			produitRepository.findAll(PageRequest.of(p, s));
	model.addAttribute("listProduits",pageProduits.getContent());
	
	int[]pages=new int[pageProduits.getTotalPages()];
	model.addAttribute("pages",pages);
	model.addAttribute("size",s);
	model.addAttribute("pageCourante",p);
	
	
	return "produit";//hathi el3ala9a bine html wel controler
*/	
@RequestMapping(value="/admin/edit", method=RequestMethod.GET)
public String edite(Model model,long id) {




	
	
	
	
Produit p=produitRepository.findById(id).orElse(null);
	model.addAttribute("produit",p);
	return "EditProduit";
	
}
@RequestMapping(value="/")
public String home() {
	
	return "redirect:/index";
	
}
@RequestMapping(value="/403")
public String accesDaniel() {
	
	return "403";
	
}

}








