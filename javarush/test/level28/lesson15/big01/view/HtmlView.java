package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Naatsms on 28.01.2017.
 */
public class HtmlView implements View {
    private Controller controller;
    final private String filePath = "./src/" + this.getClass().getPackage().getName().replace('.', '/') + "/vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies) {
        updateFile(getUpdatedFileContent(vacancies));
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) {
        String result = "";
        try {
            Document doc = getDocument();
            Element temp = doc.getElementsByClass("template").first();
            Element template = temp.clone();
            template.removeClass("template").removeAttr("style");

            doc.getElementsByAttributeValue("class", "vacancy").remove();

            for (Vacancy vac : vacancies) {
                Element vacancy = template.clone();
                vacancy.getElementsByClass("city").first().text(vac.getCity());
                vacancy.getElementsByClass("companyName").first().text(vac.getCompanyName());
                vacancy.getElementsByClass("salary").first().text(vac.getSalary());
                Element link = vacancy.getElementsByTag("a").first();
                link.text(vac.getTitle());
                link.attr("href", vac.getUrl());
                temp.before(vacancy.outerHtml());
            }
            result = doc.html();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Some exception occurred");
        }

        return result;
    }

    private void updateFile(String string){
        try (FileWriter wr = new FileWriter(filePath)) {
            wr.write(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }

}
