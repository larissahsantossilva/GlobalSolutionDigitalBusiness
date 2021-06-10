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

import br.com.fiap.dao.AvaliacaoDAO;
import br.com.fiap.model.Avaliacao;


@Path("/avaliacoes")
@Produces(MediaType.APPLICATION_JSON)
public class AvaliacaoEndpoint {

	
	
private AvaliacaoDAO dao =  new AvaliacaoDAO();
	
	@GET
	public List<Avaliacao> index() {
		return dao.getAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Avaliacao avaliacao) {
		if (avaliacao == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		dao.create(avaliacao);
		return Response.status(Response.Status.CREATED).entity(avaliacao).build();
	}
	
	@GET
	@Path("{id}")
	public Response show(@PathParam("id") Long id) {
		Avaliacao avaliacao;
		try {
			avaliacao = dao.findById(id);
			if (avaliacao == null) {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
			return Response.status(Response.Status.OK).entity(avaliacao).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") Long id, Avaliacao avaliacao) {
		avaliacao.setId(id);
		dao.update(avaliacao);
		return Response.status(Response.Status.OK).entity(avaliacao).build();
	}
	

	@DELETE 
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") Long id, Avaliacao avaliacao) {
		if (avaliacao == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		avaliacao.setId(id);
		dao.delete(avaliacao);
		return Response.status(Response.Status.OK).entity(avaliacao).build();
	}
}
