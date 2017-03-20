package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Naatsms on 28.01.2017.
 */
public class MoikrugStrategy implements Strategy {
    public static final String URL_FORMAT = "https://moikrug.ru/vacancies?page=%d&q=java+%s";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> result = new ArrayList<>();
        int num = 1;
        while (true) {
            try {
                Document doc = getDocument(searchString, num++);
                Elements elements = doc.getElementsByClass("job");
                if (elements.isEmpty()) break;
                for (Element e : elements) {
                    String title = e.getElementsByClass("title").text();
                    String city = e.getElementsByClass("location").text();
                    String companyName = e.getElementsByClass("company_name").text();
                    String siteName = "https://moikrug.ru";
                    String url = siteName + e.getElementsByClass("title").attr("href");
                    String salary = e.getElementsByClass("salary").text();

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
        String url = String.format(URL_FORMAT, page, searchString);
        Document d = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36")
                .referrer("")
                .get();
        return d;
    }
}
