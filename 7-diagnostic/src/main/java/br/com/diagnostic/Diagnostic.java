package br.com.diagnostic;

import java.util.List;

public abstract class Diagnostic {
    protected String disease;
    protected List<String> commonSymptomsOfTheDisease;
    protected List<String> patientSymptoms;

    public Diagnostic(String disease, List<String> commonSymptomsOfTheDisease, List<String> patientSymptoms) {
        this.disease = disease;
        this.commonSymptomsOfTheDisease = commonSymptomsOfTheDisease;
        this.patientSymptoms = patientSymptoms;
    }

    public void showCommonSymptoms() {
        System.out.println("Os sintomas comuns da " + disease + " são:");
        commonSymptomsOfTheDisease.forEach(System.out::println);
    }

    public abstract void assessPatientSymptoms();
}
