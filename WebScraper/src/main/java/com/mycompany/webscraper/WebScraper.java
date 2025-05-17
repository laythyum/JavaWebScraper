/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.webscraper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author VICTUS
 */
public class WebScraper {

    public static void main(String[] args) {

        String url = "https://books.toscrape.com/";
        try {
            Document document = Jsoup.connect(url).get();
            Elements book = document.select(".product_pod");
            System.out.println("=============");
            System.out.println("web scraper");
            for (Element bk : book) {
                String title = bk.select("h3 > a").text();
                String price = bk.select(".price_color").text();
                System.out.println(title + "---" + price);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
