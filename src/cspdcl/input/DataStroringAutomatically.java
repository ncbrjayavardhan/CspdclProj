package cspdcl.input;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataStroringAutomatically {
	
	public int exicuteQuery(String Qury, Connection con) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean status=false;
		int kk=0;
			
			 ps = con.prepareStatement(Qury);
			 kk = ps.executeUpdate();
				
				
			return kk;
	}

	
public ResultSet exicuteQueryReesultSet(String Qury, Connection con) {
	PreparedStatement ps = null;
	ResultSet rs = null;
	int kk=0;
		try {
		 ps = con.prepareStatement(Qury);
		 rs = ps.executeQuery();
		}catch (Exception e) {
			e.printStackTrace();
		}
	return rs;
	}
}
