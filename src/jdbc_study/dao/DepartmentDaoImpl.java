package jdbc_study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jdbc_study.dto.Department;
import jdbc_study.jdbc.MySQLjdbcUtil;

public class DepartmentDaoImpl implements DepartmentDao {
	Logger LOG = LogManager.getLogger();
	@Override
	public List<Department> selectDepartmentByAll(){
		List<Department> list = new ArrayList<>();
		String sql = "select deptno, deptname, floor from department";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = MySQLjdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			LOG.debug(pstmt);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int deptNo = rs.getInt("deptno");
				String deptName = rs.getString("deptname");
				int floor = rs.getInt("floor");
				Department dept = new Department(deptNo, deptName, floor);
				list.add(dept);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		
		return list;
	}

}
