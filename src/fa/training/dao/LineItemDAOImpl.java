package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static fa.training.common.SQLStatementConstant.*;

import fa.training.common.DBUtils;
import fa.training.entities.LineItem;

public class LineItemDAOImpl implements LineItemDAO {

	@Override
	public boolean addLineItem(LineItem item) {

		try (Connection conn = DBUtils.getConnection();) {
			PreparedStatement stm = conn.prepareStatement(ADD_LINEITEM);

			stm.setInt(1, item.getOrderId());
			stm.setInt(2, item.getProductId());
			stm.setInt(3, item.getQuantity());
			stm.setDouble(4, item.getPrice());

			int rows = stm.executeUpdate();
			return rows == 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
