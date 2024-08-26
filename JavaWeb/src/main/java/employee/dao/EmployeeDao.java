package employee.dao;

import java.util.List;

public class EmployeeDao {
	// 員工姓名資料
	private static List<String> employeeNames = List.of("John", "Mary", "Jack", "Rose", "Helen");
	
	// 查詢全部員工姓名
	public List<String> findAllNames() {
		return employeeNames;
	}
	
}
