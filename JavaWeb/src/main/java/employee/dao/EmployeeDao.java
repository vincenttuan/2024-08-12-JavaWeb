package employee.dao;

import java.util.List;

public class EmployeeDao {
	// 員工資料
	private static List<String> employeeNames = List.of("John", "Mary", "Jack", "Rose", "Helen");
	
	// 查詢全部
	public List<String> findAllNames() {
		return employeeNames;
	}
	
}
