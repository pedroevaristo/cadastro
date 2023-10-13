import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Pessoa {
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
}


public class cadastroCliente {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Pessoa> listaPessoa = new HashMap<>();

        System.out.println("Quantidades de clientes:");
        Integer clients = sc.nextInt();

        System.out.println("Digite as seguintes informações");
        for(int i = 0; i < clients; i++) {
            System.out.println("Nome");
                String namePerson = sc.next();
            System.out.println("Sobrenome");
                String surnamePerson = sc.next();
            System.out.println("CEP");
                String cepPerson = sc.next();
            System.out.println("número de telefone");
                String cellPhonePerson = sc.next();


            if (verifyCEP(cepPerson) == true) {
                System.out.println("verificando...achou");
                Pessoa pessoa = new Pessoa(namePerson, surnamePerson,cepPerson,cellPhonePerson);
                listaPessoa.put(i, pessoa);
            } else {
                System.out.println("Não foi encontrado, escreva novamente");
                boolean status =  true;

                while (status) {
                    cepPerson = sc.next();
                    if (cepPerson.length() == 8) {
                        System.out.println("entrou no if while");
                        Pessoa pessoa = new Pessoa(namePerson, surnamePerson,cepPerson,cellPhonePerson);
                        status = false;
                    }
                    //sc.nextLine();

                }
            }
        }
        System.out.printf("Digite entre 0 e %d", clients);
        String type = "";
        boolean status = true;
        while(status) {

            int numeroListaPessoa = sc.nextInt();
            sc.nextLine();

            Pessoa consulta = listaPessoa.get(numeroListaPessoa);

            if(consulta != null){
                System.out.println("Cliente" + numeroListaPessoa +": "+ consulta);
                System.out.println("Quer colocar mais alguma informações nova?");
                if(){
                    break;
                }
            }else{
                System.out.println("Não foi encontrado Quer colocar a informação como novo cadastro?");
                 type = sc.nextLine();
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
//