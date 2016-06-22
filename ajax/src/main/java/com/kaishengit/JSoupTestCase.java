package com.kaishengit;

import com.kaishengit.util.HttpUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by 20330 on 2016/6/21.
 */
public class JSoupTestCase  {
    @Test
    public void testGetImage() throws IOException {
        for(int i=2;i<4;i++) {
            Document document = Jsoup.connect("http://www.topit.me/pop?p="+i).cookie("is_click", "1").get();
            Elements elements = document.select("#content .catalog .e>a");
            for (Element element : elements) {
                String href = element.attr("href");

                Document bigImageDoc = Jsoup.connect(href).cookie("is_click", "1").get();
                Element imageElement = bigImageDoc.select("#content>a").first();
                String imageSrc = imageElement.attr("href");
                System.out.println(imageSrc);
                String fileName = imageSrc.substring(imageSrc.lastIndexOf("/") + 1);
                HttpUtil.getRequestStream(imageSrc, "E:/download/" + fileName);
            }
        }
    }
}
