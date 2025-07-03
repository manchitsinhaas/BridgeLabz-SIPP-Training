import java.util.ArrayList;
import java.util.Scanner;

abstract class Patient {
    private int patientId;
    private String name;
    private int age;
    private String diagnosis;

    public Patient(int patientId, String name, int age, String diagnosis) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    public int getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDiagnosis() { return diagnosis; }

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Diagnosis: " + diagnosis);
        System.out.println("Total Bill: " + calculateBill());
    }

    public abstract double calculateBill();
}

interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double roomRate;
    private ArrayList<String> records = new ArrayList<>();

    public InPatient(int id, String name, int age, String diagnosis, int days, double rate) {
        super(id, name, age, diagnosis);
        this.daysAdmitted = days;
        this.roomRate = rate;
    }

    public double calculateBill() {
        return daysAdmitted * roomRate;
    }

    public void addRecord(String record) {
        records.add(record);
    }

    public void viewRecords() {
        System.out.println("Medical Records:");
        for (String rec : records) System.out.println("- " + rec);
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private ArrayList<String> records = new ArrayList<>();

    public OutPatient(int id, String name, int age, String diagnosis, double fee) {
        super(id, name, age, diagnosis);
        this.consultationFee = fee;
    }

    public double calculateBill() {
        return consultationFee;
    }

    public void addRecord(String record) {
        records.add(record);
    }

    public void viewRecords() {
        System.out.println("Medical Records:");
        for (String rec : records) System.out.println("- " + rec);
    }
}

public class Q7_HospitalPatientManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Patient[] patients = new Patient[2];

        System.out.print("Enter In-Patient ID: ");
        int ipId = sc.nextInt();
        sc.nextLine();
        System.out.print("Name: ");
        String ipName = sc.nextLine();
        System.out.print("Age: ");
        int ipAge = sc.nextInt();
        sc.nextLine();
        System.out.print("Diagnosis: ");
        String ipDiag = sc.nextLine();
        System.out.print("Days Admitted: ");
        int days = sc.nextInt();
        System.out.print("Room Rate: ");
        double rate = sc.nextDouble();
        sc.nextLine();
        InPatient ip = new InPatient(ipId, ipName, ipAge, ipDiag, days, rate);
        ip.addRecord("Initial checkup done");
        ip.addRecord("MRI scheduled");
        patients[0] = ip;

        System.out.print("\nEnter Out-Patient ID: ");
        int opId = sc.nextInt();
        sc.nextLine();
        System.out.print("Name: ");
        String opName = sc.nextLine();
        System.out.print("Age: ");
        int opAge = sc.nextInt();
        sc.nextLine();
        System.out.print("Diagnosis: ");
        String opDiag = sc.nextLine();
        System.out.print("Consultation Fee: ");
        double fee = sc.nextDouble();
        sc.nextLine();
        OutPatient op = new OutPatient(opId, opName, opAge, opDiag, fee);
        op.addRecord("X-ray advised");
        patients[1] = op;

        for (Patient p : patients) {
            p.getPatientDetails();
            if (p instanceof MedicalRecord) {
                ((MedicalRecord) p).viewRecords();
            }
            System.out.println();
        }
    }
}
