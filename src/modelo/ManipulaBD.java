package modelo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;


import modelo.objetos.Producto;
import modelo.objetos.ProductoFacturado;



public class  ManipulaBD<T> {
	
	
	
	public static Connection getConnection() {   // Probando la conexion a la DB
	
		System.out.println("Testing Connection");
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_de_facturacion?useSSL=false&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "root", "12345");
			System.out.println("Connection Successfull");
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
	}

	
	public static <T> void guardarObjeto(T objeto) throws SQLException{ 
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(objeto.getClass()).buildSessionFactory();

       Session session = factory.getCurrentSession();

       try{

           session.beginTransaction();
           session.save(objeto);
           session.getTransaction().commit();
           

          
           
          
          
           
       }finally {
           session.close();
    	   factory.close();
           

       }
		
	}
	
	
	public static <T> void borrarObjeto(int id, Class c) throws SQLException {
		
		  T objeto;  
		  SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(c).buildSessionFactory();

	      Session session = factory.getCurrentSession();
	
	     
	
	      try {
	    	  
	    	  
	    
			objeto = getObject(id,c);
	    	
	    	 
	    	 session = factory.getCurrentSession();
	    	 session.beginTransaction();
	    	 session.delete(objeto);   // Borrando el objeto
	    	 session.getTransaction().commit();
	    	    	
	    	 
	    	  
	      }finally {
	    	  session.close();
	    	  factory.close();
	    
	      }
	
	
	
	      
	
	}
	
	
	public static <Objeto> List<Objeto> consultarObjeto(Class c) throws SQLException{
	
		 SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(c).buildSessionFactory();

		 Session session = factory.getCurrentSession();
		
		
		try {
		
			session.beginTransaction();
			List<Objeto> listaConsulta= session.createQuery("from " + c.getName() ).getResultList();
			session.getTransaction().commit();
			
			
			return listaConsulta;
		
		}finally {
			 session.close();
			factory.close();
			
		}
		
	
		
	}
	
	
	
	/*
	@SuppressWarnings("deprecation")
	public static String[] getColumnNames(Class c) {
	
		SessionFactory factory = null; 
		
		try {
			factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(c).buildSessionFactory();
		 
		 return factory.getClassMetadata(c).getPropertyNames();  // getColumnNames.
		 } 
		
		finally {
			 factory.close();
			 
		 }
	}
	
	*/ 
	
	public static ArrayList<String> getColumnNames(String tableName) throws SQLException {
		
		Connection connection = getConnection();
		
		DatabaseMetaData metaData  = connection.getMetaData(); 
		
		ArrayList<String> nombresColumna = new ArrayList<>();
		
		
		ResultSet resultset = metaData.getColumns(null, null,tableName, null);

				while(resultset.next()) {
			
				nombresColumna.add(resultset.getString("COLUMN_NAME"));
			
			
			
		}
		
		
		return nombresColumna;
	}
	
	public static <T> void actualizarObjeto(T objeto) throws SQLException
	{
		
		
		 SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(objeto.getClass()).buildSessionFactory();

		 Session session = factory.getCurrentSession();
		 
		 try {
			 session.beginTransaction();
			 session.update(objeto);
			 session.getTransaction().commit();
		 
		
		
		 }catch(Exception e) {
				session.getTransaction().rollback();
				e.printStackTrace();
			 
		 }finally {
		 
			 factory.close();
		 }
	
			
	}
		 

	
		
		public static <T> List<T> ejecutarSentencia(String sentencia,Class c) {
			
			
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(c).buildSessionFactory();

		    Session session = factory.getCurrentSession();
		    
		    List <T> lista;
		    try {
		    	  
		    	  
		    	 session.beginTransaction();  
		   
		    	 lista =  session.createQuery(sentencia).getResultList();
		    	 
		    	 session.getTransaction().commit();
			
		      } finally {
		    	  
		    	  factory.close();
		      }
			
		    return lista;
		    
			
		}
	
	
	
	
	public static <T> T getObject(int id,Class c){
		T objeto;
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(c).buildSessionFactory();

	    Session session = factory.getCurrentSession();
	
	     
	
	      try {
	    	  
	    	  
	    	 session.beginTransaction();  
	    	 objeto =   (T) session.get(c,id);// Recuperando el objeto dada la clase y el id
	    	 session.getTransaction().commit();
		
	      } finally {
	    	  
	    	  factory.close();
	      }
		return objeto;
	}
	
	
	
}
