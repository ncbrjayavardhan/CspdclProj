package SqlDbFileToJson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.database.DbConnection;
import com.database.FileNameAutoChange;
import com.database.JavaCreateDirectoryExample;

import cspdcl.input.DataStroringAutomatically;
//import com.mysema.util.ResultSetAdapter;

public class SqlDbFileToJson {

	/**
	 * Connect to the test.db database
	 * 
	 * @return the Connection object
	 */
	private Connection connect(String path) {
		// SQLite connection string
//        String url = "jdbc:sqlite:C://sqlite/db/test.db";
//      String url = "jdbc:sqlite:D:/CSPDCL/mobile db files/DMP_09052019_125413(0).db";

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(path);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	/**
	 * select all rows in the warehouses table
	 */
	public void selectAll(String path) {

		System.out.println("start");
//        String sql = "SELECT id, name, capacity FROM warehouses";
		String sql = "SELECT * FROM SBMTOPC";
//        String sql = "SELECT * FROM PCTOSBM";
		System.out.println("PATH= " + path);

		String jsonString = "";
		JSONObject jsonobject = null;
		JSONArray jsonArray = new JSONArray();

		Connection con = null;
		File dbCsvFile = null;
		FileWriter dbfilecsvWriter = null;

		try (Connection conn = this.connect(path);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			dbCsvFile = new File("d://dbcsvfile.json");
			dbfilecsvWriter = new FileWriter(dbCsvFile);

			while (rs.next()) {

				ResultSetMetaData metaData = rs.getMetaData();
				jsonobject = new JSONObject();

				for (int i = 0; i < metaData.getColumnCount(); i++) {

					try {
						jsonobject.put(metaData.getColumnLabel(i + 1), rs.getObject(i + 1));

					} catch (JSONException e) {
						e.printStackTrace();
					}

				}

				jsonArray.put(jsonobject);
			}

			if (jsonArray.length() > 0) {

				jsonString = jsonArray.toString();

			}

			dbfilecsvWriter.write(jsonString);

//	            System.out.println(jsonString);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		}

		try {

			if (dbfilecsvWriter != null) {
				dbfilecsvWriter.flush();
				dbfilecsvWriter.close();
				dbCsvFile.exists();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("end");

	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		SqlDbFileToJson app = new SqlDbFileToJson();
//        app.selectAll("jdbc:sqlite:D:/CSPDCL/mobile db files/DMP_09052019_125413(0).db");
//		app.selectAll("jdbc:sqlite:C:\\Users\\admin\\Downloads\\DMP_04062019_124505.db");
		app.selectAll("jdbc:sqlite:C:/CSPDCL/db Files/DMP_04062019_124505.db");

	}

}
