package oop_paradigm;
import oop_paradigm.views.PrincipalView;

import java.util.Scanner;

public class Aplicacao {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        PrincipalView mainView = new PrincipalView();
        mainView.criarViewPrincipal();
    }
}
