package projetoleda.com;

import java.util.ArrayList;
import java.util.Random;

import java.util.List;

public class EstudanteFactory {
    private static final Random RANDOM = new Random();
    public static final String[] NOMES = {
            "Ana", "Bruno", "Carlos", "Daniela", "Eduardo", "Fernanda", "Gabriel", "Helena",
            "Igor", "Juliana", "Kaio", "Larissa", "Marcelo", "Natália", "Otávio", "Patrícia",
            "Rafael", "Sabrina", "Thiago", "Vanessa", "William", "Yasmin", "Arthur", "Beatriz",
            "Caio", "Débora", "Enzo", "Felipe", "Giovana", "Hugo", "Isabela", "João",
            "Kevin", "Letícia", "Mateus", "Nicole", "Pedro", "Renata", "Samuel", "Tatiane",
            "Vinícius", "Alice", "Bianca", "Cecília", "Diego", "Elisa", "Fábio", "Gustavo",
            "Henrique", "Íris", "Jéssica", "Kauã", "Leonardo", "Mariana", "Nathan", "Olívia",
            "Paulo", "Raquel", "Sofia", "Tomás", "Valentina", "Wesley", "Zoe", "Adriana",
            "Breno", "Cristina", "Douglas", "Emanuel", "Flávia", "Geovana", "Heitor", "Ingrid",
            "Jonas", "Karen", "Lucas", "Mirela", "Nicolas", "Priscila", "Rodrigo", "Sara",
            "Talita", "Vitor", "Amanda", "Bernardo", "Clara", "Davi", "Esther", "Francisco",
            "Gisele", "Isaac", "Jaqueline", "Luan", "Milena", "Noah", "Pietra", "Ruan",
            "Stella", "Tainá", "Vicente", "Vitória"
    };

    public static final String[] SOBRENOMES = {
            "Silva", "Santos", "Oliveira", "Souza", "Rodrigues", "Ferreira", "Alves",
            "Pereira", "Lima", "Gomes", "Costa", "Ribeiro", "Martins", "Carvalho",
            "Almeida", "Lopes", "Soares", "Fernandes", "Vieira", "Barbosa"
    };

    public static List<Estudante> criarEstudantes(int quantidade){
        List<Estudante> lista = new ArrayList<>();
        for(int i = 0; i < quantidade; i++){
            lista.add(criarEstudante());
        }

        return lista;
    }

    public static Estudante criarEstudante(){
        return new Estudante(
                "20242085100" + RANDOM.nextInt(100),
                NOMES[RANDOM.nextInt(NOMES.length)] + " " +
                        SOBRENOMES[RANDOM.nextInt(SOBRENOMES.length)],
                RANDOM.nextInt(100)
        );
    }

}
