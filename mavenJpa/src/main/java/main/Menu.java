package main;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import domain.Aluno;
import domain.Disciplina;
/**
* This class deals with the interactions with the user.
*
* @author Thibault Langlois
*/
public class Menu {
/**
* The main menu of the application.
*
* @param in a Scanner instance that correspond to the input of the program.
* @return
* @throws IOException
*/
static void mainMenu(Scanner in) throws IOException {
boolean end = false;
do {
System.out.println("Escolhe uma opção: ");
System.out.println("Lista de alunos ..................1");
System.out.println("Lista de disciplinas..............2");
System.out.println("Adicionar aluno...................3");
System.out.println("Adicionar disciplina..............4");
System.out.println("Procurar aluno pelo nome..........5");
System.out.println("Inscrever aluno...................6");
System.out.println("Procurar disciplina pela sigla....7");
System.out.println("Terminar..........................8");
System.out.println("> ");
switch (nextInt(in)) {
case 1:
listaDosAlunos();
break;
case 2:
//listaDasDisciplinas();
break;
case 3:
adicionarAluno(in);
break;
case 4:
adicionarDisciplina(in);
break;
case 5:
//procurarAlunoPeloNome(in);
break;
case 6:
//inscreverAluno(in);
break;
case 7:
//procurarDisciplinaPelaSigla(in);
break;
case 8:
end = true;
}
} while (!end);
}
private static void adicionarAluno(Scanner in) {
EntityManager em = null;
System.out.println("Nome: ");
String nome = nextLine(in);
Aluno a = new Aluno(nome);
try {
em = ((EntityManagerFactory) em).createEntityManager();// TODO criar o entity manager
em.getTransaction().begin(); // TODO iniicar a transação
em.persist(a); // TODO persistir a entidade
em.getTransaction().commit(); // TODO terminar a transação
System.out.println("Commit done.");
} finally {
if (em != null)
em.close();
}
}
private static void listaDosAlunos() {
List<Aluno> result = null;
EntityManager em = null;
try {
em = Main.emf.createEntityManager();
TypedQuery<Aluno> query = em.createQuery("SELECT a FROM ALUNO a", Aluno.class);
result = query.getResultList();
} catch (Exception e) {
System.err.println(e.getMessage());
e.printStackTrace();
} finally {
em.close();
}
//printListaDeAlunos(result);
}
private static void adicionarDisciplina(Scanner in) {
System.out.print("Designação da disciplina: ");
String designacao = nextLine(in);
System.out.print("Sigla da disciplina: ");
String sigla = nextLine(in);
System.out.print("Semestre da disciplina (1 ou 2):");
int semestre = nextInt(in);
EntityManager em = null;
Disciplina d = new Disciplina(designacao, sigla, semestre);
try {
em = ((EntityManagerFactory) em).createEntityManager();// TODO criar o entity manager
em.getTransaction().begin(); // TODO iniciar a transação
em.persist(d); // TODO persistir a entidade
em.getTransaction().commit(); // TODO terminar a transação
System.out.println("Commit done.");
} finally {
if (em != null)
em.close();
}
}
//private static void listaDasDisciplinas() {
//List<Disciplina> result = null;
//EntityManager em = null;
//try {
//em = // TOTO criar o entity manager
//TypedQuery<Disciplina> query = em.createQuery(/* que parâmetros ??? */);
//result = query.getResultList();
//} finally {
//em.close();
//}
//// para apresentação do resultados:
//List<List<String>> printableResult = new ArrayList<>();
//for (Disciplina d : result) {
//List<String> l = new ArrayList<>();
//l.add(Integer.toString(d.getCodigoDeDisciplina()));
//l.add(d.getSigla());
//l.add(Integer.toString(d.getSemestre()));
//l.add(d.getDesignacao());
//printableResult.add(l);
//}
//// A classe utils.Table é fornecida.
//System.out.println(utils.Table.tableToString(printableResult));
//}
//private static void procurarDisciplinaPelaSigla(Scanner in) {
//System.out.print("Sigla da disciplina: ");
//String sigla = nextLine(in);
//Disciplina result = null;
//EntityManager em = null;
//try {
//em = // TODO criar o entity manager
//TypedQuery<Disciplina> query =
//em.createQuery("SELECT a FROM DISCIPLINA a where a.sigla = ?1",
//Disciplina.class);
//query.setParameter(1, sigla);
//result = query.getSingleResult();
//} finally {
//em.close();
//}
//System.out.println(result);
//}
//private static void inscreverAluno(Scanner in) {
//EntityManager em = null;
//System.out.print("Número do aluno: ");
//int n = nextInt(in);
//System.out.print("Código da disciplina: ");
//int codigo = nextInt(in);
//try {
//em = // TODO criar o entity manager
//em. // TODO iniciar a transação
//Aluno oAluno = em.find(/* que parâmetros ??? */);
//Disciplina aDisciplina = em.find(/* que parâmetros ??? */);
//if (oAluno != null && aDisciplina != null) {
//oAluno.adicionaDiciplina(aDisciplina);
//} else if (oAluno == null) {
//System.out.println("O aluno não foi encontrado.");
//} else {
//System.out.println("A disciplina não foi encontrada.");
//}
//em. // TODO: terminar a transação
//} finally {
//if (em != null)
//em.close();
//}
//}
//private static void procurarAlunoPeloNome(Scanner in) {
//System.out.println("Nome: ");
//String nome = nextLine(in);
//List<Aluno> result = null;
//EntityManager em = null;
//try {
//em = Main.emf.createEntityManager();
//TypedQuery<Aluno> query =
//em.createQuery(/* que parâmetros ??? */);
//query.// TODO inicializar os parâmetros da query
//result = query. // Obter a lista de resultados da query
//} finally {
//em.close();
//}
//printListaDeAlunos(result);
//}
//private static void printListaDeAlunos(List<Aluno> result) {
//if (result.size() > 0) {
//List<List<String>> printableResult = new ArrayList<>();
//for (Aluno a : result) {
//List<String> l = new ArrayList<>();
//l.add(Integer.toString(a.getNumeroDoAluno()));
//l.add(a.getNomeDoAluno());
//Set<Disciplina> ds = a.getListaDeDisciplinas();
//if (ds.size() > 0) {
//l.add(ds.stream().map((Disciplina d) -> d.getSigla()).collect(Collectors.toList()).toString());
//} else {
//l.add("N/A");
//}
//printableResult.add(l);
//}
//System.out.println(utils.Table.tableToString(printableResult));
//}
//}
/*
* The following methods read several kinds of values from a Scanner. The
* Scanner may correspond to System.in of to an input file. This allows
* automatic testing of the application through "use cases" that are tested
* using the executeUseCase method in the App class. The reason for using these

* methods instead of Scanner's nextXXX() methods is they allow comments in the
* use case files. Comments are begin with # and end at the end of the line.
*
*/
private static int nextInt(Scanner in) {
String s = in.nextLine();
while (s.startsWith("#")) {
s = in.nextLine();
}
if (s.contains("#")) {
try (Scanner sc = new Scanner(s)) {
s = sc.next();
}
}
return Integer.parseInt(s);
}
private static String nextLine(Scanner in) {
String s = in.nextLine();
while (s.startsWith("#")) {
s = in.nextLine();
}
if (s.contains("#")) {
int p = s.indexOf("#");
s = s.substring(0, p).trim();
}
return s;
}
}
