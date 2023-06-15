package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.LogEntry;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o caminho completo do arquivo: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))){ // Bloco try-with-resources.

            Set<LogEntry> set = new HashSet<>(); // HashSet � o mais r�pido.

            String line = br.readLine(); // L� uma linha do objeto br e armazena em line.

            while (line != null) { // Enquanto line for diferente de null.
                String[] fields = line.split(" "); // Separa line onde tiver espa�os e armazena no vetor fields.
                String username = fields[0];

                // Converte o valor de fields[1] em Instant que � covertido para Date e armazenado em moment.
                Date moment = Date.from(Instant.parse(fields[1]));

                set.add(new LogEntry(username, moment)); // Adciiona a cole��o set um novo objeto LogEntry.

                line = br.readLine(); // L� a linha seguinte.

            }
            System.out.println("Total users: " + set.size()); // .size() retorna o tamanho da cole��o que o antecede.


        }
        catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }

}