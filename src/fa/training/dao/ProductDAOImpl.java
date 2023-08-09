package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static fa.training.common.SQLStatementConstant.*;

import fa.training.common.DBUtils;

import fa.training.entities.Product;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public boolean addProduct(Product product) {

		try (Connection conn = DBUtils.getConnection();) {
			PreparedStatement stm = conn.prepareStatement(ADD_PRODUCT);

			stm.setString(2, product.getProductName());
			stm.setDouble(3, product.getListPrice());

			int rows = stm.executeUpdate();
			return rows == 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
