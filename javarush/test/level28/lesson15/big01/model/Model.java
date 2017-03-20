package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.view.View;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Naatsms on 28.01.2017.
 */
public class Model {
    private View view;
    private Provider[] providers;

    public Model(View view, Provider... providers) {
        if (providers == null || providers.length == 0 || view == null) throw new IllegalArgumentException();
        this.view = view;
        this.providers = providers;
    }

    public void selectCity(String city){
        List<Vacancy> result = new ArrayList<>();
        for (Provider pr : providers) {
            result.addAll(pr.getJavaVacancies(city));
        }
        view.update(result);
    }

}
