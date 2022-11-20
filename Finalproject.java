//Course project
// Marwa Toame 1180283
// Rawan Salama 1181034
//Mahmoud Rawagba 1180560



package com.student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Finalproject {

    public static void main(String[] args){
        ArrayList<Process> jobs = new ArrayList<>(); //array to store processes read in from file
        Process process;

        try {
            FileInputStream fstream = new FileInputStream("assignment2.txt");
            Scanner input = new Scanner(fstream);
            String line;
            Scanner info;
            int pid, arrival, cpub; //will store values PID, Arrival Time and CPUBurst for a Process read in from file

            while(input.hasNext()){
                line = input.nextLine();
                info = new Scanner(line);
                pid = Integer.parseInt(info.next()); //PID
                arrival = Integer.parseInt(info.next()); //Arrival Time
                cpub = Integer.parseInt(info.next()); //CPU Burst

                process = new Process(pid, arrival, cpub); //create new Process object
                jobs.add(process); //add process to array
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Scheduling Algorithms to be printed on the console by order
        //First Come First Serve
        FCFS fcfs = new FCFS();
        fcfs.runFCFS(jobs);

        //Shortest Remaining Job First
        SRTF srtf = new SRTF();
        srtf.runSRTF(jobs);

        //Round Robin
        RR rr = new RR();
        rr.runRR(jobs, Integer.parseInt("1"));
    }
}
