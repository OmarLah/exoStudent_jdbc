package org.example.student;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class ConsoleIhm {

    Scanner sc = new Scanner(System.in);
    Request request = new Request();

    public void start() {

        int num;

        try {
            do {
                System.out.println();
                System.out.println("=== Menu principal ===");
                System.out.println();
                System.out.println("1) Ajouter un étudiant");
                System.out.println("2) Afficher la totalité des étudiants");
                System.out.println("3) Afficher les étudiants d'une classe");
                System.out.println("4) Supprimer un étudiant");
                System.out.println("0) Quitter");
                System.out.println("Votre choix : ");
                num = sc.nextInt();

                switch (num) {
                    case 1:
                        System.out.println("=== Ajouter un étudiant ===");
                        System.out.println("Quel est le prénom?");
                        sc.nextLine();
                        String firstname = sc.nextLine();
                        System.out.println("Quel est le nom?");
                        String lastname = sc.nextLine();
                        System.out.println("Quel est le numéro de la classe?");
                        int numClass = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Quel est la date du diplôme?");
                        String date = sc.nextLine();
                        request.AddStudent(firstname, lastname, numClass, Date.valueOf(date));
                        break;
                    case 2:
                        System.out.println("=== Afficher la totalité des étudiants ===");
                        System.out.println();
                        System.out.println(request.selectAllStudent());
                        break;
                    case 3:
                        System.out.println("=== Afficher les étudiants d'une classe ===");
                        System.out.println();
                        System.out.println("Quel est la classe dont vous souhaitez avoir la liste?");
                        int numberClass = sc.nextInt();
                        System.out.println(request.SelectStudentByClass(numberClass));
                        break;
                    case 4:
                        System.out.println("=== Supprimer un étudiants ===");
                        System.out.println();
                        System.out.println("Quel est la le numéro de l'étudiant que vous voulez supprimer?");
                        int numberId = sc.nextInt();
                        request.deleteStudent(numberId);
                        break;
                    case 0:
                        System.out.println();
                        System.out.println("Merci de votre visite");
                        System.out.println("***************");
                        System.out.println(" A bientot !!!");
                        System.out.println("***************");
                        break;
                    default:

                }

            } while (num != 0);
        } catch (SQLException e) {
            System.out.println(e.getMessage());


        }

    }
}
