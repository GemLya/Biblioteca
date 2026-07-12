package edu.utng.dao.interfaces;

import edu.utng.model.Usuario;
import java.util.List;


public interface UsuarioDAO {
    
    boolean insertar(Usuario usuario);
    
   
    List<Usuario> listar();
    
   
    boolean actualizar(Usuario usuario);
    
  
    boolean eliminar(int id);
}