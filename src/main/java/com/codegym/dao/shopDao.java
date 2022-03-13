package com.codegym.dao;

import com.codegym.model.Cart;
import com.codegym.model.OderDetail;
import com.codegym.model.Product;
import com.codegym.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class shopDao implements IShopDao {
    private Connection connection = DBConnection.getConnection();
    public static final String SQL_SELECT_ALL_PRODUCT = "SELECT * FROM product;";
    public static final String SQL_FIND_PRODUCT_BY_CATEGORY = "SELECT * FROM product Where category_id=?;";
    public static final String SQL_ADD_USER = "INSERT INTO user(username, email,address, phone, password, role_id,status) VALUES (?,?,?,?,?,2,true);";
    public static final String SQL_FIND_USER_BY_EMAIL = "SELECT * FROM user Where email=?;";
    public static final String SQL_SORT_PRODUCT_LOW_TO_HIGHT_PRICE= "SELECT * FROM product ORDER BY price ASC;";
    public static final String SQL_SORT_PRODUCT_HIGHT_TO_LOW_PRICE = "SELECT * FROM product ORDER BY price DESC;";
    public static final String SQL_SORT_PRODUCT_BY_NAME="SELECT * FROM product ORDER BY name DESC;";
    public static final String SQL_FIND_PRODUCT_BY_NAME="SELECT * FROM product where name like ?";
    public static final String SQL_FIND_PRODUCT_BY_ID="SELECT * FROM product where id=?;";
    public static final String  SQL_INSERT_CART="INSERT INTO cart(id,user_id,orderDate)VALUE (?,?,?);";
    public static final String  SQL_INSERT_ODER_DETAIL="INSERT INTO orderdetail(cart_id,product_id,quantity)VALUE (?,?,?);";
    public static final String  SQL_FIND_MAX_CART_ID="SELECT MAX(id) as id FROM cart;";
    public static final String  SQL_CALL_PROCEDURE_BESTSELLER= "call best_seller();";
    public static final String  SQL_CALL_PROCEDURE_PURCHASE_HISTORY= "call PurchaseHistory(?);";
    public static final String SQL_FIND_CART_BY_ID="SELECT * FROM cart where id=?;";


    @Override
    public List<Product> displayAll() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_PRODUCT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                int categoryId = resultSet.getInt("category_id");
                String productImage=resultSet.getString("image");
                Product product = new Product(id, name, price, description,categoryId,productImage);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product findProductByID(int id) {
        Product product = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_PRODUCT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int category_id=resultSet.getInt("category_id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                String productImage = resultSet.getString("image");
                product=new Product(id, name, price, description,category_id,productImage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;

    }

    @Override
    public boolean CreateCart(Cart cart) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_CART);
            preparedStatement.setInt(1, cart.getId());
            preparedStatement.setInt(2, cart.getUser_id());
            preparedStatement.setString(3, cart.getOrderDate());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Cart findCartbyID(int cart_id) {
        Cart cart = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_CART_BY_ID);
            preparedStatement.setInt(1, cart_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id=resultSet.getInt("id");
                int user_id = resultSet.getInt("user_id");
                String orderDate = resultSet.getString("orderDate");
                cart=new Cart(id, user_id,orderDate);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return cart;
    }

    @Override
    public boolean CreateOderDetail(OderDetail oderDetail) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_ODER_DETAIL);
            preparedStatement.setInt(1, oderDetail.getCart_id());
            preparedStatement.setInt(2, oderDetail.getProduct_id());
            preparedStatement.setInt(3, oderDetail.getQuantity());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }




    @Override
    public List<Product> findbycategory(int category_id) {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_PRODUCT_BY_CATEGORY);
            preparedStatement.setInt(1, category_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id=resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                String productImage = resultSet.getString("image");
                products.add( new Product(id, name, price, description,category_id,productImage));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;

    }

    @Override
    public User findUserbyEmail(String email) {
        User user=null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_USER_BY_EMAIL);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("username");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String password = resultSet.getString("password");
                int role_id = resultSet.getInt("role_id");
                boolean staus = resultSet.getBoolean("role_id");
                user = new User(id, name, email, address, phone, password,role_id,staus);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int findMaxIDCart() {
        int id=0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_MAX_CART_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;

    }

    @Override
    public List<Product> sortProduct(int sortID) {
        List<Product> products = new ArrayList<>();
        String SQL=null;
        if (sortID==1) {
            SQL = SQL_SORT_PRODUCT_LOW_TO_HIGHT_PRICE;
        }else if(sortID==2) {
            SQL = SQL_SORT_PRODUCT_HIGHT_TO_LOW_PRICE;
        }else if(sortID==3) {
            SQL = SQL_SORT_PRODUCT_BY_NAME;
        }else {
            SQL=SQL_SELECT_ALL_PRODUCT;
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                int categoryId = resultSet.getInt("category_id");
                String productImage=resultSet.getString("image");
                Product product = new Product(id, name, price, description,categoryId,productImage);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;

    }

    @Override
    public List<Product> bestSeller() {
        List<Product> products = new ArrayList<>();
        try {
            CallableStatement callableStatement = connection.prepareCall(SQL_CALL_PROCEDURE_BESTSELLER);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("product_id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                int categoryId = resultSet.getInt("category_id");
                String productImage = resultSet.getString("image");
                Product product = new Product(id, name, price, description, categoryId, productImage);
                products.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<OderDetail> PurchaseHistory(int user_id) {
           List<OderDetail> oderDetails = new ArrayList<>();
        try {
            CallableStatement callableStatement = connection.prepareCall(SQL_CALL_PROCEDURE_PURCHASE_HISTORY);
            callableStatement.setInt(1, user_id);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int cart_id = resultSet.getInt("cart_id");
                int quantity = resultSet.getInt("quantity");
                int product_id = resultSet.getInt("product_id");
                OderDetail oderDetail = new OderDetail(id, cart_id , product_id,quantity);
                oderDetails.add(oderDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return oderDetails;
    }

    @Override
    public List<Product> findProductByName(String keyword) {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_PRODUCT_BY_NAME);
            preparedStatement.setString(1, keyword);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id=resultSet.getInt("id");
                String name = resultSet.getString("name");
                int category_id = resultSet.getInt("category_id");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                String productImage = resultSet.getString("image");
                products.add( new Product(id, name, price, description,category_id,productImage));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }



    @Override
    public boolean register(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getAddress());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getPassword());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }



}
