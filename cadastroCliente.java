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

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public String getSurnamePerson() {
        return surnamePerson;
    }

    public void setSurnamePerson(String surnamePerson) {
        this.surnamePerson = surnamePerson;
    }

    public String getCepPerson() {
        return cepPerson;
    }

    public void setCepPerson(String cepPerson) {
        this.cepPerson = cepPerson;
    }

    public String getCellPhonePerson() {
        return cellPhonePerson;
    }

    public void setCellPhonePerson(String cellPhonePerson) {
        this.cellPhonePerson = cellPhonePerson;
    }
}

//fazer alguma lógica para adquirir novos usuários ao invés de substituir. Linhas 79 e 83
public class cadastroCliente {
    private static Map<Integer, Pessoa> listaPessoa = new HashMap<>();
    private static int proxChave = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantidades de clientes:");
        Integer clientes = sc.nextInt();

        System.out.println("Digite as seguintes informações");
        inserirInfo(clientes, proxChave);

        boolean status = true;
        while (status) {
            System.out.println("Digite o numero da lista");
            int numeroListaPessoa = sc.nextInt();
            //sc.nextLine();

            if (listaPessoa.containsKey(numeroListaPessoa)) {
                Pessoa MostrarInfo = listaPessoa.get(numeroListaPessoa);

                System.out.println("indíce : " + numeroListaPessoa);
                System.out.println("Cliente : " + MostrarInfo.getNamePerson() +" "+ MostrarInfo.getSurnamePerson() + "\nNumero de telefone : "+MostrarInfo.getCellPhonePerson());
                System.out.println("CEP : "+ MostrarInfo.getCepPerson());
                System.out.println("Quer colocar novos cadastros, ainda?");
                String escolha = sc.next();

                if (escolha.equals("sim")) {
                    System.out.println("quantos?");
                    Integer novosClientes = sc.nextInt();

                    inserirInfo(novosClientes,proxChave);

                } else if (escolha.equals("nao") || escolha.equals("n")) {
                    System.exit(0);
                }
            } else{
                System.out.println("Não foi encontrado, digite outro numero");
            }

        }
        sc.close();
    }

    private static boolean verificarCEP(String cepPerson) {
        if (cepPerson.length() == 8) {
            return true;
        } else {
            return false;
        }
    }

    private static void inserirInfo(int clientes, int chaveInicial) {
        Scanner sc = new Scanner(System.in);


        for (int i = 0; i < clientes; i++) {
                int chave = chaveInicial + i;
            String idPerson = String.valueOf(i);
            System.out.println("Nome");
            String namePerson = sc.next();
            System.out.println("Sobrenome");
            String surnamePerson = sc.next();
            System.out.println("CEP");
            String cepPerson = sc.next();
            System.out.println("número de telefone");
            String cellPhonePerson = sc.next();


            if (verificarCEP(cepPerson) == true) {
                System.out.println("verificando...achou");
                Pessoa pessoa = new Pessoa(namePerson, surnamePerson, cepPerson, cellPhonePerson);
                listaPessoa.put(chave, pessoa);
            } else {
                System.out.println("Não foi encontrado, escreva novamente");
                boolean status = true;

                while (status) {
                    cepPerson = sc.next();
                    if (cepPerson.length() == 8) {
                        System.out.println("entrou no if while");
                        Pessoa pessoa = new Pessoa(namePerson, surnamePerson, cepPerson, cellPhonePerson);
                        status = false;
                    }
                    //sc.nextLine();

                }
            }
        }
        proxChave = chaveInicial + clientes;
    }
}

