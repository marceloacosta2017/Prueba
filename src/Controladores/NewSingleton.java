/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import IO.Cliente;
import IO.Coche;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Marcelo
 */
public class NewSingleton {

    private NewSingleton() {
    }

    public static NewSingleton getInstance() {
        return NewSingletonHolder.INSTANCE;
    }

    public Object Clientes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object actualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object Clientes(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static class NewSingletonHolder {

        private static final NewSingleton INSTANCE = new NewSingleton();
        private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CHPPU");
        private static final EntityManager em = emf.createEntityManager();
    }

    public EntityManager getEntity() {
        return NewSingletonHolder.em;
    }
public void actualizar (Cliente a){
    NewSingleton.getInstance().getEntity().getTransaction().begin();
    try{
        Cliente aux=NewSingleton.getInstance().getEntity().find(Cliente.class, a.getId());
        aux=NewSingleton.getInstance().getEntity().merge(a);
        NewSingleton.getInstance().getEntity().getTransaction().commit();
     } catch (Exception e) {
            getEntity().getTransaction().rollback();
        }
}

    public void persist(Object object) {
        getEntity().getTransaction().begin();
        try {
            getEntity().persist(object);
            getEntity().getTransaction().commit();
        } catch (Exception e) {
            getEntity().getTransaction().rollback();
        }
    }
// PARA TRAER LA LISTA DE MARCAS DE COCHES DE LA BASE DE DATOS A UN COMBO
    public List<Coche> Coches(String marca) {
        List<Coche> resultado = null;
        getEntity().getTransaction().begin();
        try {
            resultado = getEntity().createNativeQuery("SELECT * FROM Coche where marca ='"+marca+"'", Coche.class).getResultList();
            getEntity().getTransaction().commit();
        } catch (Exception e) {
            getEntity().getTransaction().rollback();

        }
        return resultado;
    }
  // PARA TRAER LOS COCHES INGRESADOS EN LA BASE DE DATOS A UNA LISTA FILTRADOS POR LA MARCA.
    public List<String> MarcadeCoches() {
        List<String> resultado = null;
        getEntity().getTransaction().begin();
        try {
            resultado = getEntity().createNativeQuery("SELECT distinct marca FROM Coche").getResultList();
            getEntity().getTransaction().commit();
        } catch (Exception e) {
            getEntity().getTransaction().rollback();

        }
        return resultado;
    }
    
     public List<Cliente> Clientes1() {
        List<Cliente> resultado = null;
        getEntity().getTransaction().begin();
        try {
            resultado = getEntity().createNativeQuery("SELECT * FROM Cliente", Cliente.class).getResultList();
            getEntity().getTransaction().commit();
        } catch (Exception e) {
            getEntity().getTransaction().rollback();

        }
        return resultado;
    }
    
    /**
     *
     * @return
     */
   

//    public void persist(Object object) {
//       
//        getEntityManager().getTransaction().begin();
//        try {
//            getEntityManager().persist(object);
//            getEntityManager().getTransaction().commit();
//        } catch (Exception e) {
//           // e.printStackTrace();
//            getEntityManager().getTransaction().rollback();
////        } finally {
////            em.close(); para que no se cierre siempre, solo cuando cierro el programa
////        }
//    }
}
