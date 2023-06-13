package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainExcepetions;

public class Program {

	public static void main(String[] args){ // Esse Metodo poderá lançar exceção sem tratar
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.printf("Room Number:");
			Integer room = sc.nextInt();
			System.out.printf("Check-in Date:");
			Date checkIn = sdf.parse(sc.next());
			System.out.printf("Check-Out Date:");
			Date checkOut = sdf.parse(sc.next());
			
			Reservation reservation = new Reservation(room, checkIn, checkOut);
			System.out.println("Reservation :" + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.printf("Check-in Date:");
			checkIn = sdf.parse(sc.next());
			System.out.printf("Check-Out Date:");
			checkOut = sdf.parse(sc.next());
			
			reservation.updateDate(checkIn, checkOut); // INSTANCIA O METODO DE UPDATE ERRO
			System.out.println("Reservation: "+reservation); 
		}
		catch (ParseException e){ // AQUI JÁ SE TRATA O ERRO LANÇANDO A MSG CASO INSIRA FORMATO DE DATA ERRADO
			System.out.println("Invalid date format");
		}
		catch (DomainExcepetions e){
			System.out.println("Error in reservation: "+ e.getMessage()); // JÁ TRAZ A MSG DO METODO EM CASO DE EXCEÇÃO 
		}
		catch (RuntimeException e) { // NESSE VOCÊ PODE COLOCAR EXCEÇÃO PRA ERROS INESPERADOS OU NÃO LISTADOS
			System.out.println("Unexpected error");
		}
		sc.close();	
	}
}