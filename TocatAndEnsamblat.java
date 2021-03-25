package uf1act1;

import java.util.Random;
import java.util.Scanner;



public class TocatEnfonsat {
	public static void  omplirRandom (char vTauler [] [], int quantVaixell, int mida) {/*Funció per omplir vTauler de vaixells aleatòriament */
		Random rnd = new Random();
		int i,j,contPunts=0,posCol,posFil,k=0, direccio;
				//em dona la mida del vaixell, genero la posició on comença de forma aleatoria
				//si en aquesta posició o en les següents hi ha qualsevol caràcter que no sigui un punt genera nova posició
				//comprobo si la posició inicial del vaixell més la seva mida dona una posició major que els limits
				//de la matriu 
				//si la direcció és horitzontal tan sols incrementare la i
				//si la direcció és vertical tan sols incrementare la j
				// després de posar el vaixell omplire de * el seu voltant
			
				// Nota: es mejor poner la restricción del límite en el random y no tener que comprobarlo después
				//el límite será la 10-mida
		while(k!=quantVaixell) {//un while que s'executa fins a posar els vaixells de cada tipus
			direccio=rnd.nextInt(2);//si dona 1 la direcció serà vertical, si dona 0 serà horitzontal
			if(direccio==0) {//en cas de ser horitzontal
				contPunts=0;
				posCol=rnd.nextInt(10-mida);//posicio inicial de columna  del 0 a 10-mida 
				posFil=rnd.nextInt(10);//posicio inicial de fila  del 0 al 9
				for(i=0;i<=mida;i++) {//comrpobar si n'hi ha punts en les successives posicions del vaixell
					if(vTauler[posFil] [posCol+i]=='.') {
						contPunts=contPunts+1;
					}
				}
				if(contPunts==mida+1) {//si n'hi ha tants punts com espais necessita el vaixell, ho escriu
					if(posFil==0) {//si es tracta de la primera  fila
						if(posCol==0) {
							vTauler[posFil] [posCol+mida]='*';//reservo l'espai  després del vaixell
						}
						else if(posCol!=0) {//si no es tracta de la columna 0 (per evitar l'error de fora d'index)
							vTauler[posFil] [posCol+mida]='*';//reservo l'espai  després i abans del vaixell
							vTauler[posFil] [posCol-1]='*';
						}
						for(i=0;i<mida;i++) {//escriure el vaixell
							vTauler[posFil] [posCol+i]='X';
							vTauler[posFil+1] [posCol+i]='*';//reserva l'espall  sota del vaixell
						}
						k++;
					}
					if(posFil==9) {//si es tracta de l'última  fila
						if(posCol==0) {
							vTauler[posFil] [posCol+mida]='*';//reservo l'espai  després del vaixell
						}
						else if(posCol!=0) {//si no es tracta de la columna 0 (per evitar l'error de fora d'index)
							vTauler[posFil] [posCol+mida]='*';//reservo l'espai  després i abans del vaixell
							vTauler[posFil] [posCol-1]='*';
						}
						for(i=0;i<mida;i++) {//escriure el vaixell
							vTauler[posFil] [posCol+i]='X';
							vTauler[posFil-1] [posCol+i]='*';//reserva l'espall  sobre  el vaixell
						}
						k++;
					}
					else if (posFil!=9 && posFil!=0) {
						if(posCol==0) {
							vTauler[posFil] [posCol+mida]='*';//reservo l'espai  després del vaixell
						}
						else if(posCol!=0) {//si no es tracta de la columna 0 (per evitar l'error de fora d'index)
							vTauler[posFil] [posCol+mida]='*';//reservo l'espai  després i abans del vaixell
							vTauler[posFil] [posCol-1]='*';
						}
						for(i=0;i<mida;i++) {//escriure el vaixell
							vTauler[posFil] [posCol+i]='X';
							vTauler[posFil-1] [posCol+i]='*';//reserva l'espall sota i sobre  el vaixell
							vTauler[posFil+1] [posCol+i]='*';
						}
						k++;
					}
				}
				
			}
			if(direccio==1) {//en cas de ser vertical
				contPunts=0;
				posCol=rnd.nextInt(10);//posicio inicial de columna   del 0 al 9
				posFil=rnd.nextInt(10-mida);//posicio inicial de fila  del 0 a 10-mida
				for(i=0;i<=mida;i++) {//comrpobar si n'hi ha punts en les successives posicions del vaixell
					if(vTauler[posFil+i] [posCol]=='.') {
						contPunts++;
					}
				}
				if(contPunts==mida+1) {//si n'hi ha tants punts com espais necessita el vaixell, ho escriu
					if(posCol==0) {//si es tracta de la primera  columna
						if(posFil==0) {
							vTauler[posFil+mida] [posCol]='*';//reservo l'espai  després del vaixell
						}
						else if(posFil!=0) {//si no es tracta de la columna 0 (per evitar l'error de fora d'index)
							vTauler[posFil+mida] [posCol]='*';//reservo l'espai  després i abans del vaixell
							vTauler[posFil-1] [posCol]='*';
						}
						for(i=0;i<mida;i++) {//escriure el vaixell
							vTauler[posFil+i] [posCol]='X';
							vTauler[posFil+i] [posCol+1]='*';//reserva l'espall  a la dreta del vaixell
						}
						k++;
					}
					if(posCol==9) {//si es tracta de l'última  columna
						if(posFil==0) {
							vTauler[posFil+mida] [posCol]='*';//reservo l'espai  després del vaixell
						}
						else if(posFil!=0) {//si no es tracta de la columna 0 (per evitar l'error de fora d'index)
							vTauler[posFil+mida] [posCol]='*';//reservo l'espai  després i abans del vaixell
							vTauler[posFil-1] [posCol]='*';
						}
						for(i=0;i<mida;i++) {//escriure el vaixell
							vTauler[posFil+i] [posCol]='X';
							vTauler[posFil+i] [posCol-1]='*';//reserva l'espall  a l'esquerra del vaixell
						}
						k++;
					}
					else if (posCol!=9 && posCol!=0) {
						if(posFil==0) {
							vTauler[posFil+mida] [posCol]='*';//reservo l'espai  després del vaixell
						}
						else if(posFil!=0) {//si no es tracta de la columna 0 (per evitar l'error de fora d'index)
							vTauler[posFil+mida] [posCol]='*';//reservo l'espai  després i abans del vaixell
							vTauler[posFil-1] [posCol]='*';
						}
						for(i=0;i<mida;i++) {//escriure el vaixell
							vTauler[posFil+i] [posCol]='X';
							vTauler[posFil+i] [posCol+1]='*';//reserva l'espall  a amdos costats del vaixell
							vTauler[posFil+i] [posCol-1]='*';
							
						}
						k++;
					}
				}
				
			}
			
		}
		
			
	}
	public static void mostrar(char[][] Matriu) { //Mostrarem el tauler amb caracters.
		int f,c;
		
		System.out.print(" ");
		for(f=0; f<Matriu.length; f++) { //Mostra els número de index de dalt
			System.out.print(" ");
			System.out.print(f);
		}
		System.out.println();
		for(f=0; f<Matriu.length; f++) {
			System.out.print(f);
			for(c=0; c<Matriu.length; c++) {
				System.out.print(" " + Matriu[f][c]);
			}
			System.out.println();
		}
		
	}
	public static void omplirPunts(char[][] Matriu) { //Omplir matriu amb punts
		int i,j;
		for (i=0;i<Matriu.length;i++){//omplir la matriu amb punts
			for (j=0;j<Matriu[i].length;j++){
				Matriu[i] [j]='.';
			}
		}
	}
	public static void main(String[] args) {
		/*Crear la matriu vTauler amb els vaixells de forma aleatoria */
		
		Scanner teclat = new Scanner(System.in);
		Random rnd = new Random();
		int  i,j,mida,quantVaixell,userFil,userCol,intents=0,enfonsats=0;
		char [] [] vTauler=new char [10] [10];//matriu principal amb els vaixells
		char [][] vUsuari=new char[10][10];//tauler per mostrar a l'usuari
		omplirPunts(vUsuari);//omplir les dos matrius amb punts
		omplirPunts(vTauler);
		omplirRandom(vTauler, 1,4);	/*1 vaixell de 4, 2 de 3, 3 de 2 i 4 d’1*/
		omplirRandom(vTauler, 2,3);
		omplirRandom(vTauler, 3,2);
		omplirRandom(vTauler, 4,1);
		
		mostrar(vTauler);//només per comprobar
		
		
		
		
		System.out.println("------------------");
		while(intents!=25 || enfonsats!=10) {//itera fins a enfonsar tots els  vaixells o arribar a 25 intents
			mostrar(vUsuari);//mostra la matriu d'usuari
			System.out.println("Introdueix la fila: ");
			userFil=teclat.nextInt()-1;
			System.out.println("Introdueix la columna: ");
			userCol=teclat.nextInt()-1;
			//funcio comprobar, també caldra cambiar el tauler principal
			if(-1<userFil && userFil<10 && -1<userCol && userCol<10) {//si ha donat una selecció valida, l'usuari introduïra valors de l'1 al 10
				if(vTauler[userFil] [userCol]=='X') {//si hi ha una part de vaixell al lloc seleccionat
					//posar una T en el lloc seleccionat per indicar que ja s'ha utilitzat
					vTauler[userFil] [userCol]='T';
					//posar la X en el tauler de l'usuari
					vUsuari[userFil] [userCol]='X';
					//si no hi ha cap part del vaixell al costat de la posició seleccionado vol dir que la enfonsat
					//probare cada limit de la matriu per tal de no buscar una posició fora d'aquesta
					if(userFil==0) {//per cadascun ddel 4 límits de matriu n'hi ha 3 diferents possibles posicions
						if(userCol==0) {
							if(vTauler[userFil+1] [userCol]=='X' || vTauler[userFil] [userCol+1]=='X') {
								System.out.println("Vaixell tocat");
								intents++;
								enfonsats++;
							}
							else {
								System.out.println("Vaixell enfonsat");
								intents++;
								
							}
						}
						else if(userCol==9) {
							if(vTauler[userFil+1] [userCol]=='X' || vTauler[userFil] [userCol-1]=='X') {
								System.out.println("Vaixell tocat");
								intents++;
								enfonsats++;
							}
							else {
								System.out.println("Vaixell enfonsat");
								intents++;
								
							}
						}
						else{//si no és a una esquina del tauler
							if(vTauler[userFil+1] [userCol]=='X' || vTauler[userFil] [userCol+1]=='X' || vTauler[userFil] [userCol-1]=='X') {
								System.out.println("Vaixell tocat");
								intents++;
								enfonsats++;
							}
							else {
								System.out.println("Vaixell enfonsat");
								intents++;
								
							}
						}
					}
					else if(userFil==9) {
						if(userCol==0) {
							if(vTauler[userFil-1] [userCol]=='X' || vTauler[userFil] [userCol+1]=='X') {
								System.out.println("Vaixell tocat");
								intents++;
								enfonsats++;
							}
							else {
								System.out.println("Vaixell enfonsat");
								intents++;
								
							}
						}
						else if(userCol==9) {
							if(vTauler[userFil+1] [userCol]=='X' || vTauler[userFil] [userCol-1]=='X') {
								System.out.println("Vaixell tocat");
								intents++;
								enfonsats++;
							}
							else {
								System.out.println("Vaixell enfonsat");
								intents++;
								
							}
						}
						else{//si no és a una esquina del tauler
							if(vTauler[userFil-1] [userCol]=='X' || vTauler[userFil] [userCol+1]=='X' || vTauler[userFil] [userCol-1]=='X') {
								System.out.println("Vaixell tocat");
								intents++;
								enfonsats++;
							}
							else {
								System.out.println("Vaixell enfonsat");
								intents++;
								
							}
						}
					}
					else if(userCol==0) {
						if(userFil==0) {
							if(vTauler[userFil+1] [userCol]=='X' || vTauler[userFil] [userCol+1]=='X') {
								System.out.println("Vaixell tocat");
								intents++;
								enfonsats++;
							}
							else {
								System.out.println("Vaixell enfonsat");
								intents++;
								
							}
						}
						else if(userFil==9) {
							if(vTauler[userFil-1] [userCol]=='X' || vTauler[userFil] [userCol+1]=='X') {
								System.out.println("Vaixell tocat");
								intents++;
								enfonsats++;
							}
							else {
								System.out.println("Vaixell enfonsat");
								intents++;
								
							}
						}
						else{//si no és a una esquina del tauler
							if(vTauler[userFil+1] [userCol]=='X' || vTauler[userFil] [userCol+1]=='X' || vTauler[userFil-1] [userCol]=='X') {
								System.out.println("Vaixell tocat");
								intents++;
								enfonsats++;
							}
							else {
								System.out.println("Vaixell enfonsat");
								intents++;
								
							}
						}
					}
					else if(userCol==9) {
						if(userFil==0) {
							if(vTauler[userFil+1] [userCol]=='X' || vTauler[userFil] [userCol-1]=='X') {
								System.out.println("Vaixell tocat");
								intents++;
								enfonsats++;
							}
							else {
								System.out.println("Vaixell enfonsat");
								intents++;
								
							}
						}
						else if(userFil==9) {
							if(vTauler[userFil-1] [userCol]=='X' || vTauler[userFil] [userCol-1]=='X') {
								System.out.println("Vaixell tocat");
								intents++;
								enfonsats++;
							}
							else {
								System.out.println("Vaixell enfonsat");
								intents++;
								
							}
						}
						else{//si no és a una esquina del tauler
							if(vTauler[userFil+1] [userCol]=='X' || vTauler[userFil] [userCol-1]=='X' || vTauler[userFil-1] [userCol]=='X') {
								System.out.println("Vaixell tocat");
								intents++;
								enfonsats++;
							}
							else {
								System.out.println("Vaixell enfonsat");
								intents++;
								
							}
						}
						
					}
					else if(userCol!=9 && userCol!=0 && userFil!=0 && userFil!=9) {//si no es troba a cap límit
						if(vTauler[userFil+1] [userCol]=='X' || vTauler[userFil] [userCol-1]=='X' || vTauler[userFil-1] [userCol]=='X' || vTauler[userFil] [userCol+1]=='X') {
							System.out.println("Vaixell tocat");
							intents++;
							enfonsats++;
						}
						else {
							System.out.println("Vaixell enfonsat");
							intents++;
							
						}
					}
				}
				else if(vTauler[userFil] [userCol]=='T') {System.out.println("Ja has escollit aquesta posició");}
				else if(vTauler[userFil] [userCol]!='X') {
					System.out.println("Aigua");
					vUsuari[userFil] [userCol]='~';
					intents++;
				}
			}
			else {System.out.println("Has d'escollir una posició dins del tauler");}
		}
		
		
		
		
		teclat.close();
		
		
	}

}
