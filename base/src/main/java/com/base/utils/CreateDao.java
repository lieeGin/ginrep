package com.base.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdao.base.QueryDao;
import com.jdao.util.CreateDaoUtil;

public class CreateDao {
	static Connection conn = null;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String driverUrl = "jdbc:mysql://localhost:3306/mydatabase";
			String username = "root";
			String password = "root";
			conn = DriverManager.getConnection(driverUrl, username, password);
		} catch (Exception e) {
		}
	}

	public void createDao4jdbc(String packageName, String tableName, String descFile) throws Exception {

		if (tableName == null || "".equals(tableName)) {// 如果没传表名，则生成整个数据库的DO
			List<String> tableNames = showTables(conn);
			for (String tableName1 : tableNames) {
				try {
					CreateDaoUtil.createFileForce(packageName, tableName1, descFile, conn, "utf-8");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			CreateDaoUtil.createFileForce(packageName, tableName, descFile, conn, "utf-8");
		}
	}

	public static List<String> showTables(Connection conn) throws SQLException {
		String sql = "show tables";
		ResultSet rs = conn.prepareStatement(sql).executeQuery();
		List<String> tableNames = new ArrayList<String>();
		while (rs.next()) {
			tableNames.add(rs.getString(1));
		}
		return tableNames;
	}

	public static void test() throws Exception {
		String sql = "SELECT a.courseId,a.dayNum,a.nightNum,a.courseNum, MIN(b.currentPrice) AS currentPrice FROM CH_TourPackage a,CH_PackageSpecification b WHERE a.bookStatus=0 AND a.packageId=b.packageId AND endDate>='2016-05-10' AND houseId IN (11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,58,59,60,62,63,64,65,66,67,69,70,73,75,78,406,407,413,441,442,452,527,688,689,1157,1159,1163,1167,1171,1181,1405,2743,2744,2745,2746,2747,2748,2749,2750,2751,2752,2754,2755) GROUP BY a.courseId,a.dayNum,a.nightNum,a.courseNum ORDER BY MIN(b.currentPrice) LIMIT 0,20";
		// String sql =
		// "SELECT a.* FROM CH_TourPackage a,CH_PackageSpecification b WHERE a.bookStatus=0 AND a.packageId=b.packageId GROUP BY a.courseId,a.dayNum,a.nightNum,a.courseNum  LIMIT 0,20";
		// String sql =
		// "SELECT  A.packageid, MIN(b.currentPrice) currentPrice from ch_tourpackage A , ch_packagespecification B where A.packageid=B.packageid group by A.packageid limit 1";
		QueryDao qd = new QueryDao(conn, sql);
		System.out.println(qd.size());
	}

	public static void main(String[] args) throws Exception {
		new CreateDao().createDao4jdbc("com.base.dao", "sys_user", System.getProperty("user.dir") + "\\src\\main\\java\\com\\base\\dao");
		// test();
	}
}
