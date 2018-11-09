package jdbc_study.jdbc;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import jdbc_study.dao.DepartmentDao;
import jdbc_study.dao.DepartmentDaoImpl;
import jdbc_study.dto.Department;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentDaoTest {
	static DepartmentDao dao;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		MySQLjdbcUtilTest.LOG.debug("tearDownAfterClass()");
		dao =  new DepartmentDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		MySQLjdbcUtilTest.LOG.debug("tearDownAfterClass()");
		dao =  null;
	}

	@Test
	public void test1SelectDepartmentByAll() {
		List<Department> list = dao.selectDepartmentByAll();
		for(Department dept : list) {
			MySQLjdbcUtilTest.LOG.debug(dept);
		}
		Assert.assertNotEquals(0, list.size());
	}
	
	@Test
	public void test2InsertDepartment() {
		Department newDept = new Department(4,"자바개발부서",15);
		try {
			int res = dao.insertDepartment(newDept);
			Assert.assertNotEquals(1, res);
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
			e.printStackTrace();
			if(e.getErrorCode() == 1062) {
				JOptionPane.showMessageDialog(null, "해당부서가 존재합니다.");
			}
			
		}
		
	}
	
	
	/*@Test
	public void test4DeleteDepartment() {
		Department newDept = new Department(4);
		try {
			int res = dao.deleteDepartment(newDept);
			Assert.assertEquals(1, res);
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
			e.printStackTrace();
		}
	}*/
	
	@Test
	public void test3UpdateDepartment() {
		Department newDept = new Department(4);
		try {
			int res = dao.updateDepartment(newDept);
			Assert.assertNotEquals(1, res);
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
			e.printStackTrace();
			
		}
		
	}
	
	@Test
	public void test5SelectDepartmentByNo() {
		
	}
}
	
	
	
	
	
	
	
	
