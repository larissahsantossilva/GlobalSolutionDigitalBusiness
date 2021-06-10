package br.com.fiap.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.model.Usuario;



@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioEndpoint {

private UsuarioDAO dao =  new UsuarioDAO();
	
	@GET
	public List<Usuario> index() {
		return dao.getAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Usuario usuario) {
		if (usuario == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		dao.create(usuario);
		return Response.status(Response.Status.CREATED).entity(usuario).build();
	}
	
	@GET
	@Path("{id}")
	public Response show(@PathParam("id") Long id) {
		Usuario usuario;
		try {
			usuario = dao.findById(id);
			if (usuario == null) {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
			return Response.status(Response.Status.OK).entity(usuario).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") Long id, Usuario usuario) {
		usuario.setId(id);
		dao.update(usuario);
		return Response.status(Response.Status.OK).entity(usuario).build();
	}
	

	@DELETE 
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") Long id, Usuario usuario) {
		if (usuario == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		usuario.setId(id);
		dao.delete(id);
		return Response.status(Response.Status.OK).entity(usuario).build();
	}

}
