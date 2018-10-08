/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package meet05;

/**
 *
 * @author biobii
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static final int SERVICE_PORT = 13;

    public static void main(String[] args) {
        String NIM, Nama, Asal, Kelas;
        try {
            String hostname = "localhost";
            Socket daytime = new Socket(hostname, SERVICE_PORT);
            System.out.println("Connected!");

            daytime.setSoTimeout(2000);
            Scanner input = new Scanner(System.in);
            OutputStream os = daytime.getOutputStream();
            PrintStream ps = new PrintStream(os);

            System.out.println("+===============+");
            System.out.println("| Masukkan Data |");
            System.out.println("+===============+\n");
            System.out.print("NIM :\t");
            NIM = input.next();
            ps.println(NIM);

            System.out.print("Nama :\t");
            Nama = input.next();
            ps.println(Nama);

            System.out.print("Asal :\t");
            Asal = input.next();
            ps.println(Asal);

            System.out.print("Kelas :\t");
            Kelas = input.next();
            ps.println(Kelas);

            System.out.println("Sent!");

            BufferedReader br1 = new BufferedReader(new InputStreamReader(daytime.getInputStream()));
            System.out.println("Data : " + br1.readLine());
            System.out.println("");
            os.flush();
            os.close();

            daytime.close();

        } catch (IOException ioe) {
            System.out.println("Error : " + ioe);
        }
    }
}
