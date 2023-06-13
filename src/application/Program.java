package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException { // Esse Metodo poderá lançar exceção sem tratar
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		
		System.out.printf("Room Number:");
		Integer room = sc.nextInt();
		System.out.printf("Check-in Date:");
		Date checkIn = sdf.parse(sc.next());
		System.out.printf("Check-Out Date:");
		Date checkOut = sdf.parse(sc.next());
			if (!checkOut.after(checkIn)) { // .BEFORE E .AFTER UTILIZA-SE PARA COMPARAR DATAS
				System.out.println("Error in reservation: Check-out date must be after check-in date.");
			} else {
				Reservation reservation = new Reservation(room, checkIn, checkOut);
				System.out.println("Reservation :" + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.printf("Check-in Date:");
			checkIn = sdf.parse(sc.next());
			System.out.printf("Check-Out Date:");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date(); // TRAZ O HORARIO "AGORA"
			if(checkIn.before(now) || checkOut.before(now)) { // .BEFORE E .AFTER UTILIZA-SE PARA COMPARAR DATAS
				System.out.println("\"Error in reservation: Reservation dates must be future dates.\"");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in");
			} else {
				reservation.updateDate(checkIn, checkOut); // INSTANCIA O METODO DE UPDATE
				System.out.println("Resevation: " + reservation);
				}
			}
			
		sc.close();	
	}
}