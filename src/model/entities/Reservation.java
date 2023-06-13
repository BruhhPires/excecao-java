package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	public Reservation() {
		}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
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
	
	public String updateDate(Date checkIn, Date checkOut) { // METODO É FEITO DIRETO
		Date now = new Date(); // TRAZ O HORARIO "AGORA"
		if(checkIn.before(now) || checkOut.before(now)) { // .BEFORE E .AFTER UTILIZA-SE PARA COMPARAR DATAS
			return "Error in reservation: Reservation dates must be future dates.";
		} else if (!checkOut.after(checkIn)) {
			return "Error in reservation: Check-out date must be after check-in";
		} else {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
		}
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

