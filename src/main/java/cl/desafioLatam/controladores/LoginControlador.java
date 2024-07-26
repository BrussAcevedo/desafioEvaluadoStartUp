package cl.desafioLatam.controladores;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cl.desafioLatam.DTO.UsuarioDTO;
import cl.desafioLatam.servicios.ServicioCuenta;
import cl.desafioLatam.servicios.ServicioUsuario;

/**
 * Servlet implementation class LoginControlador
 */
@WebServlet("/LoginControlador")
public class LoginControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String correoLogin = request.getParameter("correoLoginTxt");
		String passwordLogin = request.getParameter("passwordLoginTxt");
		ServicioCuenta sc = new ServicioCuenta();
		ServicioUsuario su = new ServicioUsuario();
		UsuarioDTO usuarioEncontrado = new UsuarioDTO();
		
		HttpSession nuevaSesion = request.getSession();
		
		if(sc.loginUsuario(correoLogin, passwordLogin)) {
			System.out.println("flag0");
			usuarioEncontrado = su.encontrarUsuario(correoLogin);
				if(usuarioEncontrado != null) {
					
					nuevaSesion.setAttribute("userID", usuarioEncontrado.getId());
					nuevaSesion.setAttribute("userID", usuarioEncontrado.getNick());
					nuevaSesion.setAttribute("userID", usuarioEncontrado.getCorreo());
					
				}else {
					String errorBBDD = "Error inesperado a la conexion de base de datos.";
					request.setAttribute("errorBBDD", errorBBDD);
					request.getRequestDispatcher("vistaLogin.jsp").forward(request, response);
					
				}
		}else {
			
			String usuarioIncorrectoMsg = "Usuario y/o Contraseña incorrecto(s). Porfavor, Intentelo denuevo.";
			request.setAttribute("UsuarioIncorrecto", usuarioIncorrectoMsg);
			request.getRequestDispatcher("vistaLogin.jsp").forward(request, response);
			System.out.println("flag2");
		}
		
	}

}
