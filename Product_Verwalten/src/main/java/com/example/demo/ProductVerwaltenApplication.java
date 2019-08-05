package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProductVerwaltenApplication {

	public static void main(String[] args) {
		//Simple Test pour L'Application
		
	
		ApplicationContext ctx=	SpringApplication.run(ProductVerwaltenApplication.class, args);
		ProduitReposotiroy prs=ctx.getBean(ProduitReposotiroy.class);
	prs.save(new Produit("Lx4532",670,90));
	prs.save(new Produit("ordHp 390",620,90));
	prs.save(new Produit("Imprimante",645,240));
		prs.save(new Produit("Lx4532",647,97210));
		
		
		
		prs.save(new Produit("souris",120,4780));
		prs.save(new Produit("ord390",600,947));
		prs.save(new Produit("Imprimantescanner",645,240));
			prs.save(new Produit("Hp2452",647,97210));
			
			
			
			
			
			prs.save(new Produit("clavier",620,470));
			prs.save(new Produit("or390",6157,90));
			prs.save(new Produit("camervideo",6805,21040));
				prs.save(new Produit("L532",1457,970));
				
				
				
				
				prs.save(new Produit("TVhgk",1414,478));
				prs.save(new Produit("classeur",7480,7841));
				prs.save(new Produit("film",145,240));
					prs.save(new Produit("schoes",67847,97210));
					
					prs.save(new Produit("T-SchirtNike",614,9147));
					prs.save(new Produit("Schort",460,90));
					prs.save(new Produit("radio",645,240));
						prs.save(new Produit("Canon",647,97210));
		
		
		
		
		
		
		prs.findAll().forEach(p->System.out.println(p.getDesignation()));//lamda expresion
	}

}
