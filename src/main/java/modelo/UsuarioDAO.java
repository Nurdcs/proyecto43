package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class UsuarioDAO {
	
	Conexion con=new Conexion();
	Connection cnn=con.conexionbd();
	PreparedStatement ps;
	ResultSet rs;
	UsuarioDTO usu;
	
	
	
	public String insertrusuario(UsuarioDTO us) {
	 
		int x;
		String dat="";
		
		try {
			
			usu=consultarusuario(us);
			if(usu==null) {
						ps=cnn.prepareStatement("INSERT INTO usuario values(?,?,?,?,?)");
						ps.setInt(1, us.getDocumneto());
						ps.setString(2, us.getNomusuario());
						ps.setString(3, us.getClave());
						ps.setString(4, us.getRol());
						ps.setString(5, us.getEstado());
						x=ps.executeUpdate();
						if(x>0) {
							dat="ok";
						}
				
				
				
			}
			else {
				dat="existe";
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return dat;
	}
	
	
	
	public boolean eliminarusuario(UsuarioDTO us) {
		int x;
		boolean dat=false;
		try {
			ps=cnn.prepareStatement("DELETE FROM usuario WHERE documento=?");
			ps.setInt(1,us.getDocumneto() );
			x=ps.executeUpdate();
			
			if(x>0) {
			dat=true;	
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return dat;
	}
	
	
	public UsuarioDTO consultarusuario(UsuarioDTO udto) {
	
		
		try {
			ps=cnn.prepareStatement("SELECT * fROM usuario WHERE documento=?");
			ps.setInt(1, udto.getDocumneto());
			rs=ps.executeQuery();
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "consulto dato");
				usu=new UsuarioDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getNString(5));
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	return usu;	
		
	}
	
	
	public int actulizar(UsuarioDTO usdto) {
		int x=0;
	  try {
		ps=cnn.prepareStatement("UPDATE usuario Set nomusu=?,clave=?,rol=?,estado=? WHERE documento=?");
		ps.setString(1, usdto.getNomusuario());
		ps.setString(2,usdto.getClave());
		ps.setString(3, usdto.getRol());
		ps.setString(4, usdto.getEstado());
		ps.setInt(5, usdto.getDocumneto());
		x= ps.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  return x;
	}
	
	public ArrayList<UsuarioDTO> consultar(){
		JOptionPane.showMessageDialog(null,"dao");
		ArrayList<UsuarioDTO>lista=new ArrayList<>();
		try {
			ps=cnn.prepareStatement("SELECT * FROM usuario");
			rs=ps.executeQuery();
			while(rs.next()) {
			usu=new UsuarioDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));	
			lista.add(usu);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return lista;
	}
	
	
	public ArrayList<UsuarioDTO> consultardocumento() {
		ArrayList<UsuarioDTO>lista=new ArrayList<UsuarioDTO>();
		
		try {
			ps=cnn.prepareStatement("SELECT  doccli FROM cliente ");
		    rs=ps.executeQuery();
		    while(rs.next()) {
		    	usu=new UsuarioDTO(rs.getInt(1));
		    	lista.add(usu);
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
	

}
