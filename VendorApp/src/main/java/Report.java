import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.srh.util.AppLog;
import org.srh.util.StringUtil;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.exception.DRException;

public class Report {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// JasperReportBuilder report = DynamicReports.report();
		Class.forName("com.mysql.jdbc.Driver");
		String host = "jdbc:mysql://localhost:3306/vendor_integration_app";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = StringUtil.append( " SELECT ",
				"   cp.Id, pm.productName AS `product`, cp.productCount AS `count`, pm.productPrice, cp.totalPrice AS `cost`, ",
				"   cc.cartId, cc.displayName AS `cartName`, cc.totalPrice AS `totalBill`, cc.createdOn ",
				" FROM cart_product cp ",
				" INNER JOIN products_master pm ON pm.id = cp.productId ",
				" INNER JOIN customer_cart cc ON cc.cartId = cp.cartId ",
				" ORDER BY Id DESC" );

		try {
			conn = DriverManager.getConnection(host,"root", "root");
			showJasperReport(query, conn);
			// printQueryResult(conn, ps, rs, query);
		}
		catch(Exception ex) {
			AppLog.log(Report.class, ex);
		}
		finally {
			if(rs!=null) { rs.close(); }
			if(ps!=null) { ps.close(); }
			if(conn!=null) { conn.close(); }
		}
	}


	private static void showJasperReport(String query, Connection conn) throws DRException, FileNotFoundException {
		JasperReportBuilder report = DynamicReports.report();
		report.columns(
		    Columns.column("Id", "id", DataTypes.longType()),
		    Columns.column("ProductName", "productName", DataTypes.stringType()),
		    Columns.column("Product Price", "productPrice", DataTypes.bigDecimalType()),
		    Columns.column("Count", "productCount", DataTypes.integerType()),
		    Columns.column("Cost", "cost", DataTypes.bigDecimalType()),
		    Columns.column("Cart Id", "cartId", DataTypes.integerType()),
		    Columns.column("Cart Name", "cartName", DataTypes.stringType()),
		    Columns.column("Total Bill", "totalBill", DataTypes.bigDecimalType()),
		    Columns.column("Created On", "createdOn", DataTypes.dateType())
	    )
		.title(//title of the report
			    Components.text("SimpleReportExample")
			      .setHorizontalAlignment(HorizontalAlignment.CENTER))
			  .pageFooter(Components.pageXofY())
			  .setDataSource(query, conn);
		
		report.show();
		report.toPdf(new FileOutputStream("C:/vendorapp/report.pdf"));
	}


	private static void printQueryResult(Connection conn, PreparedStatement ps, ResultSet rs, String query)
			throws SQLException {
		ps = conn.prepareStatement(query);
		rs = ps.executeQuery();
		while(rs.next()) {
			AppLog.print(" " + rs.getObject(1) + " " + rs.getObject(2) + " " + rs.getObject(3) + " " + rs.getObject(4)
			 + " " + rs.getObject(5) + " " + rs.getObject(6) + " " + rs.getObject(7) + " " + rs.getObject(8));
		}
	}
}
