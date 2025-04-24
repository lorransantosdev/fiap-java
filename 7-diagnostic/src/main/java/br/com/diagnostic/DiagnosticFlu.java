package br.com.diagnostic;

import java.util.ArrayList;
import java.util.List;

public class DiagnosticFlu extends Diagnostic {

    public DiagnosticFlu(String disease, List<String> commonSymptomsOfTheDisease, List<String> patientSymptoms) {
        super(disease, commonSymptomsOfTheDisease, patientSymptoms);
    }

    @Override
    public void assessPatientSymptoms() {
        List<String> symptomsEquals = new ArrayList<>(patientSymptoms);
        symptomsEquals.retainAll(commonSymptomsOfTheDisease);

        double probabilityThereIsDisease = (double) symptomsEquals.size() / commonSymptomsOfTheDisease.size() * 100;

        if (probabilityThereIsDisease >= 30) {
            System.out.println("A probabilidade de você estar com " + disease + " é de: " +  String.format("%.2f", probabilityThereIsDisease) + "%, indico que você consulte um médico, pois os seus sintomas batem com estes: ");
            symptomsEquals.forEach(System.out::println);
        } else {
            System.out.println("Esses sintomas podem estar relacionados a outra doença, consulte um médico.");
        }
    }
}
