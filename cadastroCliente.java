import java.util.Scanner;

class Pessoa{
    private String namePerson;
    private String surnamePerson;
    private String cepPerson;
    private String cellPhonePerson;

    public Pessoa(String namePerson, String surnamePerson, String cepPerson, String cellPhonePerson) {
        this.namePerson = namePerson;
        this.surnamePerson = surnamePerson;
        this.cepPerson = cepPerson;
        this.cellPhonePerson = cellPhonePerson;
    }

//    public String getNamePerson() {
//        return namePerson;
//    }
//
//    public void setNamePerson(String namePerson) {
//        this.namePerson = namePerson;
//    }
//
//    public String getSurnamePerson() {
//        return surnamePerson;
//    }
//
//    public void setSurnamePerson(String surnamePerson) {
//        this.surnamePerson = surnamePerson;
//    }
//
//    public String getCepPerson() {
//        return cepPerson;
//    }
//
//    public void setCepPerson(String cepPerson) {
//        this.cepPerson = cepPerson;
//    }
//
//    public String getCellPhonePerson() {
//        return cellPhonePerson;
//    }
//
//    public void setCellPhonePerson(String cellPhonePerson) {
//        this.cellPhonePerson = cellPhonePerson;
//    }
//}

public class cadastroCliente {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Digite as seguintes informações");

        System.out.println("Nome");
        String namePerson = sc.toString();
        System.out.println("Sobrenome");
        String surnamePerson = sc.toString();
        System.out.println("CEP");
        String cepPerson = sc.toString();
        System.out.println("número de telefone");
        String cellPhonePerson = sc.toString();

        if (verifyCEP(cepPerson) == true) {
            System.out.println("verificando...achou");
        }
        else{
            System.out.println("Não foi encontrado, escreva novamente");

            while(cepPerson.length() == 8){
                cepPerson = "";

                if (cepPerson.length() == 8){
                    cepPerson = sc.toString();
                }
                sc.nextLine();

            }
        }
        sc.close();
    }

    private static boolean verifyCEP(String cepPerson) {
        if (cepPerson.length() == 8) {
            return true;
        } else {
            return false;
        }
    }
}

