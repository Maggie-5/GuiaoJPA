package main;
import java.io.IOException;
import java.util.Scanner;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
static EntityManagerFactory emf;
// Como criar o EntityManagerFactory ????
public static void main(String[] args) throws IOException {
Scanner in = new Scanner(System.in);
Menu.mainMenu(in);
System.out.println("done.");
}
}
