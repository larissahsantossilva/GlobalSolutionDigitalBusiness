package br.com.fiap.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.fiap.dao.HotelDAO;
import br.com.fiap.model.Hotel;


@Named
@RequestScoped 
public class HotelBean {

private Hotel hotel = new Hotel();
	
	public void cadastrar() {
		new HotelDAO().create(this.hotel);
		System.out.println(this.hotel);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hotel Cadastrado!"));
	}
	

	
	public List<Hotel> getHoteis(){
		return new HotelDAO().getAll();
	}
	

	public Hotel getHotel() {
		return hotel;
	}


	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	


	
	
}
