package com.checkmarx;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;

@RestController
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView root() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;
    }

    /**
     * Function gets image by term
     * If image not exist in database. First image added to database
     * Then url returned from database by term
     *
     * @param term
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getImage/{term}", method = RequestMethod.GET)
    public ModelAndView getImageBySearchTerm(@PathVariable("term") String term) throws Exception {
        System.out.println("\nSTARTED /getImage/{term}");
        Image image = DBConnector.getImageBySearchTerm(term);

        if (image.getSearchTerm() == null) {
            System.out.println("TERM '" + term + "' not exist in DATABASE!");
            Pixabay pixabay = new Pixabay();
            String imageUrl = pixabay.getUrlByTerm(term);

            DBConnector.createImage(term, imageUrl);
            image = DBConnector.getImageBySearchTerm(term);
        }
        return new ModelAndView("redirect:" + image.getUrl());
    }

    /**
     * Function returns all images from database
     *
     * @return json with all images
     * @throws SQLException
     */
    @RequestMapping(value = "/getAllImages", method = RequestMethod.GET)
    public String getAllImages() throws SQLException {
        System.out.println("\nSTARTED /getAllImages");
        StringBuilder result = new StringBuilder();
        result.append("[");

        List<Image> listAllImages = DBConnector.getAllImages();
        for (Image image : listAllImages) {
            Gson gson = new GsonBuilder().create();
            String json = gson.toJson(image);
            result.append(json);
            if (listAllImages.size() > 1) {
                result.append(", ");
            }
        }

        result.setLength(result.length() - 2);
        result.append("]");
        return result.toString();
    }

}
