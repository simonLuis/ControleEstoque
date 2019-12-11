 package com.unisul.br.controler;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unisul.br.dao.EnderecoDAO;
import com.unisul.br.dao.NovoUsuarioDAO;
import com.unisul.br.dao.jpa.EnderecoDaoImpl;
import com.unisul.br.dao.jpa.NovoUsuarioDaoImpl;
import com.unisul.br.model.Endereco;
import com.unisul.br.model.NovoUsuario;

/**
 * Servlet implementation class servletAjax
 */
@WebServlet(name = "servletAjax", urlPatterns = {"/cadastroNovoUser"}) 
public class servletAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	EnderecoDAO enderecoDAO = new EnderecoDaoImpl();
	NovoUsuarioDAO novoUsuarioDAO = new NovoUsuarioDaoImpl();
	
    public servletAjax() {
        super();
   
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.getWriter().append("Served at: ").append(request.getContextPath());
    	
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String acao = request.getParameter("acao");
    	if(request.getParameter("idUsuario") != null) {
    		if(acao.equalsIgnoreCase("salva")) {
    			int id = !request.getParameter("idUsuario").equals("")?
    					Integer.parseInt(request.getParameter("idUsuario")) : 0;
    					if(id > 0) {
    						try {
								alterarUsuario(request, response);
							} catch (ParseException e) {
								e.printStackTrace();
							}
    					}else {
    						try {
								salvaUsuario(request, response);
								preencherEndereco(request);
							} catch (ParseException e) {

								e.printStackTrace();
							}
    					}
    		}
    		
    	}
    	
    	doGet(request, response);
    	
    }
	
	
	private void salvaUsuario(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		Endereco endereco = preencherEndereco(request);
		NovoUsuario usuario = preencherUsuario(request);
		novoUsuarioDAO.save(usuario);
		enderecoDAO.save(endereco);
	}
	
	private NovoUsuario preencherUsuario(HttpServletRequest request) throws ParseException {
		String id = (request.getParameter("idUsuario"));
		String login = request.getParameter("login");
    	String senha = request.getParameter("senha");
    	String confirmaSenha = request.getParameter("confirmaSenha");
    	String NomeUsuario = request.getParameter("NomeUsuario");
    	String dataNascimento = request.getParameter("dataNascimento");
    	String Anos = request.getParameter("Anos");
    	String sexo = request.getParameter("sexo");
    	NovoUsuario novo = new NovoUsuario();
    	
    	if ((id!=null) && (!id.isEmpty())){
            novo.setIdUsuario(Integer.parseInt(id));
        }

    	novo.setEmail(login);
    	novo.setSenha(senha);
    	novo.setConfirmaSenha(confirmaSenha);
    	novo.setNome(NomeUsuario);
    	novo.setDataNascimento(dataNascimento);
    	novo.setIdade(Anos);
    	novo.setSenha(sexo);
    	
		return novo;
		
	}
	
	private Endereco preencherEndereco(HttpServletRequest request) throws ParseException {
		
		String idCep = request.getParameter("idCep");
		String cep = request.getParameter("cep");
		String rua = request.getParameter("rua");
		int numero = Integer.parseInt(request.getParameter("numero"));
		String complemento = request.getParameter("complemento");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		Endereco endereco = new Endereco();
		
		if((idCep != null) && (!idCep.isEmpty()))  {
			endereco.setId(Integer.parseInt(idCep));
		}
		endereco.setCep(cep);
    	endereco.setRua(rua);
    	endereco.setNumeroCasa(numero);
    	endereco.setComplemento(complemento);
    	endereco.setBairro(bairro);
    	endereco.setCidade(cidade);
    	endereco.setUf(estado);
		return endereco;
		
	}
	
	   private void alterarUsuario (HttpServletRequest request, HttpServletResponse response) throws ParseException {
		   	Endereco endereco = preencherEndereco(request);
	        NovoUsuario usuario = preencherUsuario(request);
			novoUsuarioDAO.update(usuario);
			enderecoDAO.update(endereco);
	    }
	
	/*
	private void apagaProjeto(HttpServletRequest request, HttpServletResponse response) {

        try {
            dao.delete(Integer.parseInt(request.getParameter("idProjeto")));
            listaProjeto(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void editaProjeto(HttpServletRequest request, HttpServletResponse response) {
        Projeto projeto = null;
        try {
            projeto = dao.findById(Integer.parseInt(request.getParameter("idProjeto")));
            request.setAttribute("projeto", projeto);
            request.setAttribute("participantes", participanteDAO.findAll());
            request.getRequestDispatcher("/projeto.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }  catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void salvaProjeto(HttpServletRequest request, HttpServletResponse response) {

        try {
            Projeto projeto = preencherProjeto(request);
            dao.save(projeto);
            listaProjeto(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public void listaProjeto(HttpServletRequest request,
                              HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("projetos",dao.findAll());
        request.getRequestDispatcher("/projetos.jsp").forward(request,response);
    }

    private Projeto preencherProjeto(HttpServletRequest request) {
        String id = request.getParameter("idProjeto");
        String descProjeto = request.getParameter("descProjeto");
        String dataInicio = request.getParameter("dataInicio");
        String dataFim = request.getParameter("dataFim");
        int perConcluido = Integer.parseInt(request.getParameter("percConcluido"));
        String situacao = request.getParameter("situacao");
        String[] participantes = request.getParameterValues("participantes");
        Projeto projeto = new Projeto();
        if (participantes!=null){
            for(int i=0; i<participantes.length;i++) {
                projeto.setParticipantes(participanteDAO.findById(
                        Integer.parseInt(participantes[i])));
            }
        }
        if ((id!=null) && (!id.equalsIgnoreCase(""))){
            projeto.setIdProjeto(Integer.parseInt(id));
        }
        projeto.setDescricao(descProjeto);
        projeto.setDataInicio(dataInicio);
        projeto.setDataFim(dataFim);
        projeto.setPercentualConcluido(perConcluido);
        projeto.setSituacao(situacao);
        return projeto;

    }
*/
}
