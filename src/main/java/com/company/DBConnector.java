package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnector {

    private static Connection con;

    public static Connection getConnection() {
        if (con != null)
            return con;
        try {
            Class.forName(Constants.DB_DRIVER_NAME);
            try {
                con = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USER, Constants.DB_PASS);
                System.out.println("Connection received");
            } catch (SQLException ex) {
                System.out.println("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found.");
        }
        return con;
    }

    /**
     * Function adds image to database
     *
     * @param image_search_term
     * @param image_url
     * @return true if image added to database
     * @throws SQLException
     */
    public static boolean createImage(String image_search_term, String image_url) throws SQLException {
        con = getConnection();
        PreparedStatement pstmt = con.prepareStatement("INSERT INTO images VALUES (?, ?);");
        pstmt.setString(1, image_search_term);
        pstmt.setString(2, image_url);
        pstmt.execute();
        System.out.println(image_search_term + " : " + image_url + " - was added to DATABASE !");
        return true;
    }

    /**
     * Function returns image by search term
     *
     * @param searchTerm
     * @return existing image if existing
     * @throws SQLException
     */
    public static Image getImageBySearchTerm(String searchTerm) throws SQLException {
        System.out.println("Start getImageBySearchTerm");
        Image result = new Image();
        con = getConnection();
        PreparedStatement pstmt = con.prepareStatement("SELECT * FROM images WHERE search_term = ?");
        pstmt.setString(1, searchTerm);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            String curTerm = rs.getString("search_term");
            String curUrl = rs.getString("url");
            System.out.println(curTerm + " " + curUrl);
            result.setSearchTerm(curTerm);
            result.setUrl(curUrl);
        }
        return result;
    }

    /**
     * Function returns all images from database table 'images'
     *
     * @return list of images
     * @throws SQLException
     */
    public static List<Image> getAllImages() throws SQLException {
        System.out.println("Start getAllImages");
        Statement stmt = null;
        ResultSet rs = null;
        List<Image> listAllImages = new ArrayList<>();
        String sql = "SELECT * FROM images";
        con = getConnection();
        stmt = con.createStatement();
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Image curImage = new Image();
            curImage.setSearchTerm(rs.getString("search_term"));
            curImage.setUrl(rs.getString("url"));
            listAllImages.add(curImage);
        }
        return listAllImages;
    }

}
