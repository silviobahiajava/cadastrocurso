package testes;



import java.util.List;

import javax.swing.JOptionPane;

import cadastrocursos.model.Aluno;
import cadastrocursos.model.Curso;
import cadastrocursos.model.Modulo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Relacionamentos {

	 public static  EntityManager conectar() {
		   EntityManagerFactory emf = Persistence
	                .createEntityManagerFactory("Cursos-PU");
	        EntityManager em = emf.createEntityManager();
	        return em;
	 }
	 
    public static void main(String[] args) {
       EntityManager em = conectar();
        cadastrarcursomodulo(em);
       // listarAlunos(em);
       /// consultarAlunoPorCodigo(em,8);
    }
    public static void cadastrarcursomodulo(EntityManager em) {
    	//exemplo de relacionamento pai filho
    	//um pai tem muitos filhos
    	//primeiro instancia o pai
    	//defini os atributos do pai
    	//inicia a transa??o
    	//persiste o pai
    	//num laco de repeti??o for  instancia os filhos define os atributos e persiste o filho
    	//fora do la?o de repeti??o d? o commit
    	//mostra mensagem do cadastro
    	Curso curso=new Curso();
    	//Modulo modulo = new Modulo();
    	String nomeCurso = JOptionPane.showInputDialog("nome do curso");
    	curso.setNome(nomeCurso);
    	 em.getTransaction().begin();
    	em.persist(curso);
    	String nomeModulo="";
    	for(int i=0;i<3;i++) {
    		Modulo modulo=new Modulo();
    	     nomeModulo=JOptionPane.showInputDialog("nome do m?dulo");
    	     modulo.setNome(nomeModulo);
    	     modulo.setCurso(curso);
    	     em.persist(modulo);
    	}
    	em.getTransaction().commit();
    		
    	JOptionPane.showMessageDialog(null,"cadastro feito com sucesso");	
    		  
    		  
    		 
    		 
    		  
    		

    	
    
    	 
        

         //curso.setModulos(Arrays.asList(modulo));

       

         
        
         em.getTransaction().commit();

         em.close();
         em.close();
    }
    
    public static void listarAlunos(EntityManager em) {
    	String jpql="select a from Aluno a";
    	TypedQuery<Aluno> typedquery = em.createQuery(jpql,Aluno.class);
    	List<Aluno> lista = typedquery.getResultList();
    	
    	for (Aluno aluno : lista) {
    		System.out.println(aluno.getId()+"? aluno ="+aluno.getNome());
		}
    }
    
    public static void consultarAlunoPorCodigo(EntityManager em,Integer id) {
    	String jpql="select a from Aluno a where a.id ='"+id+"' ";
    	TypedQuery<Aluno> typedQuery = em.createQuery(jpql,Aluno.class);
    	Aluno aluno = typedQuery.getSingleResult();
    	System.out.println("aluno escolhido "+aluno.getNome());
    }
}
