package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainExcepetions;

public class Reservation {
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	public Reservation() {
		}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		if (!checkOut.after(checkIn)) {
		throw new DomainExcepetions ("Error in reservation: Check-out date must be after check-in"); // JA TRATARÁ A ECEÇÃO NO CONSTRUTOR
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime(); // PEGA O VALOR DE TIME E SUBTRAI PELO OUTRO "GETTIME" EM MILISEGUNDOS
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // CONVERTE MILLISECONDS PARA DIAS
	}
	
	public void updateDate(Date checkIn, Date checkOut) { // PROPRIO METODO TRATA A EXEÇÃO COM O T
		Date now = new Date(); // TRAZ O HORARIO "AGORA"
		if(checkIn.before(now) || checkOut.before(now)) { // .BEFORE E .AFTER UTILIZA-SE PARA COMPARAR DATAS
			throw new DomainExcepetions ("Error in reservation: Reservation dates must be future dates.") ; // AQUI TRATAM O ERRO DIRETO, ESSA EXEÇÃO É DE ARGUMENTOS INVALOS PRO METODO
		} else if (!checkOut.after(checkIn)) {
			throw new DomainExcepetions ("Error in reservation: Check-out date must be after check-in") ; // AQUI TRATAM O ERRO DIRETO, ESSA EXEÇÃO É DE ARGUMENTOS INVALOS PRO METODO
		} 
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		}
	
	@Override
	public String toString() {
		return "Reservation: Room "
				+ roomNumber
				+", check-in: "
				+ sdf.format(checkIn)
				+", check-out: "
				+ sdf.format(checkOut)
				+", "
				+ duration()
				+" nights.";
	}
	
}

