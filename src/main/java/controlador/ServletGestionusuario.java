package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import modelo.UsuarioDTO;
import modelo.UsuarioDAO;

/**
 * Servlet implementation class ServletGestionusuario
 */
@WebServlet("/ServletGestionusuario")
public class ServletGestionusuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGestionusuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Consulta general
		PrintWriter out = response.getWriter();
		UsuarioDTO us;
		UsuarioDAO usc;
				String dato=request.getParameter("dat");
				JOptionPane.showMessageDialog(null, dato);
				
					 
				JOptionPane.showMessageDialog(null, "en el tabla");
				ArrayList<UsuarioDTO>lista=new ArrayList<UsuarioDTO>();
				usc=new UsuarioDAO();
				lista=usc.consultar();
				
				Gson gsonn=new Gson();
				out.println(gsonn.toJson(lista));
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
        JOptionPane.showMessageDialog(null, "servlet");
		String u,c,r,e;
		int d;
		UsuarioDTO us;
		UsuarioDAO usc;
		UsuarioDTO conusu;
		String y;
		
		//BLOQUE DE INSERTAR
		if(request.getParameter("btnins")!=null) {
		d=Integer.parseInt(request.getParameter("doc"));
		u=request.getParameter("usu");
		c=request.getParameter("cla");
		r=request.getParameter("rol");
		e=request.getParameter("est");
		
		if(u.equals("")||c.equals("")||r.equals("")||e.equals("")){
			JOptionPane.showMessageDialog(null, "Debe diligenciar todos los datos");
			response.sendRedirect("index.jsp");
		}
		
		else {
			JOptionPane.showMessageDialog(null, d+u+c+r+e);
		us=new UsuarioDTO(d, u, c, r, e);
		usc=new UsuarioDAO();
		y=usc.insertrusuario(us);
			if(y.equals("ok")) {
				JOptionPane.showMessageDialog(null, "El usuario fue registrado");
				response.sendRedirect("index.jsp");
			}
			
			
			
			else {
				 JOptionPane.showMessageDialog(null, "El usuario ya existe");
				 response.sendRedirect("index.jsp");
			}
			
		}
		}
		
		
		//BLOQUE DE ELIMINAR
		if(request.getParameter("btneli")!=null) {
	     boolean m;
		 d=Integer.parseInt(request.getParameter("doc"));
		 us=new UsuarioDTO(d);
		 usc=new UsuarioDAO();
		 m=usc.eliminarusuario(us);
		 if(m) {
			 JOptionPane.showMessageDialog(null, "El usuario fue eliminado");
			 response.sendRedirect("menuprincipal.jsp");
		 }
		 else {
			 response.sendRedirect("index.jsp");
		 }
		 	
			
		}
		
		//BLOQUE DE CONSULTAR UN USUARIO
		if(request.getParameter("btncon")!=null) {
			int doc;
			d=Integer.parseInt(request.getParameter("doc"));
			us=new UsuarioDTO(d);
			usc=new UsuarioDAO();
			conusu=usc.consultarusuario(us);
			doc=conusu.getDocumneto();
			u=conusu.getNomusuario();
			c=conusu.getClave();
			r=conusu.getRol();
			e=conusu.getEstado();
			response.sendRedirect("index.jsp?us="+u+"&&cl="+c+"&&ro="+r+"&&es="+e+"&&do="+doc);
			
			
			
		}
		
		
		
		if(request.getParameter("btnact")!=null) {
			int ac;
			d=Integer.parseInt(request.getParameter("doc"));
			u=request.getParameter("usu");
			c=request.getParameter("cla");
			r=request.getParameter("rol");
			e=request.getParameter("est");
			us=new UsuarioDTO(d, u, c, r, e);
			usc=new UsuarioDAO();
			ac=usc.actulizar(us);
			if(ac>0) {
				JOptionPane.showMessageDialog(null, "El usuario fue actualizado");
				response.sendRedirect("index.jsp");
			}
			
			else {
				JOptionPane.showMessageDialog(null, "El usuario no se actualizo");
				response.sendRedirect("index.jsp");
			}
			
		}
		
		
	   
		   ArrayList< UsuarioDTO>list=new ArrayList<UsuarioDTO>();
		    usc=new UsuarioDAO();
		    list=usc.consultardocumento();
		    Gson gson=new Gson();
		   // JOptionPane.showMessageDialog(null,list.size() );
		    out.println(gson.toJson(list));
	       
		    
		    
		    
		//Consulta general
		
		/*String dato=request.getParameter("dat");
		JOptionPane.showMessageDialog(null, dato);
		
			 
		JOptionPane.showMessageDialog(null, "en el tabla");
		ArrayList<UsuarioDTO>lista=new ArrayList<UsuarioDTO>();
		usc=new UsuarioDAO();
		lista=usc.consultar();
		
		Gson gsonn=new Gson();
		out.println(gsonn.toJson(lista));*/
			
			
      
	}

}
