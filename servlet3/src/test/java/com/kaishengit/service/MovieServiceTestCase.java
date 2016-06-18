package com.kaishengit.service;

import com.kaishengit.entity.Movie;
import com.kaishengit.util.Page;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Created by 20330 on 2016/6/17.
 */
public class MovieServiceTestCase {
    private Logger logger= LoggerFactory.getLogger(MovieServiceTestCase.class);
    private MovieService movieService=new MovieService();
    @Test
    public void testFindAll(){
        List<Movie> movieList=movieService.findAllMovie();
        assertNotNull(movieList);

    }
    @Test
    public void testFindByPage(){
        Page<Movie> page=movieService.findMovieByPageNo(70);
        for(Movie movie:page.getItems()){
            logger.debug("{}",movie);
        }
        assertEquals(2,page.getItems().size());

    }


}
