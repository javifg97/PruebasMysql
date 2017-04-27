
public class Test {
	public static void main(String[] args) {
		Conexion con = new Conexion();
		System.out.println(con.Query("Select * from equipos"));
		con.Consulta2("SELECT * FROM jugadores WHERE id_jugador=?", 2, 2);
		con.inserliga("INSERT INTO liga.jugadores VALUES (16, 'Paco', 'Florez', 'ala-pivot', ?, 2017-04-04 00:00:00, 2000, 3, 1.80)", 2);
	}
}
