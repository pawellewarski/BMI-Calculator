package pl.akademiakodu.BMI;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class HomeController {

    @GetMapping("/")
    public String hello() {
        return "home";
    }

    @GetMapping("/run")
    public String create(
            @RequestParam Double weight,
            @RequestParam Double height,
            ModelMap modelMap) {

        Double bmi = weight / height / height * 10000;

//        mniej niż 16 - wygłodzenie
//        16 - 16.99 - wychudzenie
//        17 - 18.49 - niedowaga
//        18.5 - 24.99 - wartość prawidłowa
//        25 - 29.99 - nadwaga
//        30 - 34.99 - I stopień otyłości
//        35 - 39.99 - II stopień otyłości
//        powyżej 40 - otyłość skrajna

        String answer = bmi < 16 ? "wygłodzenie" :
                bmi < 17 ? "wychudzenie" :
                        bmi < 18.5 ? "niedowaga" :
                                bmi < 25 ? "wartość prawidłowa" :
                                        bmi < 30 ? "nadwaga" :
                                                bmi < 35 ? "II stopień otyłości" :
                                                        bmi < 40 ? "II stopień otyłości" :
                                                                "otyłość skrajna";


        modelMap.put("bmi", bmi);
        modelMap.put("answer", answer);

        return "answer";
    }

    @GetMapping("/calories")
    public String calories() {
        return "calories";
    }


    @GetMapping("/calorieresult")
    public String calorieresult(

            @RequestParam String options,
            @RequestParam Double age,
            @RequestParam Double weight,
            @RequestParam Double height,
            ModelMap modelMap) {
        String answerCalories = "Nie znam wzoru :-(";
        modelMap.put("calorieresult", answerCalories);


        return "calorieresult";
    }


}