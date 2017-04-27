import java.sql.*;

public class Conexion {

	// Atributos de la clase
	private String bd = "liga-jaime";
	private String login = "root";
	private String pwd = "";
	private String url = "jdbc:mysql://localhost/" + bd;
	private Connection conexion;

	// Constructor que crea la conexión
	public Conexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url, login, pwd);
			System.out.println(" - Conexión con MySQL establecida -");
		} catch (Exception e) {
			System.out.println(" – Error de Conexión con MySQL -");
			e.printStackTrace();
		}
	}

	public int Query(String str) {
		int cont = 0;
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(str);

			while (rset.next()) {
				cont += rset.getInt("puntos");
			}

		} catch (Exception e) {
			System.out.println(" – Error de Query MySQL -");
			e.printStackTrace();
		}
		return cont;

	}

	public void Consulta2(String query, int cod, int columna) {
		try {
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setInt(1, cod);
			ResultSet rset = pstmt.executeQuery();
			while (rset.next())
				System.out.println(rset.getString(columna));
			rset.close();
			pstmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	public void inserliga(String str, int cap) {
		try {
			PreparedStatement pstmt = conexion.prepareStatement(str);
			pstmt.setInt(1, cap);
			int r = pstmt.executeUpdate(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
