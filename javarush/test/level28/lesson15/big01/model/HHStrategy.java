package com.javarush.test.level28.lesson15.big01.model;

/*
  * Created by Naatsms on 28.01.2017.
  * Strategy for hh.ru & hh.ua
*/

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {
    public static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> result = new ArrayList<>();
        int num = 0;
        while (true) {
            try {
                Document doc = getDocument(searchString, num++);
                Elements elements = doc.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
                if (elements.isEmpty()) break;
                for (Element e : elements) {
                    String title = e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").text();
                    String city = e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").text();
                    String companyName = e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text();
                    String siteName = "hh.ua";
                    String url = e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").attr("href");
                    String salary = "";
                    if (!e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").isEmpty()) {
                        salary = e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").text();
                    }
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(title);
                    vacancy.setCity(city);
                    vacancy.setCompanyName(companyName);
                    vacancy.setSiteName(siteName);
                    vacancy.setUrl(url);
                    vacancy.setSalary(salary);
                    result.add(vacancy);
                }
            } catch (IOException e){break;}
        }
        return result;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        String url = String.format(URL_FORMAT, searchString, page);
        Document d = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36")
                .referrer("")
                .get();
        return d;
    }
}
